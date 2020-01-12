package com.july.admin.bo;

import com.july.admin.entity.Role;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

/**
 * 角色的BO对象
 * @author july
 */
public class RoleBO extends Role implements GrantedAuthority {

    private List<PermissionBO> permissions;

    @Override
    public String getAuthority() {
        return getName();
    }

    public List<PermissionBO> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<PermissionBO> permissions) {
        this.permissions = permissions;
    }
}