package com.we.fullbuy.pojo;

import java.io.Serializable;

public class Comment implements Serializable {
    private Integer commentid;

    private Integer productid;

    private String commentdetail;

    private String commentimgpath;

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
}