package com.jesper.respository;

import com.jesper.data.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jiangyunxiong on 2018/7/10.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void findByProductStatus() throws Exception{
      List<ProductInfo> infos = productInfoRepository.findByProductStatus(0);
        System.out.println(infos);
    }

    @Test
    public void findByProductIdIn(){

        List<ProductInfo> productInfos = productInfoRepository.findByProductIdIn(Arrays.asList("157875196366160022", "157875227953464068"));
        for (ProductInfo p : productInfos){
            System.out.println(p.getProductName());
        }
    }
}
