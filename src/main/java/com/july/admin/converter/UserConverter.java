package com.july.admin.converter;

import com.july.admin.bo.UserBO;
import com.july.admin.util.ReactAdminCollectionUtils;
import com.july.admin.vo.UserVO;

import java.util.List;

/**
 * @author: july
 * @date: 2020/1/8 23:21
 * @description:
 */
public class UserConverter {

    public static UserVO toVo(UserBO userBO){
        if(userBO == null){
            return null;
        }
        UserVO vo = new UserVO();
        vo.setUsername(userBO.getUsername());
        vo.setUserId(userBO.getId());
        List<String> roles = ReactAdminCollectionUtils.extractList(userBO.getAuthorities(), x -> x.getName());
        vo.setRoles(roles);
        return vo;
    }

}
