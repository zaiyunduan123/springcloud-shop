package com.jesper.service.impl;

import com.jesper.data.UserInfo;
import com.jesper.repository.UserInfoRepostory;
import com.jesper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jiangyunxiong on 2018/7/20.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoRepostory userInfoRepostory;

    @Override
    public UserInfo findByOpenid(String openid) {
        return userInfoRepostory.findByOpenid(openid);
    }
}
