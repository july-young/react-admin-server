package com.july.admin.service;

import com.july.admin.bo.UserBO;

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
}
