package com.july.admin.vo;

import com.july.admin.bo.RoleBO;
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

    private List<RoleBO> roles;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<RoleBO> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleBO> roles) {
        this.roles = roles;
    }
}
