package com.july.admin.bo;

import com.july.admin.entity.Role;
import org.springframework.security.core.GrantedAuthority;

public class RoleBO extends Role implements GrantedAuthority {

    @Override
    public String getAuthority() {
        return getName();
    }

}