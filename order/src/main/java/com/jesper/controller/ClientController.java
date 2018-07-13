package com.jesper.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by jiangyunxiong on 2018/7/13.
 */
@RestController
@Slf4j
public class ClientController {

    @GetMapping("/getProductMsg")
    public String getProductMsg(){
        // 1、第一种
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject("http://localhost:8080/msg", String.class);
        log.info("response={}", response);
        return response;

    }
}
