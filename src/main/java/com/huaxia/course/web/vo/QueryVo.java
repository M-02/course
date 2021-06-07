package com.huaxia.course.web.vo;

public class QueryVo {

    int page;

    int pageSize;

//    String st_code;
//    String st_name;

//    public String getSt_code() {
//        return st_code;
//    }
//
//    public void setSt_code(String st_code) {
//        this.st_code = st_code;
//    }
//
//    public String getSt_name() {
//        return st_name;
//    }
//
//    public void setSt_name(String st_name) {
//        this.st_name = st_name;
//    }

    public int getPage() {
        if(this.page==0){
            this.page = 1;
        }
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        if(this.pageSize==0){
            this.pageSize  = 6;
        }
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
