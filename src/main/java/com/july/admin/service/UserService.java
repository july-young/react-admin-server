package com.july.admin.service;

import com.july.admin.bo.UserBO;
import com.july.admin.common.Page;
import com.july.admin.dto.UserWithRolesDTO;
import com.july.admin.query.UserQuery;

/**
 * @author: july
 * @date: 2020/1/6 00:26
 * @description:
 */
public interface UserService {
    /**
     * 根据 登录名 查找登陆人信息
     * @param userName
     * @return
     */
    UserBO loadUserByUsername(String userName);

    /**
     * 分页查询
     * @param query
     * @return
     */
    Page<UserWithRolesDTO> query(UserQuery query);

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    UserBO find(Long id);

    /**
     * 添加
     * @param userBO
     * @return
     */
    Integer create(UserBO userBO);

    /**
     * 更新
     * @param userBO
     * @return
     */
    Integer update(UserBO userBO);

    /**
     * 删除
     * @param id
     * @return
     */
    Integer remove(Long id);
}
