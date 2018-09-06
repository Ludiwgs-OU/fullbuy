package com.we.fullbuy.pojo;

public class Manager {
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