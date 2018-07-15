package com.jesper.service.impl;

import com.jesper.data.ProductInfo;
import com.jesper.enums.ProductStatusEnum;
import com.jesper.enums.ResultEnum;
import com.jesper.exception.ProductException;
import com.jesper.product.common.DecreaseStockInput;
import com.jesper.product.common.ProductInfoOutput;
import com.jesper.respository.ProductInfoRepository;
import com.jesper.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public List<ProductInfoOutput> findList(List<String> productIdList) {
        return productInfoRepository.findByProductIdIn(productIdList).stream()
                .map(e -> {
                    ProductInfoOutput output = new ProductInfoOutput();
                    BeanUtils.copyProperties(e, output);
                    return output;
                })
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void decreaseStock(List<DecreaseStockInput> decreaseStockInputList) {
        for (DecreaseStockInput decreaseStockInput : decreaseStockInputList){
            Optional<ProductInfo> productInfoOptional = productInfoRepository.findById(decreaseStockInput.getProductId());
            if (!productInfoOptional.isPresent()){
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            ProductInfo productInfo = productInfoOptional.get();
            Integer result = productInfo.getProductStock() - decreaseStockInput.getProductQuantity();
            if (result < 0){
                throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(result);
            productInfoRepository.save(productInfo);
        }
    }
}
