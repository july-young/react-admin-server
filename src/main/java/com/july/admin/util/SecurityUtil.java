package com.july.admin.util;

import com.july.admin.bo.UserBO;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;

import java.util.Collection;

/**
 * @author: july
 * @date: 2020/1/31 11:42
 * @description:
 */
public class SecurityUtil {

    /**
     * 获取认证信息
     * @return
     */
    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * 获取所有权限
     * @return
     */
    public static Collection<? extends GrantedAuthority> getAllPermission(){
        return getAuthentication().getAuthorities();
    }

    /**
     * 是否有权限
     * @param permission
     * @return
     */
    public static boolean hasPermission(String permission){
        if(StringUtils.isEmpty(permission)){
            return false;
        }
        Collection<? extends GrantedAuthority> authorities = getAllPermission();
        boolean hasPermission = false;
        for(GrantedAuthority grantedAuthority : authorities){
            String authority = grantedAuthority.getAuthority();
            if(authority.equals(permission)){
                hasPermission =true;
            }
        }
        return hasPermission;
    }


    /**
     * 获取登录用户
     * @return
     */
    public static UserBO getUser() {
        return (UserBO) getAuthentication().getPrincipal();
    }

    public static Long getUserId(){
        return getUser().getId();
    }

    public static String getUsername(){
        return getUser().getUsername();
    }
    /**
     * 注销
     */
    public static void logout(){
        SecurityContextHolder.clearContext();
    }
}
