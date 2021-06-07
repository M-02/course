package com.huaxia.course.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    int c_id;
    String c_name;
    String c_unit;
    String c_category;
    String c_credit;
    String c_teacher;
    String c_date;
    String c_room;
    String c_capacity;
    String c_allowance;
    int c_status;
    int cstatus;

    public int getCstatus() {
        return cstatus;
    }

    public void setCstatus(int cstatus) {
        this.cstatus = cstatus;
    }

    public int getC_status() {
        return c_status;
    }

    public void setC_status(int c_status) {
        this.c_status = c_status;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_unit() {
        return c_unit;
    }

    public void setC_unit(String c_unit) {
        this.c_unit = c_unit;
    }

    public String getC_category() {
        return c_category;
    }

    public void setC_category(String c_category) {
        this.c_category = c_category;
    }

    public String getC_credit() {
        return c_credit;
    }

    public void setC_credit(String c_credit) {
        this.c_credit = c_credit;
    }

    public String getC_teacher() {
        return c_teacher;
    }

    public void setC_teacher(String c_teacher) {
        this.c_teacher = c_teacher;
    }

    public String getC_date() {
        return c_date;
    }

    public void setC_date(String c_date) {
        this.c_date = c_date;
    }

    public String getC_room() {
        return c_room;
    }

    public void setC_room(String c_room) {
        this.c_room = c_room;
    }

    public String getC_capacity() {
        return c_capacity;
    }

    public void setC_capacity(String c_capacity) {
        this.c_capacity = c_capacity;
    }

    public String getC_allowance() {
        return c_allowance;
    }

    public void setC_allowance(String c_allowance) {
        this.c_allowance = c_allowance;
    }






}
