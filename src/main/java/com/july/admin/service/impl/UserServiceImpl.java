package com.july.admin.service.impl;


import com.july.admin.bo.UserBO;
import com.july.admin.common.Converter;
import com.july.admin.dao.UserMapper;
import com.july.admin.entity.User;
import com.july.admin.entity.UserExample;
import com.july.admin.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author: july
 * @date: 2020/1/6 00:30
 * @description:
 */
@Service
public class UserServiceImpl implements UserService, Converter<User, UserBO> {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserBO loadUserByUsername(String userName) {

        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(userName);
        List<User> users = userMapper.selectByExample(userExample);
        return CollectionUtils.isEmpty(users) ? null : convert(users.get(0));
    }

    @Override
    public UserBO convert(User d) {
        if (d == null) {
            return null;
        }
        UserBO userBO = new UserBO();
        BeanUtils.copyProperties(d, userBO);
        return userBO;
    }

    @Override
    public User revert(UserBO b) {
        if (b == null) {
            return null;
        }
        User user = new User();
        BeanUtils.copyProperties(b, user);
        return user;
    }
}
