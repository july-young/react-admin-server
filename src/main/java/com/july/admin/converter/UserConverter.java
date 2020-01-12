package com.july.admin.converter;

import com.july.admin.bo.UserBO;
import com.july.admin.common.Converter;
import com.july.admin.entity.User;
import com.july.admin.util.ReactAdminCollectionUtils;
import com.july.admin.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: july
 * @date: 2020/1/8 23:21
 * @description:
 */

@Component
public class UserConverter implements Converter<User,UserBO> {

    public static UserVO toVo(UserBO userBO){
        if(userBO == null){
            return null;
        }
        UserVO vo = new UserVO();
        vo.setUsername(userBO.getUsername());
        vo.setUserId(userBO.getId());
        vo.setRoles(userBO.getAuthorities());
        return vo;
    }

    @Override
    public UserBO convert(User d) {
        if (d == null) {
            return null;
        }
        UserBO userBO = new UserBO();
        BeanUtils.copyProperties(d, userBO);
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
