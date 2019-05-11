package com.myspring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @RequestMapping(value = {"index", "/", "siginin"})
    public ModelAndView indexPage() {
        return new ModelAndView("auth/login");
    }

    @RequestMapping(value = {"register"})
    public ModelAndView registerPage() {
        return new ModelAndView("auth/register");
    }


}