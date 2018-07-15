package com.jesper.utils;

import com.jesper.vo.ResultVO;

/**
 * Created by jiangyunxiong on 2018/7/10.
 */
public class ResultVOUtil {
    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }
}
