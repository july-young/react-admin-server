package com.july.admin.bo;

import com.july.admin.entity.Permission;

/**
 * @author: july
 * @date: 2020/1/7 00:12
 * @description:
 */
public class PermissionBO extends Permission {

    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
