package com.july.admin.service.impl;

import com.github.pagehelper.PageInfo;
import com.july.admin.beans.SnowflakeIdWorker;
import com.july.admin.bo.RoleBO;
import com.july.admin.bo.UserBO;
import com.july.admin.common.Page;
import com.july.admin.constant.ReactAdminConstant;
import com.july.admin.converter.RoleConverter;
import com.july.admin.dao.RelationRolePermissionMapper;
import com.july.admin.dao.RelationUserRoleMapper;
import com.july.admin.dao.RoleMapper;
import com.july.admin.entity.*;
import com.july.admin.query.RoleQuery;
import com.july.admin.service.PermissionService;
import com.july.admin.service.RoleService;
import com.july.admin.util.RACollectionUtils;
import com.july.admin.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: july
 * @date: 2020/1/6 00:29
 * @description:
 */
@Service
public class RoleServiceImpl implements RoleService {

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
    @Autowired
    private SnowflakeIdWorker snowflakeIdWorker;

    @Override
    public List<RoleBO> getRolesByUserId(Long id) {

        RelationUserRoleExample relationUserRoleExample = new RelationUserRoleExample();

        relationUserRoleExample.createCriteria().andUserIdEqualTo(id);

        List<RelationUserRole> relationUserRoles = relationUserRoleMapper.selectByExample(relationUserRoleExample);

        List<Long> idList = RACollectionUtils.extractList(relationUserRoles, x -> x.getRoleId());
        return getRolesByIds(idList);
    }

    @Override
    public List<RoleBO> getRolesByIds(List<Long> roleIds) {

        RoleExample roleExample = new RoleExample();

        roleExample.createCriteria().andIdIn(roleIds)
                .andStateEqualTo(ReactAdminConstant.MetaState.VALID);

        List<Role> roles = roleMapper.selectByExample(roleExample);

        return roleConverter.convert(roles);
    }

    @Override
    public Page<RoleBO> query(RoleQuery query) {
        RoleExample roleExample = new RoleExample();
        roleExample.createCriteria().andStateEqualTo(ReactAdminConstant.MetaState.VALID);
        List<Role> roles = roleMapper.selectByExample(roleExample);
        List<RoleBO> list = roleConverter.convert(roles);
        return Page.getInstance( new PageInfo(list));
    }

    @Override
    public RoleBO create(RoleBO roleBO) {

        Role role = roleConverter.revert(roleBO);
        long id = snowflakeIdWorker.nextId();
        role.setId(id);

        UserBO user = SecurityUtil.getUser();
        role.setCreator(user.getId());
        role.setUpdater(user.getId());

        role.setAuthUserName(user.getUsername());
        role.setAuthUserId(user.getId());

        roleMapper.insertSelective(role);
        return roleConverter.convert(roleMapper.selectByPrimaryKey(id));
    }

    @Override
    public RoleBO update(RoleBO roleBO) {

        addRelationRoleAndMenus(roleBO.getId(),RACollectionUtils.extractList( roleBO.getPermissions(), x->x.getId()));
        Role role = roleConverter.revert(roleBO);

        UserBO user = SecurityUtil.getUser();
        role.setUpdater(user.getId());
        role.setAuthUserName(user.getUsername());
        role.setAuthUserId(user.getId());

        roleMapper.updateByPrimaryKeySelective(role);
        Role res = roleMapper.selectByPrimaryKey(role.getId());
        return roleConverter.convert(res);
    }

    private void addRelationRoleAndMenus(Long roleId,List<Long> menuKeys){
        RelationRolePermissionExample relationRolePermissionExample =new RelationRolePermissionExample();
        relationRolePermissionExample.createCriteria().andRoleIdEqualTo(roleId);
        relationRolePermissionMapper.deleteByExample(relationRolePermissionExample);
        for (Long permissionId:menuKeys) {

            RelationRolePermission relationRolePermission = new RelationRolePermission();
            relationRolePermission.setId(snowflakeIdWorker.nextId());
            relationRolePermission.setPermissionId(permissionId);
            relationRolePermission.setRoleId(roleId);
            relationRolePermissionMapper.insert(relationRolePermission);
        }
    }

    @Override
    public Integer remove(Long id) {
        return roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public RoleBO find(Long id) {
        Role role = roleMapper.selectByPrimaryKey(id);
        return roleConverter.convert(role);
    }

}
