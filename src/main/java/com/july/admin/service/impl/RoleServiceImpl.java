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
import com.july.admin.service.RoleService;
import com.july.admin.util.RACollectionUtils;
import com.july.admin.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: july
 * @date: 2020/1/6 00:29
 * @description:
 */
@Service
public class RoleServiceImpl implements RoleService {

    public static final String ALL_ROLE_BOS="allRoleBOs";

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RelationUserRoleMapper relationUserRoleMapper;
    @Autowired
    private RelationRolePermissionMapper relationRolePermissionMapper;
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

    @Cacheable(ALL_ROLE_BOS)
    public List<RoleBO> getAllRoles() {
        RoleExample roleExample = new RoleExample();
        roleExample.createCriteria().andStateEqualTo(ReactAdminConstant.MetaState.VALID);
        List<Role> roles = roleMapper.selectByExample(roleExample);
        return roleConverter.convert(roles);
    }

    @Override
    public Map<Long, List<RoleBO>> getRolesByUserIds(List<Long> userIds) {

        //拿出user role关系数据
        RelationUserRoleExample relationUserRoleExample = new RelationUserRoleExample();
        relationUserRoleExample.createCriteria().andUserIdIn(userIds);
        List<RelationUserRole> relationUserRoles = relationUserRoleMapper.selectByExample(relationUserRoleExample);

        //拿出所有的权限 因为角色很少
        List<RoleBO> roles = getAllRoles();

        //组成map 查找方便
        Map<Long, RoleBO> roleMap = RACollectionUtils.toMap(roles, x -> x.getId(), x -> x);

        Map<Long, List<RoleBO>> userIdRolesMap = new HashMap<>();

        //拼装结果
        for (RelationUserRole rur : relationUserRoles) {
            List<RoleBO> roles1 = userIdRolesMap.get(rur.getUserId());
            if (roles1 == null) {
                roles1 = new LinkedList<>();
                userIdRolesMap.put(rur.getUserId(), roles1);
            }
            roles1.add(roleMap.get(rur.getRoleId()));
        }
        return userIdRolesMap;
    }

    @Override
    public Page<RoleBO> query(RoleQuery query) {
        RoleExample roleExample = new RoleExample();
        roleExample.createCriteria().andStateEqualTo(ReactAdminConstant.MetaState.VALID);
        List<Role> roles = roleMapper.selectByExample(roleExample);
        List<RoleBO> list = roleConverter.convert(roles);
        return Page.getInstance(new PageInfo(list));
    }

    @Override
    @CacheEvict(ALL_ROLE_BOS)
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
    @CacheEvict(ALL_ROLE_BOS)
    public RoleBO update(RoleBO roleBO) {
        //添加role permission关系
        addRelationRoleAndMenus(roleBO.getId(), RACollectionUtils.extractList(roleBO.getPermissions(), x -> x.getId()));
        Role role = roleConverter.revert(roleBO);

        role.setUpdater(SecurityUtil.getUserId());
        role.setAuthUserName(SecurityUtil.getUsername());
        role.setAuthUserId(SecurityUtil.getUserId());

        roleMapper.updateByPrimaryKeySelective(role);
        Role res = roleMapper.selectByPrimaryKey(role.getId());
        return roleConverter.convert(res);
    }

    /**
     * 添加role permission关系
     *
     * @param roleId
     * @param menuKeys
     */
    private void addRelationRoleAndMenus(Long roleId, List<Long> menuKeys) {
        RelationRolePermissionExample relationRolePermissionExample = new RelationRolePermissionExample();
        relationRolePermissionExample.createCriteria().andRoleIdEqualTo(roleId);
        relationRolePermissionMapper.deleteByExample(relationRolePermissionExample);
        for (Long permissionId : menuKeys) {

            RelationRolePermission relationRolePermission = new RelationRolePermission();
            relationRolePermission.setId(snowflakeIdWorker.nextId());
            relationRolePermission.setPermissionId(permissionId);
            relationRolePermission.setRoleId(roleId);
            relationRolePermissionMapper.insert(relationRolePermission);
        }
    }

    @Override
    @CacheEvict(ALL_ROLE_BOS)
    public Integer remove(Long id) {
        return roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public RoleBO find(Long id) {

        Role role = roleMapper.selectByPrimaryKey(id);
        if (ReactAdminConstant.MetaState.VALID != role.getState()) {
            return null;
        }
        return roleConverter.convert(role);
    }

}
