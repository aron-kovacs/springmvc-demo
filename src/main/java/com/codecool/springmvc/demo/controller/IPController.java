package com.codecool.springmvc.demo.controller;

import com.codecool.springmvc.demo.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;

@RestController
@RequestMapping("/ip")
public class IPController {

    @Autowired
    private ApiService apiService;

    // restrict mapping to GET, and since route is not given here, it will fallback to the
    // one described on the controller itself.
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String ip() throws URISyntaxException {
        return apiService.getIP();
    }

    @ExceptionHandler
    public String handleError(Exception e) {
        return e.getMessage();
    }

}
