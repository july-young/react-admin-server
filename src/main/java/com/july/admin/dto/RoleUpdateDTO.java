package com.july.admin.dto;

import com.july.admin.common.ToString;

import java.util.List;

/**
 * @author: july
 * @date: 2020/1/31 13:51
 * @description:
 */
public class RoleUpdateDTO extends ToString {

    private String roleId;

    private List<Long> menuKeys;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public List<Long> getMenuKeys() {
        return menuKeys;
    }

    public void setMenuKeys(List<Long> menuKeys) {
        this.menuKeys = menuKeys;
    }
}
