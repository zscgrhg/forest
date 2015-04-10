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
import com.frost.forest.pen.model.Resources;


@Controller
@RequestMapping("/gen/resources")
public class ResourcesController {
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
        PaginationHelper<AbstractFacade<Resources>, Resources> ph =
                new PaginationHelper<AbstractFacade<Resources>, Resources>(resourcesFacade, pageSize, firstRow);
        return new ModelAndView("/gen/resources/list","ph",ph);
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
    @ResponseBody
    public ModelAndView detail(@RequestParam Integer id) {
        return new ModelAndView("/gen/resources/detail","resources",resourcesFacade.find(id));
    }

    @RequestMapping(value = "/preedit", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
    @ResponseBody
    public ModelAndView preEdit(@RequestParam Integer id) {
        Map root = new HashMap();
        root.put("resources", resourcesFacade.find(id));
        //false NONE id
        //false NONE type
        //false NONE url
        //false NONE authoritiesCollection
        return new ModelAndView("/gen/resources/preedit",root);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute Resources resources
                                ){

        resourcesFacade.edit(resources);
        return new ModelAndView("/gen/resources/detail","resources",resourcesFacade.find(resources.getId()));

    }

    @RequestMapping(value = "/precreate", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
    @ResponseBody
    public ModelAndView preCreate() {
        Map root = new HashMap();
    //false NONE id
    //false NONE type
    //false NONE url
    //false NONE authoritiesCollection
        return new ModelAndView("/gen/resources/precreate",root);
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute Resources resources
        ){

        resourcesFacade.create(resources);
        return new ModelAndView("/gen/resources/detail","resources",resourcesFacade.find(resources.getId()));

    }
    @RequestMapping(value = "/destroy", method = RequestMethod.POST)
    @ResponseBody
    public String destroy(@RequestParam Integer id) {
        resourcesFacade.removeById(id);
        return "1";
    }
}
