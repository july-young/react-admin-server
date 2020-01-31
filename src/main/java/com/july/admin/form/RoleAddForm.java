package com.july.admin.form;

import com.july.admin.bo.RoleBO;
import com.july.admin.common.FormConverter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author: july
 * @date: 2020/1/31 09:23
 * @description:
 */
public class RoleAddForm implements FormConverter<RoleBO> {

    @NotBlank(message = "角色名称需要在2-20个字符之间")
    @Size(min = 2,max = 20,message = "角色名称需要在2-20个字符之间")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public RoleBO toBO() {
        RoleBO roleBO = new RoleBO();
        roleBO.setName(this.name);
        return roleBO;
    }
}
