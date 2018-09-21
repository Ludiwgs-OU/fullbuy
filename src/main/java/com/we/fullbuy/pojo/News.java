package com.we.fullbuy.pojo;

import java.io.Serializable;

public class News implements Serializable {
    private Integer newsid;

    private Integer productid;

    private String newsimgpath;

    private Integer newsstatus;

    private String bgcolor;

    public Integer getNewsid() {
        return newsid;
    }

    public void setNewsid(Integer newsid) {
        this.newsid = newsid;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public String getNewsimgpath() {
        return newsimgpath;
    }

    public void setNewsimgpath(String newsimgpath) {
        this.newsimgpath = newsimgpath == null ? null : newsimgpath.trim();
    }

    public Integer getNewsstatus() {
        return newsstatus;
    }

    public void setNewsstatus(Integer newsstatus) {
        this.newsstatus = newsstatus;
    }

    public String getBgcolor() {
        return bgcolor;
    }

    public void setBgcolor(String bgcolor) {
        this.bgcolor = bgcolor;
    }
}