package com.july.admin.query;

import com.july.admin.common.BaseQuery;

/**
 * @author: july
 * @date: 2020/1/14 00:13
 * @description:
 */
public class CategoryQuery extends BaseQuery {

    private Long parentId;

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }


}
