package com.july.admin.converter;

import com.july.admin.bo.RoleBO;
import com.july.admin.bo.UserBO;
import com.july.admin.common.Converter;
import com.july.admin.dto.UserWithRolesDTO;
import com.july.admin.entity.Role;
import com.july.admin.entity.User;
import com.july.admin.service.RoleService;
import com.july.admin.util.RACollectionUtils;
import com.july.admin.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author: july
 * @date: 2020/1/8 23:21
 * @description:
 */

@Component
public class UserConverter implements Converter<User, UserBO> {

    @Autowired
    private RoleService roleService;

    public static UserVO toVo(UserBO userBO) {
        if (userBO == null) {
            return null;
        }
        UserVO vo = new UserVO();
        BeanUtils.copyProperties(userBO, vo);
        vo.setRoles(userBO.getAuthorities());
        vo.setUserId(userBO.getId());
        return vo;
    }

    public UserWithRolesDTO toUserWithRolesDTO(UserBO userBO) {
        if (userBO == null) {
            return null;
        }
        UserWithRolesDTO dto = new UserWithRolesDTO();
        BeanUtils.copyProperties(userBO, dto);
        if (!CollectionUtils.isEmpty(userBO.getAuthorities())) {
            List<Role> roles = RACollectionUtils.extractList(userBO.getAuthorities(), x -> {
                        Role role = new Role();
                        role.setId(x.getId());
                        role.setName(x.getName());
                        return role;
                    }
            );
            dto.setRoles(roles);
        } else {
            dto.setRoles(new ArrayList<>());
        }

        dto.setUserId(userBO.getId());
        return dto;
    }


    @Override
    public List<UserBO> convert(List<User> list) {
        if (list == null) {
            return new ArrayList<>();
        }

        List<Long> userIds = RACollectionUtils.extractList(list, x -> x.getId());
        Map<Long, List<RoleBO>> roleDOByUserIdsMap = roleService.getRolesByUserIds(userIds);

        List<UserBO> res = new LinkedList<>();
        for (User user : list) {
            UserBO userBO = convert(user);
            userBO.setAuthorities(roleDOByUserIdsMap.get(userBO.getId()));
            res.add(userBO);
        }
        return res;
    }

    @Override
    public UserBO convert(User d) {
        if (d == null) {
            return null;
        }
        UserBO userBO = new UserBO();
        BeanUtils.copyProperties(d, userBO);
        userBO.setPassword(null);
        return userBO;
    }

    @Override
    public User revert(UserBO b) {
        if (b == null) {
            return null;
        }
        User user = new User();
        BeanUtils.copyProperties(b, user);
        return user;
    }
}
