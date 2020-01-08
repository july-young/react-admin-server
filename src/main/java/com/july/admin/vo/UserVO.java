package com.july.admin.vo;

import org.springframework.security.core.Authentication;

import java.io.Serializable;
import java.util.List;

/**
 * @author: july
 * @date: 2020/1/8 23:14
 * @description:
 */
public class UserVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;

    private Long userId;

    private List<String> roles;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
