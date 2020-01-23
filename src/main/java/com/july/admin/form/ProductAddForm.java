package com.july.admin.form;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.july.admin.bo.ProductBO;
import com.july.admin.common.FormConverter;
import com.july.admin.entity.Product;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author: july
 * @date: 2020/1/19 20:48
 * @description:
 */
public class ProductAddForm implements FormConverter<ProductBO> {

    private String name;

    private Integer version;

    private Byte state;

    private List<String> imgs;

    private BigDecimal price;

    private String detail;

    private String description;

    private Long pCategoryId;

    private Long categoryId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Long getpCategoryId() {
        return pCategoryId;
    }

    public void setpCategoryId(Long pCategoryId) {
        this.pCategoryId = pCategoryId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public ProductBO toBO() {
        ProductBO productBO = new ProductBO();
        BeanUtils.copyProperties(this,productBO);
        productBO.setImgs(this.getImgs());
        return productBO;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getImgs() {
        return imgs;
    }

    public void setImgs(List<String> imgs) {
        this.imgs = imgs;
    }
}
