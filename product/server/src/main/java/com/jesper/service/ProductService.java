package com.jesper.service;

import com.jesper.data.ProductInfo;
import com.jesper.dto.CartDTO;

import java.util.List;

/**
 * Created by jiangyunxiong on 2018/7/10.
 */
public interface ProductService {

    /**
     * 查询所有在架商品列表
     */
    List<ProductInfo> findUpAll();

    List<ProductInfo> findList(List<String> productIdList);

    /**
     * 扣库存
     * @param cartDTOList
     */
    void decreaseStock(List<CartDTO> cartDTOList);
}
