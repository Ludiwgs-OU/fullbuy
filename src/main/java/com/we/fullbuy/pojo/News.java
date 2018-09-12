package com.we.fullbuy.pojo;

import java.io.Serializable;

public class News implements Serializable {
    private Integer newsid;

    private Integer productid;

    private String newsimgpath;

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
}