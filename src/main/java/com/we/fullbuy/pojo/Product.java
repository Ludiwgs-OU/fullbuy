package com.we.fullbuy.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Product implements Serializable {
    private Integer productId;

    private String productName;

    private String productDetail;

    private Integer productScore;

    private Integer salesNum;

    private Integer categoryId;

    private Integer secondCategoryId;

    private Integer salesId;

    private Date postTime;

    private Integer productStatus;

    private String searchImgPath;

    private String sImgPath1;

    private String sImgPath2;

    private String mImgPath1;

    private String mImgPath2;

    private String bImgPath1;

    private String bImgPath2;

    private String detailImgPath1;

    private String detailImgPath2;

    private String item1;

    private String item2;

    private Integer postfee;

    private List<Sku> skuList;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(String productDetail) {
        this.productDetail = productDetail == null ? null : productDetail.trim();
    }

    public Integer getProductScore() {
        return productScore;
    }

    public void setProductScore(Integer productScore) {
        this.productScore = productScore;
    }

    public Integer getSalesNum() {
        return salesNum;
    }

    public void setSalesNum(Integer salesNum) {
        this.salesNum = salesNum;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getSecondCategoryId() {
        return secondCategoryId;
    }

    public void setSecondCategoryId(Integer secondCategoryId) {
        this.secondCategoryId = secondCategoryId;
    }

    public Integer getSalesId() {
        return salesId;
    }

    public void setSalesId(Integer salesId) {
        this.salesId = salesId;
    }

    public Date getPostTime() {
        return postTime;
    }

    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public String getSearchImgPath() {
        return searchImgPath;
    }

    public void setSearchImgPath(String searchImgPath) {
        this.searchImgPath = searchImgPath == null ? null : searchImgPath.trim();
    }

    public String getsImgPath1() {
        return sImgPath1;
    }

    public void setsImgPath1(String sImgPath1) {
        this.sImgPath1 = sImgPath1 == null ? null : sImgPath1.trim();
    }

    public String getsImgPath2() {
        return sImgPath2;
    }

    public void setsImgPath2(String sImgPath2) {
        this.sImgPath2 = sImgPath2 == null ? null : sImgPath2.trim();
    }

    public String getmImgPath1() {
        return mImgPath1;
    }

    public void setmImgPath1(String mImgPath1) {
        this.mImgPath1 = mImgPath1 == null ? null : mImgPath1.trim();
    }

    public String getmImgPath2() {
        return mImgPath2;
    }

    public void setmImgPath2(String mImgPath2) {
        this.mImgPath2 = mImgPath2 == null ? null : mImgPath2.trim();
    }

    public String getbImgPath1() {
        return bImgPath1;
    }

    public void setbImgPath1(String bImgPath1) {
        this.bImgPath1 = bImgPath1 == null ? null : bImgPath1.trim();
    }

    public String getbImgPath2() {
        return bImgPath2;
    }

    public void setbImgPath2(String bImgPath2) {
        this.bImgPath2 = bImgPath2 == null ? null : bImgPath2.trim();
    }

    public String getDetailImgPath1() {
        return detailImgPath1;
    }

    public void setDetailImgPath1(String detailImgPath1) {
        this.detailImgPath1 = detailImgPath1 == null ? null : detailImgPath1.trim();
    }

    public String getDetailImgPath2() {
        return detailImgPath2;
    }

    public void setDetailImgPath2(String detailImgPath2) {
        this.detailImgPath2 = detailImgPath2 == null ? null : detailImgPath2.trim();
    }

    public String getItem1() {
        return item1;
    }

    public void setItem1(String item1) {
        this.item1 = item1 == null ? null : item1.trim();
    }

    public String getItem2() {
        return item2;
    }

    public void setItem2(String item2) {
        this.item2 = item2 == null ? null : item2.trim();
    }

    public Integer getPostfee() {
        return postfee;
    }

    public void setPostfee(Integer postfee) {
        this.postfee = postfee;
    }


    public List<Sku> getSkuList() {
        return skuList;
    }

    public void setSkuList(List<Sku> skuList) {
        this.skuList = skuList;
    }
}