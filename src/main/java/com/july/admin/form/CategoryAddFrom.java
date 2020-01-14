package com.july.admin.form;

import com.july.admin.bo.CategoryBO;
import com.july.admin.common.FormConverter;
import org.springframework.beans.BeanUtils;

/**
 * @author: july
 * @date: 2020/1/14 20:18
 * @description:
 */
public class CategoryAddFrom implements FormConverter<CategoryBO> {

    private String name;

    private Long parentId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Override
    public CategoryBO toBO(){
        CategoryBO bo = new CategoryBO();
        BeanUtils.copyProperties(this,bo);
        return bo;
    }


}
