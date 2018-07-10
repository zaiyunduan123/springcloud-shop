package com.jesper.service.impl;

import com.jesper.data.ProductInfo;
import com.jesper.enums.ProductStatusEnum;
import com.jesper.respository.ProductInfoRepository;
import com.jesper.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by jiangyunxiong on 2018/7/10.
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }
}
