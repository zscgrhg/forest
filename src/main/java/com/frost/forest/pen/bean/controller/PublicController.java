package com.frost.forest.pen.bean.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by wenkui on 2015/4/4.
 */
@Controller
@RequestMapping("/rest")
public class PublicController {
    @RequestMapping("/")
    public ModelAndView sayHello(){
        return new ModelAndView("/hello", "users", "haha");
    }
}
