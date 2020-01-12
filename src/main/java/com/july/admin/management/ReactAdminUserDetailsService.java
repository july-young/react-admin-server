package com.july.admin.management;

import com.july.admin.bo.RoleBO;
import com.july.admin.bo.UserBO;
import com.july.admin.dao.RoleMapper;
import com.july.admin.dao.UserMapper;
import com.july.admin.entity.Role;
import com.july.admin.entity.User;
import com.july.admin.service.RoleService;
import com.july.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReactAdminUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //查数据库
        UserBO user = userService.loadUserByUsername( userName );
        if (null != user) {
            List<RoleBO> roles = roleService.getRolesByUserId( user.getId() );
            user.setAuthorities( roles );
        }

        return user;
    }


}