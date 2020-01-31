package com.july.admin.common;

/**
 * @author: july
 * @date: 2020/1/14 00:13
 * @description:
 */
public class BaseQuery extends ToString{

    private Integer page;

    private Integer size;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public void check(){
        //不传 默认第一页
        if(page==null || page<0 ){
            page=1;
        }
        //不传 默认查2000条
        if(size==null || size <0){
            size=2000;
        }
    }
}
