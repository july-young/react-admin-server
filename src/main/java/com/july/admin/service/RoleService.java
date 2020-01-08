package com.july.admin.service;

import com.july.admin.bo.RoleBO;

import java.util.List;

/**
 * @author: july
 * @date: 2020/1/6 00:27
 * @description:
 */
public interface RoleService {
    List<RoleBO> getRolesByUserId(Long id);

    List<RoleBO> getRolesByIds(List<Long> roleIds);
}
