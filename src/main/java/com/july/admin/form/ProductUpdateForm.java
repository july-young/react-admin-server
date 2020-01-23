package com.july.admin.form;

import com.july.admin.bo.ProductBO;
import com.july.admin.common.FormConverter;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author: july
 * @date: 2020/1/19 21:00
 * @description:
 */
public class ProductUpdateForm implements FormConverter<ProductBO> {
    private Long id;

    private String name;

    private Integer version;

    private Date gmtCreate;

    private Date gmtUpdate;

    private Byte state;

    private List<String> imgs;

    private BigDecimal price;

    private String detail;

    private Long pCategoryId;

    private Long categoryId;


    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtUpdate() {
        return gmtUpdate;
    }

    public void setGmtUpdate(Date gmtUpdate) {
        this.gmtUpdate = gmtUpdate;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public List<String> getImgs() {
        return imgs;
    }

    public void setImgs(List<String> imgs) {
        this.imgs = imgs;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public ProductBO toBO() {
        ProductBO productBO = new ProductBO();
        BeanUtils.copyProperties(this,productBO);
        return productBO;
    }
}
