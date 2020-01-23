package com.july.admin.converter;

import com.july.admin.bo.CategoryBO;
import com.july.admin.common.Converter;
import com.july.admin.dto.CategoryTreeDTO;
import com.july.admin.entity.Category;
import com.july.admin.util.ReactAdminCollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: july
 * @date: 2020/1/14 00:03
 * @description:
 */
@Component
public class CategoryConverter implements Converter<Category,CategoryBO> {
    @Override
    public CategoryBO convert(Category d) {
        if(d==null){
            return null;
        }
        CategoryBO b = new CategoryBO();
        BeanUtils.copyProperties(d,b);
        return b;
    }

    @Override
    public Category revert(CategoryBO b) {
        if(b==null){
            return null;
        }
        Category d = new Category();
        BeanUtils.copyProperties(b,d);
        return d;
    }

    public List<CategoryTreeDTO> convert2DTO(List<CategoryBO> boList){

        List<CategoryTreeDTO> dtoList = ReactAdminCollectionUtils.extractList(boList, x -> {
            CategoryTreeDTO dto = new CategoryTreeDTO();
            BeanUtils.copyProperties(x, dto);
            return dto;
        });
        treefy(dtoList,0L);
        return  dtoList;
    }

    private List<CategoryTreeDTO> treefy(List<CategoryTreeDTO> dtoList,Long pid ){
        List<CategoryTreeDTO> dtos = dtoList.stream().filter(x -> pid.equals(x.getParentId())).collect(Collectors.toList());
        List<CategoryTreeDTO> other = dtoList.stream().filter(x -> !pid.equals(x.getParentId())).collect(Collectors.toList());

        for(CategoryTreeDTO dto:dtos){
            dto.setChildren(treefy(other,dto.getId()));
        }
        return dtos;
    }
}
