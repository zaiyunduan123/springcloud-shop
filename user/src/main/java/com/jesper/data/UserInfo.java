package com.jesper.data;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;

/**
 * Created by jiangyunxiong on 2018/7/20.
 */
@Data
@Entity
public class UserInfo {
    @Id
    private String id;

    private String username;

    private String password;

    private String openid;

    private Integer role;
}
