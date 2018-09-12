package com.we.fullbuy.pojo;

import java.io.Serializable;

public class Manager implements Serializable {
    private Integer managerid;

    private String managerpwd;

    public Integer getManagerid() {
        return managerid;
    }

    public void setManagerid(Integer managerid) {
        this.managerid = managerid;
    }

    public String getManagerpwd() {
        return managerpwd;
    }

    public void setManagerpwd(String managerpwd) {
        this.managerpwd = managerpwd == null ? null : managerpwd.trim();
    }
}