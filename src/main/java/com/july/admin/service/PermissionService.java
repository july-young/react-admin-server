package com.july.admin.service;

import com.july.admin.bo.PermissionBO;
import com.july.admin.dto.PermissionTreeDTO;

import java.util.List;

/**
 * @author: july
 * @date: 2020/1/7 00:16
 * @description:
 */
public interface PermissionService {

    /**
     * 获取所有权限
     * @return
     */
    List<PermissionBO> getRolePermissions();

    /**
     * 获取权限树
     * @return
     */
    List<PermissionTreeDTO> getPermissionsInTree();
}
