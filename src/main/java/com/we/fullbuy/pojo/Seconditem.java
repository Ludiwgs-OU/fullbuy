package com.we.fullbuy.pojo;

import java.io.Serializable;

public class Seconditem implements Serializable {
    private Integer seconditemid;

    private String seconditemname;

    public Integer getSeconditemid() {
        return seconditemid;
    }

    public void setSeconditemid(Integer seconditemid) {
        this.seconditemid = seconditemid;
    }

    public String getSeconditemname() {
        return seconditemname;
    }

    public void setSeconditemname(String seconditemname) {
        this.seconditemname = seconditemname == null ? null : seconditemname.trim();
    }
}