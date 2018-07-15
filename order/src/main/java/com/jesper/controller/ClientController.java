package com.jesper.controller;

import com.jesper.client.ProductClient1;
import com.jesper.data.ProductInfo;
import com.jesper.dto.CartDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jiangyunxiong on 2018/7/13.
 */
@RestController
@Slf4j
public class ClientController {

//    @Autowired
//    private LoadBalancerClient loadBalancerClient;
//
//    @Autowired
//    private ProductClient1 productClient;
//
//
//    @GetMapping("getProductMsg")
//    public String getProductMsg() {
//        String response = productClient.productMsg();
//        log.info("response={}", response);
//        return response;
//
//    }
//
//    @GetMapping("getProductList")
//    public String getProductList(){
//        List<ProductInfo> productInfos = productClient.listForOrder(Arrays.asList("157875196366160022", "157875227953464068"));
//        log.info("response={}", productInfos);
//        return "OK";
//    }
//
//
//
//
//
//
//    @GetMapping("/getProductMsg1")
//    public String getProductMsg1() {
//        // 1、第一种（直接使用restTemplate，url写死）
////        RestTemplate restTemplate = new RestTemplate();
////        String response = restTemplate.getForObject("http://localhost:8080/msg", String.class);
//
//        // 2. 第二种（利用loadBalanceClient通过应用名获取url，然后在使用restTemplate）
//        RestTemplate restTemplate1 = new RestTemplate();
//        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
//        String url = String.format("http://%s:%s", serviceInstance.getHost(), serviceInstance.getPort());
//        String response1 = restTemplate1.getForObject(url, String.class);
//
//        log.info("response={}", response1);
//        return response1;
//
//    }
//
//
//    @GetMapping("/decreaseStock")
//    public String decreaseStock(){
//        productClient.decreaseStock(Arrays.asList(new CartDTO("157875196366160022", 1)));
//        return "ok";
//    }
}
