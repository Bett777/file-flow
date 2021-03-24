package com.jgc.common.model.paging;

import java.util.List;

/**
 * <p>分页数据外层封装</p>
 *
 * @author HuMingAn
 * @version 1.0
 * @date 2021/02/12 21:30
 **/
public class PageResult<T> {
    private Paging paging;
    private List<T> data;

    public Paging getPaging() {
        return paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
