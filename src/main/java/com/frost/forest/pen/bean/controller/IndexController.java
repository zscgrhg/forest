package com.frost.forest.pen.bean.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wenkui on 2015/4/4.
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public ModelAndView sayHello(){
        return index();
    }
    @RequestMapping("/index")
    public ModelAndView index(){
        return new ModelAndView("/index", "users", "haha");
    }

    @RequestMapping("/logout")
    public ModelAndView logout(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws IOException, ServletException {
        try {
            httpServletRequest.logout();
            httpServletResponse.sendRedirect("/");
        } catch (ServletException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/login")
    public ModelAndView login(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws IOException, ServletException {

        return new ModelAndView("/login");
    }
}
