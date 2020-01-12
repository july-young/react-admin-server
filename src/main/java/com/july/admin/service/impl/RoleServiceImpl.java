package com.july.admin.service.impl;

import com.july.admin.bo.RoleBO;
import com.july.admin.bo.UserBO;
import com.july.admin.common.Converter;
import com.july.admin.converter.RoleConverter;
import com.july.admin.dao.RelationRolePermissionMapper;
import com.july.admin.dao.RelationUserRoleMapper;
import com.july.admin.dao.RoleMapper;
import com.july.admin.entity.*;
import com.july.admin.service.PermissionService;
import com.july.admin.service.RoleService;
import com.july.admin.util.ReactAdminCollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author: july
 * @date: 2020/1/6 00:29
 * @description:
 */
@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RelationUserRoleMapper relationUserRoleMapper;
    @Autowired
    private RelationRolePermissionMapper relationRolePermissionMapper;
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private RoleConverter roleConverter;


    @Override
    public List<RoleBO> getRolesByUserId(Long id) {

        RelationUserRoleExample relationUserRoleExample = new RelationUserRoleExample();

        relationUserRoleExample.createCriteria().andUserIdEqualTo(id);

        List<RelationUserRole> relationUserRoles = relationUserRoleMapper.selectByExample(relationUserRoleExample);

        List<Long> idList = ReactAdminCollectionUtils.extractList(relationUserRoles, x -> x.getRoleId());
        return getRolesByIds(idList);
    }

    @Override
    public List<RoleBO> getRolesByIds(List<Long> roleIds) {

        RoleExample roleExample = new RoleExample();

        roleExample.createCriteria().andIdIn(roleIds);

        List<Role> roles = roleMapper.selectByExample(roleExample);

        return roleConverter.convert(roles);
    }


}
