package com.july.admin.form;

import com.july.admin.bo.CategoryBO;
import com.july.admin.common.FormConverter;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author: july
 * @date: 2020/1/14 20:18
 * @description:
 */
public class CategoryAddFrom implements FormConverter<CategoryBO> {

    @NotBlank(message = "分类名称需要在2-20个字符之间")
    @Size(min = 2,max = 20,message = "分类名称需要在2-20个字符之间")
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
