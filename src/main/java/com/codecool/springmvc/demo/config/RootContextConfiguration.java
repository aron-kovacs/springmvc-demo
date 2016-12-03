package com.codecool.springmvc.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/*
 * Sets up root application context
 */
@Configuration
@ComponentScan({
        "com.codecool.springmvc.demo.controller",
        "com.codecool.springmvc.demo.service"
})
public class RootContextConfiguration {

    // restTemplate have to be explicitly defined,
    // global configuration can be done here.
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
