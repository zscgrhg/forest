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
import com.frost.forest.pen.model.Users;
import com.frost.forest.pen.model.Authorities;


@Controller
@RequestMapping("/gen/users")
public class UsersController {
    @Autowired
    AbstractFacade<Users> usersFacade;
    @Autowired
    AbstractFacade<Authorities> authoritiesFacade;

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
        PaginationHelper<AbstractFacade<Users>, Users> ph =
                new PaginationHelper<AbstractFacade<Users>, Users>(usersFacade, pageSize, firstRow);
        return new ModelAndView("/gen/users/list","ph",ph);
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
    @ResponseBody
    public ModelAndView detail(@RequestParam String username) {
        return new ModelAndView("/gen/users/detail","users",usersFacade.find(username));
    }

    @RequestMapping(value = "/preedit", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
    @ResponseBody
    public ModelAndView preEdit(@RequestParam String username) {
        Map root = new HashMap();
        root.put("users", usersFacade.find(username));
        //false NONE username
        //false NONE enabled
        //false NONE password
        //true SELECT authoritiesAuthority
        List<Authorities> authorities = authoritiesFacade.findAll();
        root.put("authorities",authorities);
        return new ModelAndView("/gen/users/preedit",root);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute Users users
                                ,@RequestParam("authorities_authority") String  authorities_authority
        ){

        Authorities  authorities_authority_=authoritiesFacade.find(authorities_authority);
        users.setAuthoritiesAuthority(authorities_authority_);
        usersFacade.edit(users);
        return new ModelAndView("/gen/users/detail","users",usersFacade.find(users.getUsername()));

    }

    @RequestMapping(value = "/precreate", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
    @ResponseBody
    public ModelAndView preCreate() {
        Map root = new HashMap();
    //false NONE username
    //false NONE enabled
    //false NONE password
    //true SELECT authoritiesAuthority
        List<Authorities> authorities = authoritiesFacade.findAll();
        root.put("authorities",authorities);
        return new ModelAndView("/gen/users/precreate",root);
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute Users users
        ,@RequestParam("authorities_authority") String  authorities_authority
        ){

        Authorities  authorities_authority_=authoritiesFacade.find(authorities_authority);
        users.setAuthoritiesAuthority(authorities_authority_);
        usersFacade.create(users);
        return new ModelAndView("/gen/users/detail","users",usersFacade.find(users.getUsername()));

    }
    @RequestMapping(value = "/destroy", method = RequestMethod.POST)
    @ResponseBody
    public String destroy(@RequestParam String username) {
        usersFacade.removeById(username);
        return "1";
    }
}
