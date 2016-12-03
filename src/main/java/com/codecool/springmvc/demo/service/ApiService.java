package com.codecool.springmvc.demo.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class ApiService {

    private static final Logger log = LoggerFactory.getLogger(ApiService.class);

    @Value("${api.url}")
    private String apiUrl;

    @Autowired
    private RestTemplate restTemplate;

    public String getIP() throws URISyntaxException {

        // needed to add headers.
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        // needed so the api won't return 403 for sure.
        headers.add("User-Agent", "SampleApp");
        headers.add("Accept", "application/json");

        RequestEntity request = new RequestEntity(headers, HttpMethod.GET, new URI(apiUrl));

        // here you can pass any object
        ResponseEntity<String> resp = restTemplate.exchange(request, String.class);
        // without headers we could simply use restTemplate.getForObject(url, String.class);

        // will contain status + body + headers
        log.info("Received: {}", resp);

        return resp.getBody();


    }

}
