package com.jgc.common.model.paging;

/**
 * <p>分页字段</p>
 *
 * @author HuMingAn
 * @version 1.0
 * @date 2021/02/12 21:33
 **/
public class Paging {
    /**
     * 当前页面
     */
    private int pageNumber;
    /**
     * 页面行数
     */
    private int pageSize;
    /**
     * 总页数
     */
    private int totalPage;
    /**
     * 总行数
     */
    private long totalNumber;

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public long getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(long totalNumber) {
        this.totalNumber = totalNumber;
    }
}
