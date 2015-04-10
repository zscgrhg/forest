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
import com.frost.forest.pen.model.Authorities;
import com.frost.forest.pen.model.Resources;


@Controller
@RequestMapping("/gen/authorities")
public class AuthoritiesController {
    @Autowired
    AbstractFacade<Authorities> authoritiesFacade;
    @Autowired
    AbstractFacade<Resources> resourcesFacade;

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
        PaginationHelper<AbstractFacade<Authorities>, Authorities> ph =
                new PaginationHelper<AbstractFacade<Authorities>, Authorities>(authoritiesFacade, pageSize, firstRow);
        return new ModelAndView("/gen/authorities/list","ph",ph);
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
    @ResponseBody
    public ModelAndView detail(@RequestParam String authority) {
        return new ModelAndView("/gen/authorities/detail","authorities",authoritiesFacade.find(authority));
    }

    @RequestMapping(value = "/preedit", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
    @ResponseBody
    public ModelAndView preEdit(@RequestParam String authority) {
        Map root = new HashMap();
        root.put("authorities", authoritiesFacade.find(authority));
        //false NONE authority
        //true SELECT resourcesCollection
        List<Resources> resources = resourcesFacade.findAll();
        root.put("resources",resources);
        //false NONE usersCollection
        return new ModelAndView("/gen/authorities/preedit",root);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute Authorities authorities
                ,@RequestParam("resources_id") Integer[]  resources_id
                ){

        List<Resources>  resources_id_=resourcesFacade.findByAttrIn(resources_id,"id");
        try {
            System.out.println(Assist.objectMapper.writeValueAsString(resources_id_));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        authorities.setResourcesCollection(resources_id_);
        authoritiesFacade.edit(authorities);
        return new ModelAndView("/gen/authorities/detail","authorities",authoritiesFacade.find(authorities.getAuthority()));

    }

    @RequestMapping(value = "/precreate", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
    @ResponseBody
    public ModelAndView preCreate() {
        Map root = new HashMap();
    //false NONE authority
    //true SELECT resourcesCollection
        List<Resources> resources = resourcesFacade.findAll();
        root.put("resources",resources);
    //false NONE usersCollection
        return new ModelAndView("/gen/authorities/precreate",root);
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute Authorities authorities
        ,@RequestParam("resources_id") Integer[]  resources_id
        ){

        List<Resources>  resources_id_=resourcesFacade.findByAttrIn(resources_id,"id");
        try {
            System.out.println(Assist.objectMapper.writeValueAsString(resources_id_));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        authorities.setResourcesCollection(resources_id_);
        authoritiesFacade.create(authorities);
        return new ModelAndView("/gen/authorities/detail","authorities",authoritiesFacade.find(authorities.getAuthority()));

    }
    @RequestMapping(value = "/destroy", method = RequestMethod.POST)
    @ResponseBody
    public String destroy(@RequestParam String authority) {
        authoritiesFacade.removeById(authority);
        return "1";
    }
}
