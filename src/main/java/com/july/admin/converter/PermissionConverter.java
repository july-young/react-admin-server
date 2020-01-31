package com.july.admin.converter;

import com.july.admin.bo.PermissionBO;
import com.july.admin.common.Converter;
import com.july.admin.dto.PermissionTreeDTO;
import com.july.admin.entity.Permission;
import com.july.admin.util.RACollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: july
 * @date: 2020/1/10 23:24
 * @description:
 */
@Component
public class PermissionConverter implements Converter<Permission, PermissionBO> {

    public List<PermissionTreeDTO> convert2DTO(List<PermissionBO> boList){

        List<PermissionTreeDTO> dtoList = RACollectionUtils.extractList(boList, x -> {
            PermissionTreeDTO dto = new PermissionTreeDTO();
            BeanUtils.copyProperties(x, dto);
            return dto;
        });

        return treefy(dtoList,0L);
    }

    private List<PermissionTreeDTO> treefy(List<PermissionTreeDTO> dtoList,Long pid){

        List<PermissionTreeDTO> dtos = dtoList.stream().filter(x -> pid.equals(x.getPid())).collect(Collectors.toList());
        List<PermissionTreeDTO> other = dtoList.stream().filter(x -> !pid.equals(x.getPid())).collect(Collectors.toList());

        for(PermissionTreeDTO dto:dtos){
            dto.setChildren(treefy(other,dto.getId()));
        }
        return dtos;
    }


    @Override
    public PermissionBO convert(Permission d) {
        if (d == null) {
            return null;
        }
        PermissionBO permissionBO = new PermissionBO();
        BeanUtils.copyProperties(d, permissionBO);
        return permissionBO;
    }

    @Override
    public Permission revert(PermissionBO b) {
        if (b == null) {
            return null;
        }
        Permission permission = new Permission();
        BeanUtils.copyProperties(b, permission);
        return permission;
    }
}
