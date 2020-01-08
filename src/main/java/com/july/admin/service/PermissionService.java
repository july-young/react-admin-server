package com.july.admin.service;

import com.july.admin.bo.PermissionBO;

import java.util.List;

/**
 * @author: july
 * @date: 2020/1/7 00:16
 * @description:
 */
public interface PermissionService {
    List<PermissionBO> getRolePermissions();
}
