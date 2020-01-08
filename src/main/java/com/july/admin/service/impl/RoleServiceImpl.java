package com.july.admin.service.impl;

import com.july.admin.bo.RoleBO;
import com.july.admin.bo.UserBO;
import com.july.admin.common.Converter;
import com.july.admin.dao.RelationUserRoleMapper;
import com.july.admin.dao.RoleMapper;
import com.july.admin.entity.RelationUserRole;
import com.july.admin.entity.RelationUserRoleExample;
import com.july.admin.entity.Role;
import com.july.admin.entity.RoleExample;
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
public class RoleServiceImpl implements RoleService, Converter<Role, RoleBO> {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RelationUserRoleMapper relationUserRoleMapper;


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

        return ReactAdminCollectionUtils.extractList(roles,x->convert(x));
    }

    @Override
    public RoleBO convert(Role d) {
        if (d == null) {
            return null;
        }
        RoleBO roleBO = new RoleBO();
        BeanUtils.copyProperties(d, roleBO);
        return roleBO;
    }

    @Override
    public Role revert(RoleBO b) {
        if (b == null) {
            return null;
        }
        Role role = new Role();
        BeanUtils.copyProperties(b, role);
        return role;
    }
}
