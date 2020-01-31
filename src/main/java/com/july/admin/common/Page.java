package com.july.admin.common;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author: july
 * @date: 2020/1/14 20:09
 * @description:
 */
public class Page<T> extends ToString{

   private Integer page;
   private Integer size;
   private Long total;
   private List<T> list;

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

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public static <T> Page<T> getInstance(PageInfo pageInfo){
        Page<T> page= new Page<>();
        page.setList(pageInfo.getList());
        page.setPage(pageInfo.getPageNum());
        page.setSize(pageInfo.getSize());
        page.setTotal(pageInfo.getTotal());
        return page;
    }
}
