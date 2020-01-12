package com.july.admin.common;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author: july
 * @date: 2020/1/10 23:29
 * @description:
 */
public class ToString {

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
