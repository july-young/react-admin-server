package com.july.admin.converter;

import com.july.admin.bo.PermissionBO;
import com.july.admin.bo.RoleBO;
import com.july.admin.common.Converter;
import com.july.admin.entity.Role;
import com.july.admin.service.PermissionService;
import com.july.admin.util.RACollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @author: july
 * @date: 2020/1/12 16:28
 * @description:
 */
@Component
public class RoleConverter implements Converter<Role, RoleBO> {

    @Autowired
    private PermissionService permissionService;

    @Override
    public List<RoleBO> convert(List<Role> list) {
        if (CollectionUtils.isEmpty(list)) {
            return new ArrayList<RoleBO>();
        }

        /**
         * 获取菜单路径（页面路径）
         */
        List<PermissionBO> permissions = permissionService.getMenus();

        List<RoleBO> roleBOS = RACollectionUtils.extractList(list, x -> convert(x));

        for (RoleBO roleBO : roleBOS) {
            for (PermissionBO permission : permissions) {
                 //提取菜单
                if(Objects.equals(roleBO.getName(),permission.getRoleName())){
                    if(roleBO.getPermissions()==null){
                        roleBO.setPermissions(new LinkedList<>());
                    }
                    roleBO.getPermissions().add(permission);
                }
            }
        }

        return roleBOS;
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
