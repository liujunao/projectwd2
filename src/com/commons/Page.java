package com.commons;

/**
 * Created by lenovo on 2017/7/12.
 */
public class Page {

    private int pageNumber;//当前页
    private int pageSize;//每页显示的数据条数
    private int totalRecord;//总的记录数
    private int totalPage;//总页数

    public Page(int pageNumber, int pageSize, int totalPage) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.totalPage = totalPage;
    }

    public Page() {
    }

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

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

}
