package com.jesper.exception;

import com.jesper.enums.ResultEnum;

/**
 * Created by jiangyunxiong on 2018/7/15.
 */
public class ProductException extends RuntimeException{

    private Integer code;

    public ProductException(Integer code, String message){
        super(message);
        this.code = code;
    }

    public ProductException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
