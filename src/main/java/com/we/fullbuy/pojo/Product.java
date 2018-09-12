package com.we.fullbuy.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Product implements Serializable {
    private Integer productid;

    private String productname;

    private String productdetail;

    private Integer productscore;

    private Integer salesnum;

    private Integer categoryid;

    private Integer salesid;

    private Date posttime;

    private Integer productstatus;

    private String searchimgpath;

    private String simgpath1;

    private String simgpath2;

    private String mimgpath1;

    private String mimgpath2;

    private String bimgpath1;

    private String bimgpath2;

    private String detailimgpath1;

    private String detailimgpath2;

    private String item1;

    private String item2;

    private String detailimgpath3;

    private Item item;

    private Seconditem seconditem;

    private List<Sku> skuList;

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

    public Integer getProductscore() {
        return productscore;
    }

    public void setProductscore(Integer productscore) {
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

    public Integer getProductstatus() {
        return productstatus;
    }

    public void setProductstatus(Integer productstatus) {
        this.productstatus = productstatus;
    }

    public String getSearchimgpath() {
        return searchimgpath;
    }

    public void setSearchimgpath(String searchimgpath) {
        this.searchimgpath = searchimgpath == null ? null : searchimgpath.trim();
    }

    public String getSimgpath1() {
        return simgpath1;
    }

    public void setSimgpath1(String simgpath1) {
        this.simgpath1 = simgpath1 == null ? null : simgpath1.trim();
    }

    public String getSimgpath2() {
        return simgpath2;
    }

    public void setSimgpath2(String simgpath2) {
        this.simgpath2 = simgpath2 == null ? null : simgpath2.trim();
    }

    public String getMimgpath1() {
        return mimgpath1;
    }

    public void setMimgpath1(String mimgpath1) {
        this.mimgpath1 = mimgpath1 == null ? null : mimgpath1.trim();
    }

    public String getMimgpath2() {
        return mimgpath2;
    }

    public void setMimgpath2(String mimgpath2) {
        this.mimgpath2 = mimgpath2 == null ? null : mimgpath2.trim();
    }

    public String getBimgpath1() {
        return bimgpath1;
    }

    public void setBimgpath1(String bimgpath1) {
        this.bimgpath1 = bimgpath1 == null ? null : bimgpath1.trim();
    }

    public String getBimgpath2() {
        return bimgpath2;
    }

    public void setBimgpath2(String bimgpath2) {
        this.bimgpath2 = bimgpath2 == null ? null : bimgpath2.trim();
    }

    public String getDetailimgpath1() {
        return detailimgpath1;
    }

    public void setDetailimgpath1(String detailimgpath1) {
        this.detailimgpath1 = detailimgpath1 == null ? null : detailimgpath1.trim();
    }

    public String getDetailimgpath2() {
        return detailimgpath2;
    }

    public void setDetailimgpath2(String detailimgpath2) {
        this.detailimgpath2 = detailimgpath2 == null ? null : detailimgpath2.trim();
    }

    public String getDetailimgpath3() {
        return detailimgpath3;
    }

    public void setDetailimgpath3(String detailimgpath3) {
        this.detailimgpath3 = detailimgpath3 == null ? null : detailimgpath3.trim();
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Seconditem getSeconditem() {
        return seconditem;
    }

    public void setSeconditem(Seconditem seconditem) {
        this.seconditem = seconditem;
    }

    public List<Sku> getSkuList() {
        return skuList;
    }

    public void setSkuList(List<Sku> skuList) {
        this.skuList = skuList;
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
                ", productstatus=" + productstatus +
                ", searchimgpath='" + searchimgpath + '\'' +
                ", simgpath1='" + simgpath1 + '\'' +
                ", simgpath2='" + simgpath2 + '\'' +
                ", mimgpath1='" + mimgpath1 + '\'' +
                ", mimgpath2='" + mimgpath2 + '\'' +
                ", bimgpath1='" + bimgpath1 + '\'' +
                ", bimgpath2='" + bimgpath2 + '\'' +
                ", detailimgpath1='" + detailimgpath1 + '\'' +
                ", detailimgpath2='" + detailimgpath2 + '\'' +
                ", item1='" + item1 + '\'' +
                ", item2='" + item2 + '\'' +
                ", detailimgpath3='" + detailimgpath3 + '\'' +
                ", item=" + item +
                ", seconditem=" + seconditem +
                ", skuList=" + skuList +
                '}';
    }
}