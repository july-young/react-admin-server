package com.july.admin.service;

import com.july.admin.bo.RoleBO;
import com.july.admin.common.Page;
import com.july.admin.query.RoleQuery;

import java.util.List;

/**
 * @author: july
 * @date: 2020/1/6 00:27
 * @description:
 */
public interface RoleService {
    /**
     * 根据用户Id查找角色
     * @param id
     * @return
     */
    List<RoleBO> getRolesByUserId(Long id);

    /**
     * 根据id结合查找
     * @param roleIds
     * @return
     */
    List<RoleBO> getRolesByIds(List<Long> roleIds);

    /**
     * 分页查找
     * @param query
     * @return
     */
    Page<RoleBO> query(RoleQuery query);

    RoleBO create(RoleBO roleBO);

    RoleBO update(RoleBO roleBO);

    Integer remove(Long id);

    RoleBO find(Long id);
}
