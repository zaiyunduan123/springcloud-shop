package com.jesper.service;

import com.jesper.data.ProductInfo;
import com.jesper.product.common.DecreaseStockInput;
import com.jesper.product.common.ProductInfoOutput;

import java.util.List;

/**
 * Created by jiangyunxiong on 2018/7/10.
 */
public interface ProductService {

    /**
     * 查询所有在架商品列表
     */
    List<ProductInfo> findUpAll();

    List<ProductInfoOutput> findList(List<String> productIdList);

    /**
     * 扣库存
     */
    void decreaseStock(List<DecreaseStockInput> decreaseStockInputList);
}
