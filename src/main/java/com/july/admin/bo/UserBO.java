package com.july.admin.bo;

import com.july.admin.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.List;

public class UserBO extends User implements UserDetails, Serializable {

    private List<RoleBO> authorities;

    @Override
    public List<RoleBO> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<RoleBO> authorities) {
        this.authorities = authorities;
    }

    /**
     * 用户账号是否过期
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 用户账号是否被锁定
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 用户密码是否过期
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 用户是否可用
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
    
}