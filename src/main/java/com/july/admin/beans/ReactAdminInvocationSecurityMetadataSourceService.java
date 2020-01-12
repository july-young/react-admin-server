package com.july.admin.beans;

import com.july.admin.bo.PermissionBO;
import com.july.admin.common.RAPair;
import com.july.admin.service.PermissionService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Component
public class ReactAdminInvocationSecurityMetadataSourceService implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private PermissionService permissionService;

    /**
     * 每一个资源所需要的角色 Collection<ConfigAttribute>决策器会用到
     */
    private static HashMap<RAPair<String, String>, Collection<ConfigAttribute>> map = null;


    /**
     * 返回请求的资源需要的角色
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        if (null == map) {
            loadResourceDefine();
        }
        //object 中包含用户请求的request 信息
        HttpServletRequest request = ((FilterInvocation) o).getHttpRequest();
        for (Iterator<RAPair<String, String>> it = map.keySet().iterator(); it.hasNext(); ) {
            RAPair<String, String> pair = it.next();
            if (new AntPathRequestMatcher(pair.getKey(),pair.getValue()).matches(request)) {
                return map.get(pair);
            }
        }

        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }

    /**
     * 初始化 所有资源 对应的角色
     */
    public void loadResourceDefine() {
        map = new HashMap<>(16);
        //权限资源 和 角色对应的表  也就是 角色权限 中间表
        List<PermissionBO> rolePermissions = permissionService.getRolePermissions();

        //某个资源 可以被哪些角色访问
        for (PermissionBO rolePermission : rolePermissions) {

            String url = rolePermission.getUrl();
            String method = rolePermission.getMethod();
            String roleName = rolePermission.getRoleName();
            if(StringUtils.isBlank(roleName)){
                continue;
            }
            ConfigAttribute role = new SecurityConfig(roleName);
            RAPair<String, String> pair = new RAPair<>(url, method);
            if (map.containsKey(pair)) {
                map.get(pair).add(role);
            } else {
                List<ConfigAttribute> list = new ArrayList<>();
                list.add(role);
                map.put(pair, list);
            }
        }
    }


}