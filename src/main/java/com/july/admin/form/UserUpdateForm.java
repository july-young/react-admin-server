package com.july.admin.form;

import com.july.admin.bo.RoleBO;
import com.july.admin.bo.UserBO;
import com.july.admin.common.FormConverter;
import com.july.admin.util.RACollectionUtils;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * @author: july
 * @date: 2020/1/31 16:13
 * @description:
 */
public class UserUpdateForm implements FormConverter<UserBO> {
    private Long id;
    private String username;

    private String phone;

    private String email;

    private List<Long> roleIds;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public List<Long> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Long> roleIds) {
        this.roleIds = roleIds;
    }



    @Override
    public UserBO toBO() {
        UserBO userBO = new UserBO();
        BeanUtils.copyProperties(this,userBO);
        List<RoleBO> roleBOS = RACollectionUtils.extractList(getRoleIds(), x -> {
            RoleBO roleBO = new RoleBO();
            roleBO.setId(x);
            return roleBO;
        });
        userBO.setAuthorities(roleBOS);
        return userBO;
    }
}
