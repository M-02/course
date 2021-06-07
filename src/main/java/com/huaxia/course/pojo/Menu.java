package com.huaxia.course.pojo;

public class Menu {

    int menuid;

    String menuname;

    int menulevel;

    int meneparent;

    int rid;

    public int getMenuid() {
        return menuid;
    }

    public void setMenuid(int menuid) {
        this.menuid = menuid;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    public int getMenulevel() {
        return menulevel;
    }

    public void setMenulevel(int menulevel) {
        this.menulevel = menulevel;
    }

    public int getMeneparent() {
        return meneparent;
    }

    public void setMeneparent(int meneparent) {
        this.meneparent = meneparent;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }
}
