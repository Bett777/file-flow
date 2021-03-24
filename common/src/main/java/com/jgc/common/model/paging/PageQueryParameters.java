package com.jgc.common.model.paging;

/**
 * <p>分页查询参数外层封装</p>
 *
 * @author HuMingAn
 * @version 1.0
 * @date 2021/02/12 21:43
 **/
public class PageQueryParameters<T> {
    private Paging paging;
    private T params;

    public Paging getPaging() {
        return paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }

    public T getParams() {
        return params;
    }

    public void setParams(T params) {
        this.params = params;
    }
}
