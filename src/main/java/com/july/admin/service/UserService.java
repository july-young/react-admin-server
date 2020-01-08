package com.july.admin.service;

import com.july.admin.bo.UserBO;

/**
 * @author: july
 * @date: 2020/1/6 00:26
 * @description:
 */
public interface UserService {
    UserBO loadUserByUsername(String userName);
}
