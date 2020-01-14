package com.july.admin.form;

import com.july.admin.bo.CategoryBO;
import com.july.admin.common.FormConverter;
import com.july.admin.common.ToString;
import org.springframework.beans.BeanUtils;

/**
 * @author: july
 * @date: 2020/1/14 20:19
 * @description:
 */
public class CategoryUpdateForm extends ToString implements FormConverter<CategoryBO> {

    private String name;

    private Long id;

    private Long parentId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Override
    public CategoryBO toBO() {
        CategoryBO bo = new CategoryBO();
        BeanUtils.copyProperties(this,bo);
        return bo;
    }
}
