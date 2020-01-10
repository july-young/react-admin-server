package com.july.admin.dto;

import com.july.admin.bo.PermissionBO;

import java.util.List;

/**
 * @author: july
 * @date: 2020/1/10 23:26
 * @description:
 */
public class PermissionTreeDTO extends PermissionBO {

    private List<PermissionTreeDTO> children;

    public List<PermissionTreeDTO> getChildren() {
        return children;
    }

    public void setChildren(List<PermissionTreeDTO> children) {
        this.children = children;
    }
}
