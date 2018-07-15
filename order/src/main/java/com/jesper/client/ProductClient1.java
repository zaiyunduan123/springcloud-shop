package com.jesper.client;

import com.jesper.data.ProductInfo;
import com.jesper.dto.CartDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Created by jiangyunxiong on 2018/7/14.
 */
@FeignClient(name = "product")
public interface ProductClient1 {

//    @GetMapping("/msg")
//    String productMsg();
//
//    @PostMapping("/product/listForOrder")
//    List<ProductInfo> listForOrder(@RequestBody List<String> productIdList);
//
//    @PostMapping("/product/decreaseStock")
//    void decreaseStock(@RequestBody List<CartDTO> cartDTOList);

}
