package com.we.fullbuy.pojo;

import java.util.Date;
import java.util.List;

public class Product {
    private Integer productid;

    private String productname;

    private String productdetail;

    private Double productscore;

    private Integer salesnum;

    private Integer categoryid;

    private Integer salesid;

    private Date posttime;

    private String mainimgpath;

    private String searchimgpath;

    private String detailimgpath;

    private List<Item> items;

    private List<Color> colors;

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname == null ? null : productname.trim();
    }

    public String getProductdetail() {
        return productdetail;
    }

    public void setProductdetail(String productdetail) {
        this.productdetail = productdetail == null ? null : productdetail.trim();
    }

    public Double getProductscore() {
        return productscore;
    }

    public void setProductscore(Double productscore) {
        this.productscore = productscore;
    }

    public Integer getSalesnum() {
        return salesnum;
    }

    public void setSalesnum(Integer salesnum) {
        this.salesnum = salesnum;
    }

    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    public Integer getSalesid() {
        return salesid;
    }

    public void setSalesid(Integer salesid) {
        this.salesid = salesid;
    }

    public Date getPosttime() {
        return posttime;
    }

    public void setPosttime(Date posttime) {
        this.posttime = posttime;
    }

    public String getMainimgpath() {
        return mainimgpath;
    }

    public void setMainimgpath(String mainimgpath) {
        this.mainimgpath = mainimgpath == null ? null : mainimgpath.trim();
    }

    public String getSearchimgpath() {
        return searchimgpath;
    }

    public void setSearchimgpath(String searchimgpath) {
        this.searchimgpath = searchimgpath == null ? null : searchimgpath.trim();
    }

    public String getDetailimgpath() {
        return detailimgpath;
    }

    public void setDetailimgpath(String detailimgpath) {
        this.detailimgpath = detailimgpath == null ? null : detailimgpath.trim();
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Color> getColors() {
        return colors;
    }

    public void setColors(List<Color> colors) {
        this.colors = colors;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productid=" + productid +
                ", productname='" + productname + '\'' +
                ", productdetail='" + productdetail + '\'' +
                ", productscore=" + productscore +
                ", salesnum=" + salesnum +
                ", categoryid=" + categoryid +
                ", salesid=" + salesid +
                ", posttime=" + posttime +
                ", mainimgpath='" + mainimgpath + '\'' +
                ", searchimgpath='" + searchimgpath + '\'' +
                ", detailimgpath='" + detailimgpath + '\'' +
                ", items=" + items +
                ", colors=" + colors +
                '}';
    }
}