package com.jesper.service;

import com.jesper.data.ProductCategory;

import java.util.List;

/**
 * Created by jiangyunxiong on 2018/7/10.
 */
public interface CategoryService {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
