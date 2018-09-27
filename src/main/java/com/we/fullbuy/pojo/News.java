package com.we.fullbuy.pojo;

import java.io.Serializable;

public class News implements Serializable {
    private Integer newsId;

    private Integer productId;

    private String newsImgPath;

    private Integer newsStatus;

    private String bgColor;

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getNewsImgPath() {
        return newsImgPath;
    }

    public void setNewsImgPath(String newsImgPath) {
        this.newsImgPath = newsImgPath == null ? null : newsImgPath.trim();
    }

    public Integer getNewsStatus() {
        return newsStatus;
    }

    public void setNewsStatus(Integer newsStatus) {
        this.newsStatus = newsStatus;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor == null ? null : bgColor.trim();
    }
}