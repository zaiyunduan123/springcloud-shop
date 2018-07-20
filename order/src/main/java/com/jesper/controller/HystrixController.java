package com.jesper.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * Created by jiangyunxiong on 2018/7/20.
 * <p>
 * 使用Hystrix实现服务降级
 */
@RestController
public class HystrixController {

    @GetMapping("getProductInfoList")
    public String getProductInfoList() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject("http://127.0.0.1:8080/product/listForOrder",
                Arrays.asList("157875196366160022"), String.class);
    }
}
