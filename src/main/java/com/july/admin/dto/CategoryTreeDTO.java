package com.july.admin.dto;

import com.july.admin.bo.CategoryBO;

import java.util.List;

/**
 * @author: july
 * @date: 2020/1/23 21:20
 * @description:
 */
public class CategoryTreeDTO extends CategoryBO {

    private List<CategoryTreeDTO> children;

    public List<CategoryTreeDTO> getChildren() {
        return children;
    }

    public void setChildren(List<CategoryTreeDTO> children) {
        this.children = children;
    }
}
