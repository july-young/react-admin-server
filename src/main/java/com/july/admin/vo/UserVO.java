package com.july.admin.vo;

import com.july.admin.bo.RoleBO;
import com.july.admin.common.ToString;
import org.springframework.security.core.Authentication;

import java.io.Serializable;
import java.util.List;

/**
 * @author: july
 * @date: 2020/1/8 23:14
 * @description:
 */
public class UserVO extends ToString {

    private String username;

    private Long userId;

    private String phone;

    private String email;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
