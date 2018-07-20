package com.jesper.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SERVLET_DETECTION_FILTER_ORDER;

/**
 * Created by jiangyunxiong on 2018/7/20.
 *
 *  买家卖家 权限检验
 */
public class AuthFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {  //顺序，越小越靠前
        return SERVLET_DETECTION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();


        /**
         * /order/create 只能买家访问（cookie里有openid）
         * /order/finish 只能卖家访问（cookie里有token， 并且对应的redis中值）
         * /product/list 都可以
         */

        //这里从url参数里获取, 也可以从cookie, header里获取

        return null;
    }
}
