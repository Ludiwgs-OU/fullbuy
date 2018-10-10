package com.we.fullbuy.pojo;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.we.fullbuy.utils.DateUtil;

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

    private String postTimeStr;

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

    private Sku sku;

    private String secondCategoryName;

    private String categoryName;

    private List<Category> categoryList;

    private List<Secondcategory> secondCategoryList;

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
        this.productName = productName;
    }

    public String getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(String productDetail) {
        this.productDetail = productDetail;
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
        this.searchImgPath = searchImgPath;
    }

    public String getsImgPath1() {
        return sImgPath1;
    }

    public void setsImgPath1(String sImgPath1) {
        this.sImgPath1 = sImgPath1;
    }

    public String getsImgPath2() {
        return sImgPath2;
    }

    public void setsImgPath2(String sImgPath2) {
        this.sImgPath2 = sImgPath2;
    }

    public String getmImgPath1() {
        return mImgPath1;
    }

    public void setmImgPath1(String mImgPath1) {
        this.mImgPath1 = mImgPath1;
    }

    public String getmImgPath2() {
        return mImgPath2;
    }

    public void setmImgPath2(String mImgPath2) {
        this.mImgPath2 = mImgPath2;
    }

    public String getbImgPath1() {
        return bImgPath1;
    }

    public void setbImgPath1(String bImgPath1) {
        this.bImgPath1 = bImgPath1;
    }

    public String getbImgPath2() {
        return bImgPath2;
    }

    public void setbImgPath2(String bImgPath2) {
        this.bImgPath2 = bImgPath2;
    }

    public String getDetailImgPath1() {
        return detailImgPath1;
    }

    public void setDetailImgPath1(String detailImgPath1) {
        this.detailImgPath1 = detailImgPath1;
    }

    public String getDetailImgPath2() {
        return detailImgPath2;
    }

    public void setDetailImgPath2(String detailImgPath2) {
        this.detailImgPath2 = detailImgPath2;
    }

    public String getItem1() {
        return item1;
    }

    public void setItem1(String item1) {
        this.item1 = item1;
    }

    public String getItem2() {
        return item2;
    }

    public void setItem2(String item2) {
        this.item2 = item2;
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

    public Sku getSku() {
        return sku;
    }

    public void setSku(Sku sku) {
        this.sku = sku;
    }

    public String getSecondCategoryName() {
        return secondCategoryName;
    }

    public void setSecondCategoryName(String secondCategoryName) {
        this.secondCategoryName = secondCategoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public List<Secondcategory> getSecondCategoryList() {
        return secondCategoryList;
    }

    public void setSecondCategoryList(List<Secondcategory> secondCategoryList) {
        this.secondCategoryList = secondCategoryList;
    }

    public String getPostTimeStr() {
        return DateUtil.changetoDateStr(postTime);
    }
}