package com.we.fullbuy.pojo;

import com.we.fullbuy.utils.DateUtil;

import java.io.Serializable;
import java.util.Date;

public class Comment implements Serializable {
    private Integer commentId;

    private Integer productId;

    private Integer userId;

    private String orderId;

    private String commentDetail;

    private String commentImgPath;

    private Date commentTime;

    private Order order;

    private String commentTimeStr;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getCommentDetail() {
        return commentDetail;
    }

    public void setCommentDetail(String commentDetail) {
        this.commentDetail = commentDetail == null ? null : commentDetail.trim();
    }

    public String getCommentImgPath() {
        return commentImgPath;
    }

    public void setCommentImgPath(String commentImgPath) {
        this.commentImgPath = commentImgPath == null ? null : commentImgPath.trim();
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }


    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getCommentTimeStr() {
        return DateUtil.changetoDateStr(commentTime);
    }
}