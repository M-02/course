package com.huaxia.course.pojo;

import java.io.Serializable;
import java.util.Objects;

public class Role implements Serializable {

    int rid;

    String rname;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return rid == role.rid &&
                rname.equals(role.rname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rid, rname);
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }
}
