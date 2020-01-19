package com.july.admin.enums;

import com.july.admin.common.BaseEnum;

/**
 * @author: july
 * @date: 2020/1/19 21:59
 * @description:
 */
public enum  ProductStatusEnum implements BaseEnum {
    ON_SALE(2),
    OFF_SALE(1);

    ProductStatusEnum(Integer code){
        this.code=code;
    }
    private Integer code;

    @Override
    public Integer getCode() {
        return this.code;
    }
}
