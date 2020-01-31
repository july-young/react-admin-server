package com.july.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.july.admin.bo.PermissionBO;
import com.july.admin.constant.PermissionConstant;
import com.july.admin.constant.ReactAdminConstant;
import com.july.admin.converter.PermissionConverter;
import com.july.admin.dao.PermissionMapper;
import com.july.admin.dao.RelationRolePermissionMapper;
import com.july.admin.dao.RoleMapper;
import com.july.admin.dto.PermissionTreeDTO;
import com.july.admin.entity.*;
import com.july.admin.query.MenuQuery;
import com.july.admin.service.PermissionService;
import com.july.admin.util.RACollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: july
 * @date: 2020/1/7 00:16
 * @description:
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionConverter permissionConverter;
    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RelationRolePermissionMapper relationRolePermissionMapper;

    @Override
    public List<PermissionBO> getRolePermissions() {

        PermissionExample permissionExample = new PermissionExample();
        permissionExample.createCriteria()
                .andStateEqualTo(ReactAdminConstant.MetaState.VALID)
                .andTypeEqualTo(PermissionConstant.TYPE_URL);
        List<Permission> permissions = permissionMapper.selectByExample(permissionExample);
        return convert(permissions);
    }

    @Override
    public List<PermissionBO> getMenus() {
        PermissionExample permissionExample = new PermissionExample();
        permissionExample.createCriteria()
                .andStateEqualTo(ReactAdminConstant.MetaState.VALID)
                .andTypeEqualTo(PermissionConstant.TYPE_PAGE);
        List<Permission> permissions = permissionMapper.selectByExample(permissionExample);
        return convert(permissions);

    }

    @Override
    public List<PermissionTreeDTO> getPermissionsInTree() {
        PermissionExample permissionExample = new PermissionExample();
        permissionExample.createCriteria()
                .andStateEqualTo(ReactAdminConstant.MetaState.VALID)
                .andTypeEqualTo(PermissionConstant.TYPE_PAGE);
        List<Permission> permissions = permissionMapper.selectByExample(permissionExample);
        List<PermissionBO> rolePermissions = convert(permissions);

        return permissionConverter.convert2DTO(rolePermissions);
    }

    @Override
    public List<PermissionBO> getMenus(MenuQuery query) {

        query.check();
        PageHelper.startPage(query.getPage(),query.getSize());
        RelationRolePermissionExample rrpe = new RelationRolePermissionExample();
        rrpe.createCriteria().andRoleIdEqualTo(query.getRoleId());
        List<RelationRolePermission> relationRolePermissions = relationRolePermissionMapper.selectByExample(rrpe);
        List<Long> permissionIds = RACollectionUtils.extractList(relationRolePermissions, x -> x.getPermissionId());
        PermissionExample permissionExample = new PermissionExample();
        permissionExample.createCriteria()
                .andIdIn(permissionIds)
                .andStateEqualTo(ReactAdminConstant.MetaState.VALID)
                .andTypeEqualTo(PermissionConstant.TYPE_PAGE);
        List<Permission> permissions = permissionMapper.selectByExample(permissionExample);
        return convert(permissions);
    }

    public List<PermissionBO> convert(List<Permission> permissions) {
        if (CollectionUtils.isEmpty(permissions)) {
            return new ArrayList<>();
        }
        RelationRolePermissionExample relationRolePermissionExample = new RelationRolePermissionExample();
        List<Long> permissionIds = RACollectionUtils.extractList(permissions, x -> x.getId());
        relationRolePermissionExample.createCriteria().andPermissionIdIn(permissionIds);
        List<RelationRolePermission> relationRolePermissions = relationRolePermissionMapper.selectByExample(relationRolePermissionExample);

        List<Long> roleIds = RACollectionUtils.toSetList(relationRolePermissions, x -> x.getRoleId());
        RoleExample roleExample = new RoleExample();
        roleExample.createCriteria().andStateEqualTo(ReactAdminConstant.MetaState.VALID)
                .andIdIn(roleIds);
        List<Role> roles = CollectionUtils.isEmpty(roleIds) ? new ArrayList<>() : roleMapper.selectByExample(roleExample);

        Map<Long, Long> relationMap = relationRolePermissions.stream().collect(Collectors.toMap(RelationRolePermission::getPermissionId, RelationRolePermission::getRoleId, (oldVal, newVal) -> newVal));
        Map<Long, String> roleMap = RACollectionUtils.toMap(roles, x -> x.getId(), x -> x.getName());

        return permissions.stream().map(x -> {
            PermissionBO permissionBO = permissionConverter.convert(x);
            Long roleId = relationMap.get(x.getId());
            if (roleId != null) {
                permissionBO.setRoleName(roleMap.get(roleId));
            }
            return permissionBO;
        }).collect(Collectors.toList());
    }

}
