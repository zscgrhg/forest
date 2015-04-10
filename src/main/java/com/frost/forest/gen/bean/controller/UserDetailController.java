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
import com.frost.forest.pen.model.UserDetail;


@Controller
@RequestMapping("/gen/userdetail")
public class UserDetailController {
    @Autowired
    AbstractFacade<UserDetail> userDetailFacade;

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
        PaginationHelper<AbstractFacade<UserDetail>, UserDetail> ph =
                new PaginationHelper<AbstractFacade<UserDetail>, UserDetail>(userDetailFacade, pageSize, firstRow);
        return new ModelAndView("/gen/userdetail/list","ph",ph);
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
    @ResponseBody
    public ModelAndView detail(@RequestParam String username) {
        return new ModelAndView("/gen/userdetail/detail","userDetail",userDetailFacade.find(username));
    }

    @RequestMapping(value = "/preedit", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
    @ResponseBody
    public ModelAndView preEdit(@RequestParam String username) {
        Map root = new HashMap();
        root.put("userdetail", userDetailFacade.find(username));
        //false NONE displayName
        //false NONE company
        //false NONE companyTel
        //false NONE fullname
        //false NONE tel
        //false NONE profession
        //false NONE city
        //false NONE address
        //false NONE introduce
        //false NONE username
        return new ModelAndView("/gen/userdetail/preedit",root);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute UserDetail userDetail
                                                                                ){

        userDetailFacade.edit(userDetail);
        return new ModelAndView("/gen/userdetail/detail","userdetail",userDetailFacade.find(userDetail.getUsername()));

    }

    @RequestMapping(value = "/precreate", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
    @ResponseBody
    public ModelAndView preCreate() {
        Map root = new HashMap();
    //false NONE displayName
    //false NONE company
    //false NONE companyTel
    //false NONE fullname
    //false NONE tel
    //false NONE profession
    //false NONE city
    //false NONE address
    //false NONE introduce
    //false NONE username
        return new ModelAndView("/gen/userdetail/precreate",root);
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute UserDetail userDetail
        ){

        userDetailFacade.create(userDetail);
        return new ModelAndView("/gen/userdetail/detail","userdetail",userDetailFacade.find(userDetail.getUsername()));

    }
    @RequestMapping(value = "/destroy", method = RequestMethod.POST)
    @ResponseBody
    public String destroy(@RequestParam String username) {
        userDetailFacade.removeById(username);
        return "1";
    }
}
