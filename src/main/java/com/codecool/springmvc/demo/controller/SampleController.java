package com.codecool.springmvc.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// just some dummy controller with responsebody
@Controller
public class SampleController {

    @ResponseBody
    @RequestMapping("/hello")
    public String sayHello() {
        return "hello";
    }

}
