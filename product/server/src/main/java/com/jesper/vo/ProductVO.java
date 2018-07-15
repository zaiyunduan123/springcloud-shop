package com.jesper.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by jiangyunxiong on 2018/7/10.
 */
@Data
public class ProductVO {

    @JsonProperty("name")//返回前端是name
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    List<ProductInfoVO> productInfoVOList;
}
