package com.myspring.controllers;

import com.myspring.beans.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {


    @Autowired
    private Configuration configuration;

    @RequestMapping(value = {"index", "/"})
    public ModelAndView indexPage() {
        System.out.println(configuration.getDatabase() + " " + configuration.getPassword() +  " " + configuration.getUser());
        return new ModelAndView("index");
    }

    @RequestMapping(value = "pathvariable/{test}", method = RequestMethod.GET)
    public @ResponseBody
    String byParameter(@PathVariable String test) {

        return "this is PathVariable: " + test;
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public String property(@RequestParam("value") String value) {

        return ("redirect:/pathvariable/" + value);
    }


}