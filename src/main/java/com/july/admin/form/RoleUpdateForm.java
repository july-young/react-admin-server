package com.july.admin.form;

import com.july.admin.bo.PermissionBO;
import com.july.admin.bo.RoleBO;
import com.july.admin.common.FormConverter;
import com.july.admin.util.RACollectionUtils;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * @author: july
 * @date: 2020/1/31 09:23
 * @description:
 */
public class RoleUpdateForm implements FormConverter<RoleBO> {

    private Long id;

    private String name;

    private List<Long> permissionKeys;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getPermissionKeys() {
        return permissionKeys;
    }

    public void setPermissionKeys(List<Long> permissionKeys) {
        this.permissionKeys = permissionKeys;
    }

    @Override
    public RoleBO toBO() {
        RoleBO roleBO = new RoleBO();
        BeanUtils.copyProperties(this,roleBO);
        List<PermissionBO> permissionBOList = RACollectionUtils.extractList(permissionKeys, x -> {
            PermissionBO permissionBO = new PermissionBO();
            permissionBO.setId(x);
            return permissionBO;
        });
        roleBO.setPermissions(permissionBOList);
        return roleBO;
    }

}
