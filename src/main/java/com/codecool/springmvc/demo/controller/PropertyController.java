package com.codecool.springmvc.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// sample controller to show how a property can be read
@RestController
// restcontroller = controller + responsebody
@PropertySource("classpath:application.properties")
// classpath = src/main/resources by default
public class PropertyController {

    // you can give a default value here, if the property is not present
    @Value("${my.property:defaultValue}")
    private String myProperty;

    @RequestMapping("/property")
    public String myProperty() {
        return myProperty;
    }

}
