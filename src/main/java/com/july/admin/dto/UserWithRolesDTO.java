package com.july.admin.dto;

import com.july.admin.bo.RoleBO;
import com.july.admin.common.ToString;
import com.july.admin.entity.Role;

import java.util.Date;
import java.util.List;

/**
 * @author: july
 * @date: 2020/1/31 18:41
 * @description:
 */
public class UserWithRolesDTO extends ToString{

    private Long userId;

    private String username;

    private Date gmtCreate;

    private String phone;

    private String email;

    private List<Role> roles;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
