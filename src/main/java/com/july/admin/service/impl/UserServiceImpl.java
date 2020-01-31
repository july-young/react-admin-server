package com.july.admin.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.july.admin.beans.SnowflakeIdWorker;
import com.july.admin.bo.UserBO;
import com.july.admin.common.Page;
import com.july.admin.config.SecurityConfig;
import com.july.admin.constant.ReactAdminConstant;
import com.july.admin.converter.UserConverter;
import com.july.admin.dao.RelationUserRoleMapper;
import com.july.admin.dao.UserMapper;
import com.july.admin.dto.UserWithRolesDTO;
import com.july.admin.entity.RelationUserRole;
import com.july.admin.entity.RelationUserRoleExample;
import com.july.admin.entity.User;
import com.july.admin.entity.UserExample;
import com.july.admin.exception.ReactAdminBizException;
import com.july.admin.query.UserQuery;
import com.july.admin.service.UserService;
import com.july.admin.util.RACollectionUtils;
import com.july.admin.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.validation.constraints.NotNull;
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

    @Autowired
    private SnowflakeIdWorker snowflakeIdWorker;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private RelationUserRoleMapper relationUserRoleMapper;

    @Override
    public UserBO loadUserByUsername(String userName) {

        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(userName).andStateEqualTo(ReactAdminConstant.MetaState.VALID);
        List<User> users = userMapper.selectByExample(userExample);
        if (CollectionUtils.isEmpty(users)) {
            return null;
        } else {
            User user = users.get(0);
            UserBO userBO = userConverter.convert(user);
            userBO.setPassword(user.getPassword());
            return userBO;
        }
    }

    @Override
    public Page<UserWithRolesDTO> query(UserQuery query) {

        if (query == null) {
            throw new ReactAdminBizException("UserQuery 不能为空！");
        }
        query.check();

        PageHelper.startPage(query.getPage(), query.getSize());

        UserExample userExample = new UserExample();
        userExample.createCriteria().andStateEqualTo(ReactAdminConstant.MetaState.VALID);
        List<User> users = userMapper.selectByExample(userExample);
        List<UserBO> userBOS = userConverter.convert(users);

        return Page.getInstance(new PageInfo(RACollectionUtils.extractList(userBOS, x -> userConverter.toUserWithRolesDTO(x))));
    }

    @Override
    public UserBO find(Long id) {
        User user = userMapper.selectByPrimaryKey(id);
        return userConverter.convert(user);
    }

    @Override
    public Integer create(UserBO userBO) {

        User user = userConverter.revert(userBO);

        long id = snowflakeIdWorker.nextId();
        user.setId(id);
        List<Long> roleIds = RACollectionUtils.extractList(userBO.getAuthorities(), x -> x.getId());

        addUserRolesRelation(id,roleIds);

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        user.setCreator(SecurityUtil.getUserId());
        user.setUpdater(SecurityUtil.getUserId());

        return userMapper.insertSelective(user);
    }

    private void addUserRolesRelation(long userId, List<Long> roleIds) {

        RelationUserRoleExample relationUserRoleExample = new RelationUserRoleExample();
        relationUserRoleExample.createCriteria().andUserIdEqualTo(userId);
        relationUserRoleMapper.deleteByExample(relationUserRoleExample);
        for (Long roleId : roleIds) {

            RelationUserRole relationUserRole = new RelationUserRole();
            relationUserRole.setId(snowflakeIdWorker.nextId());
            relationUserRole.setUserId(userId);
            relationUserRole.setRoleId(roleId);
            relationUserRoleMapper.insert(relationUserRole);
        }
    }

    @Override
    public Integer update(UserBO userBO) {
        User user = userConverter.revert(userBO);

        user.setUpdater(SecurityUtil.getUserId());

        List<Long> roleIds = RACollectionUtils.extractList(userBO.getAuthorities(), x -> x.getId());

        addUserRolesRelation(userBO.getId(),roleIds);

        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public Integer remove(Long id) {
        return userMapper.deleteByPrimaryKey(id);
    }


}
