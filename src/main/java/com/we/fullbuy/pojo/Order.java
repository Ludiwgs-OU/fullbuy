package com.we.fullbuy.pojo;

import java.util.Date;

public class Order {
    private String orderid;

    private Integer userid;

    private Integer skuid;

    private Double totalprice;

    private Integer addressid;

    private Integer num;

    private Date orderdate;

    private Integer postfee;

    private Integer orderstatus;

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getSkuid() {
        return skuid;
    }

    public void setSkuid(Integer skuid) {
        this.skuid = skuid;
    }

    public Double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Double totalprice) {
        this.totalprice = totalprice;
    }

    public Integer getAddressid() {
        return addressid;
    }

    public void setAddressid(Integer addressid) {
        this.addressid = addressid;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public Integer getPostfee() {
        return postfee;
    }

    public void setPostfee(Integer postfee) {
        this.postfee = postfee;
    }

    public Integer getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(Integer orderstatus) {
        this.orderstatus = orderstatus;
    }
}