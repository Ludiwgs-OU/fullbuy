package com.we.fullbuy.pojo;

import java.io.Serializable;
import java.util.Date;

public class Comment implements Serializable {
    private Integer commentid;

    private Integer productid;

    private String orderid;

    private Integer userid;

    private String commentdetail;

    private String commentimgpath;

    private Date commenttime;

    public Integer getCommentid() {
        return commentid;
    }

    public void setCommentid(Integer commentid) {
        this.commentid = commentid;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    public String getCommentdetail() {
        return commentdetail;
    }

    public void setCommentdetail(String commentdetail) {
        this.commentdetail = commentdetail == null ? null : commentdetail.trim();
    }

    public String getCommentimgpath() {
        return commentimgpath;
    }

    public void setCommentimgpath(String commentimgpath) {
        this.commentimgpath = commentimgpath == null ? null : commentimgpath.trim();
    }

    public Date getCommenttime() {
        return commenttime;
    }

    public void setCommenttime(Date commenttime) {
        this.commenttime = commenttime;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}