package com.we.fullbuy.pojo;

import java.util.Date;

public class Groudbuy {
    private Integer gbid;

    private Integer productid;

    private Integer minpeople;

    private Integer maxpeople;

    private Date begintime;

    private Date endtime;

    private Integer gbstatus;

    private Integer salesid;

    public Integer getGbid() {
        return gbid;
    }

    public void setGbid(Integer gbid) {
        this.gbid = gbid;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public Integer getMinpeople() {
        return minpeople;
    }

    public void setMinpeople(Integer minpeople) {
        this.minpeople = minpeople;
    }

    public Integer getMaxpeople() {
        return maxpeople;
    }

    public void setMaxpeople(Integer maxpeople) {
        this.maxpeople = maxpeople;
    }

    public Date getBegintime() {
        return begintime;
    }

    public void setBegintime(Date begintime) {
        this.begintime = begintime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Integer getGbstatus() {
        return gbstatus;
    }

    public void setGbstatus(Integer gbstatus) {
        this.gbstatus = gbstatus;
    }

    public Integer getSalesid() {
        return salesid;
    }

    public void setSalesid(Integer salesid) {
        this.salesid = salesid;
    }
}