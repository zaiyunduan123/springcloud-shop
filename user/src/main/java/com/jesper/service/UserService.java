package com.jesper.service;

import com.jesper.data.UserInfo;

/**
 * Created by jiangyunxiong on 2018/7/20.
 */
public interface UserService {

    UserInfo findByOpenid(String openid);
}
