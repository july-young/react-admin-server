package com.july.admin.service.impl;

import com.july.admin.bo.PermissionBO;
import com.july.admin.bo.RoleBO;
import com.july.admin.common.Converter;
import com.july.admin.constant.ReactAdminConstant;
import com.july.admin.dao.PermissionMapper;
import com.july.admin.dao.RelationRolePermissionMapper;
import com.july.admin.dao.RoleMapper;
import com.july.admin.entity.*;
import com.july.admin.service.PermissionService;
import com.july.admin.service.RoleService;
import com.july.admin.util.ReactAdminCollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author: july
 * @date: 2020/1/7 00:16
 * @description:
 */
@Service
public class PermissionServiceImpl implements PermissionService, Converter<Permission, PermissionBO> {
    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RelationRolePermissionMapper relationRolePermissionMapper;

    @Override
    public List<PermissionBO> getRolePermissions() {

        PermissionExample permissionExample = new PermissionExample();
        permissionExample.createCriteria().andStateEqualTo(ReactAdminConstant.MetaState.VALID);
        List<Permission> permissions = permissionMapper.selectByExample(permissionExample);
        return convert(permissions);
    }

    public List<PermissionBO> convert(List<Permission> permissions) {
        if (CollectionUtils.isEmpty(permissions)) {
            return new ArrayList<>();
        }
        RelationRolePermissionExample relationRolePermissionExample = new RelationRolePermissionExample();
        relationRolePermissionExample.createCriteria().andPermissionIdIn(ReactAdminCollectionUtils.extractList(permissions, x -> x.getId()));
        List<RelationRolePermission> relationRolePermissions = relationRolePermissionMapper.selectByExample(relationRolePermissionExample);

        RoleExample roleExample = new RoleExample();
        roleExample.createCriteria().andStateEqualTo(ReactAdminConstant.MetaState.VALID)
                .andIdIn(ReactAdminCollectionUtils.extractList(relationRolePermissions, x -> x.getRoleId()));
        List<Role> roles = roleMapper.selectByExample(roleExample);

        Map<Long, Long> relationMap = relationRolePermissions.stream().collect(Collectors.toMap(RelationRolePermission::getPermissionId, RelationRolePermission::getRoleId));
        Map<Long, String> roleMap = ReactAdminCollectionUtils.toMap(roles, x -> x.getId(), x -> x.getName());

        return permissions.stream().map(x -> {
            PermissionBO permissionBO = convert(x);
            Long roleId = relationMap.get(x);
            if (roleId != null) {
                permissionBO.setRoleName(roleMap.get(roleId));
            }
            return permissionBO;
        }).collect(Collectors.toList());
    }

    @Override
    public PermissionBO convert(Permission d) {
        if (d == null) {
            return null;
        }
        PermissionBO permissionBO = new PermissionBO();
        BeanUtils.copyProperties(d, permissionBO);
        return permissionBO;
    }

    @Override
    public Permission revert(PermissionBO b) {
        if (b == null) {
            return null;
        }
        Permission permission = new Permission();
        BeanUtils.copyProperties(b, permission);
        return permission;
    }
}
