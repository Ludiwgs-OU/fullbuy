package com.we.fullbuy.pojo;

import java.io.Serializable;

public class Favor implements Serializable {
    private Integer favorid;

    private Integer userid;

    private Integer productid;

    public Integer getFavorid() {
        return favorid;
    }

    public void setFavorid(Integer favorid) {
        this.favorid = favorid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }
}