package com.july.admin.service;

import com.july.admin.bo.PermissionBO;
import com.july.admin.dto.PermissionTreeDTO;
import com.july.admin.query.MenuQuery;

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
     * 获取所有菜单
     * @return
     */
    List<PermissionBO> getMenus();

    /**
     * 获取权限树
     * @return
     */
    List<PermissionTreeDTO> getPermissionsInTree();

    /**
     * 查询权限
     * @param query
     * @return
     */
    List<PermissionBO> getMenus(MenuQuery query);
}
