package com.july.admin.query;

import com.july.admin.common.BaseQuery;

/**
 * @author: july
 * @date: 2020/1/16 23:51
 * @description:
 */
public class ProductQuery extends BaseQuery {

    private String name;

    private String detail;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
