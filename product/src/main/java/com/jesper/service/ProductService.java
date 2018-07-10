package com.jesper.service;

import com.jesper.data.ProductInfo;

import java.util.List;

/**
 * Created by jiangyunxiong on 2018/7/10.
 */
public interface ProductService {

    /**
     * 查询所有在架商品列表
     */
    List<ProductInfo> findUpAll();


}
