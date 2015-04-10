package com.frost.forest.gen.bean.controller;

import com.frost.forest.gen.cgmain.Assist;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.frost.forest.pen.bean.service.AbstractFacade;
import com.frost.forest.pen.utils.PaginationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import ${model.fullName};
<#list headers as h>
<#if h.assistant>
import ${h.entityClassName};
</#if>
</#list>


@Controller
@RequestMapping("/gen/${a2l(model.getSimpleName())}")
public class ${model.getSimpleName()}Controller {
    @Autowired
    AbstractFacade<${model.getSimpleName()}> ${f2l(model.getSimpleName())}Facade;
    <#list headers as h>
    <#if h.assistant>
    @Autowired
    AbstractFacade<${h.entitySimpleName}> ${f2l(h.entitySimpleName)}Facade;
    </#if>
    </#list>

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
    @ResponseBody
    public ModelAndView autoIndex(HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.setStatus(302);
        httpServletResponse.sendRedirect("/");
        return null;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
    @ResponseBody
    public ModelAndView index() {
        return list(0,10);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
    @ResponseBody
    public ModelAndView list(@RequestParam(defaultValue = "0", required = false) final int firstRow,
                                            @RequestParam(defaultValue = "10", required = false) final int pageSize) {
        PaginationHelper<AbstractFacade<${model.getSimpleName()}>, ${model.getSimpleName()}> ph =
                new PaginationHelper<AbstractFacade<${model.getSimpleName()}>, ${model.getSimpleName()}>(${f2l(model.getSimpleName())}Facade, pageSize, firstRow);
        return new ModelAndView("/gen/${a2l(model.getSimpleName())}/list","ph",ph);
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
    @ResponseBody
    public ModelAndView detail(@RequestParam ${model.entityIdType} ${model.getSimpleId()}) {
        return new ModelAndView("/gen/${a2l(model.getSimpleName())}/detail","${f2l(model.getSimpleName())}",${f2l(model.getSimpleName())}Facade.find(${model.getSimpleId()}));
    }

    @RequestMapping(value = "/preedit", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
    @ResponseBody
    public ModelAndView preEdit(@RequestParam ${model.entityIdType} ${model.getSimpleId()}) {
        Map root = new HashMap();
        root.put("${a2l(model.getSimpleName())}", ${f2l(model.getSimpleName())}Facade.find(${model.getSimpleId()}));
        <#list headers as h>
        //${h.isSelectAssistant()?string} ${h.assistStrategy} ${h.reference}
        <#if h.isSelectAssistant() && (h.entityClassName!=model.fullName)>
        List<${h.entitySimpleName}> ${a2l(h.entitySimpleName)} = ${f2l(h.entitySimpleName)}Facade.findAll();
        root.put("${a2l(h.entitySimpleName)}",${a2l(h.entitySimpleName)});
        </#if>
        </#list>
        return new ModelAndView("/gen/${a2l(model.getSimpleName())}/preedit",root);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute ${model.getSimpleName()} ${f2l(model.getSimpleName())}
        <#list headers as h>
        <#if h.assistant>
        <#if h.collection>
        ,@RequestParam("${f2l(h.requestParamName)}") ${h.entityIdType}[]  ${f2l(h.requestParamName)}
        <#else >
        ,@RequestParam("${f2l(h.requestParamName)}") ${h.entityIdType}  ${f2l(h.requestParamName)}
        </#if>
        </#if>
        </#list>){

        <#list headers as h>
        <#if h.assistant>
        <#if h.collection>
        List<${h.entitySimpleName}>  ${f2l(h.requestParamName)}_=${f2l(h.entitySimpleName)}Facade.findByAttrIn(${f2l(h.requestParamName)},"${h.entityId}");
        try {
            System.out.println(Assist.objectMapper.writeValueAsString(${f2l(h.requestParamName)}_));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        ${f2l(model.getSimpleName())}.${h.setterName}(${f2l(h.requestParamName)}_);
        <#else >
        ${h.entitySimpleName}  ${f2l(h.requestParamName)}_=${f2l(h.entitySimpleName)}Facade.find(${f2l(h.requestParamName)});
        ${f2l(model.getSimpleName())}.${h.setterName}(${f2l(h.requestParamName)}_);
        </#if>
        </#if>
        </#list>
        ${f2l(model.getSimpleName())}Facade.edit(${f2l(model.getSimpleName())});
        return new ModelAndView("/gen/${a2l(model.getSimpleName())}/detail","${a2l(model.getSimpleName())}",${f2l(model.getSimpleName())}Facade.find(${f2l(model.getSimpleName())}.get${f2u(model.getSimpleId())}()));

    }

    @RequestMapping(value = "/precreate", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
    @ResponseBody
    public ModelAndView preCreate() {
        Map root = new HashMap();
    <#list headers as h>
    //${h.isSelectAssistant()?string} ${h.assistStrategy} ${h.reference}
    <#if h.isSelectAssistant() && (h.entityClassName!=model.fullName)>
        List<${h.entitySimpleName}> ${a2l(h.entitySimpleName)} = ${f2l(h.entitySimpleName)}Facade.findAll();
        root.put("${a2l(h.entitySimpleName)}",${a2l(h.entitySimpleName)});
    </#if>
    </#list>
        return new ModelAndView("/gen/${a2l(model.getSimpleName())}/precreate",root);
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute ${model.getSimpleName()} ${f2l(model.getSimpleName())}
<#list headers as h>
    <#if h.assistant>
        <#if h.collection>
        ,@RequestParam("${f2l(h.requestParamName)}") ${h.entityIdType}[]  ${f2l(h.requestParamName)}
        <#else >
        ,@RequestParam("${f2l(h.requestParamName)}") ${h.entityIdType}  ${f2l(h.requestParamName)}
        </#if>
    </#if>
</#list>
        ){

<#list headers as h>
    <#if h.assistant>
        <#if h.collection>
        List<${h.entitySimpleName}>  ${f2l(h.requestParamName)}_=${f2l(h.entitySimpleName)}Facade.findByAttrIn(${f2l(h.requestParamName)},"${h.entityId}");
        try {
            System.out.println(Assist.objectMapper.writeValueAsString(${f2l(h.requestParamName)}_));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        ${f2l(model.getSimpleName())}.${h.setterName}(${f2l(h.requestParamName)}_);
        <#else >
        ${h.entitySimpleName}  ${f2l(h.requestParamName)}_=${f2l(h.entitySimpleName)}Facade.find(${f2l(h.requestParamName)});
        ${f2l(model.getSimpleName())}.${h.setterName}(${f2l(h.requestParamName)}_);
        </#if>
    </#if>
</#list>
        ${f2l(model.getSimpleName())}Facade.create(${f2l(model.getSimpleName())});
        return new ModelAndView("/gen/${a2l(model.getSimpleName())}/detail","${a2l(model.getSimpleName())}",${f2l(model.getSimpleName())}Facade.find(${f2l(model.getSimpleName())}.get${f2u(model.getSimpleId())}()));

    }
    @RequestMapping(value = "/destroy", method = RequestMethod.POST)
    @ResponseBody
    public String destroy(@RequestParam ${model.entityIdType} ${model.getSimpleId()}) {
        ${f2l(model.getSimpleName())}Facade.removeById(${model.getSimpleId()});
        return "1";
    }
}
