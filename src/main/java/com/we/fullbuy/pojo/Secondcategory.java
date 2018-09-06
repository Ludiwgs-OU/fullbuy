package com.we.fullbuy.pojo;

public class Secondcategory {
    private Integer secondcategoryid;

    private String secondcategoryname;

    private Integer categoryid;

    public Integer getSecondcategoryid() {
        return secondcategoryid;
    }

    public void setSecondcategoryid(Integer secondcategoryid) {
        this.secondcategoryid = secondcategoryid;
    }

    public String getSecondcategoryname() {
        return secondcategoryname;
    }

    public void setSecondcategoryname(String secondcategoryname) {
        this.secondcategoryname = secondcategoryname == null ? null : secondcategoryname.trim();
    }

    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }
}