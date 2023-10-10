package com.aldob.app.weatherapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/app")
public class controller {

    @GetMapping(value = "/")
    public String index() {
        return "welcome";
    }

    @RequestMapping(value = "/welcome")
    public String welcome() {
        return "welcome";
    }

    @RequestMapping(value = "/about")
    public String about() {
        return "about";
    }

}
