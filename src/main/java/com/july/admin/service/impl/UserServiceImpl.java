package com.july.admin.service.impl;


import com.july.admin.bo.UserBO;
import com.july.admin.converter.UserConverter;
import com.july.admin.dao.UserMapper;
import com.july.admin.entity.User;
import com.july.admin.entity.UserExample;
import com.july.admin.service.UserService;
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
public class UserServiceImpl implements UserService {

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserBO loadUserByUsername(String userName) {

        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(userName);
        List<User> users = userMapper.selectByExample(userExample);
        return CollectionUtils.isEmpty(users) ? null : userConverter.convert(users.get(0));
    }


}
