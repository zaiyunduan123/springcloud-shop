package com.jesper.repository;

import com.jesper.data.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jiangyunxiong on 2018/7/20.
 */
public interface UserInfoRepostory extends JpaRepository<UserInfo, String> {

    UserInfo findByOpenid(String openid);
}
