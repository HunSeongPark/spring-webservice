package com.hunseong.webservice.config.auth.dto;

import com.hunseong.webservice.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

/**
 * Created by Hunseong on 2022/04/24
 */
@Getter
public class SessionUser implements Serializable {

    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
