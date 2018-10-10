package com.we.fullbuy.pojo;

import java.io.Serializable;
import java.util.List;

public class Category implements Serializable {
    private Integer categoryId;

    private String categoryName;

    private List<Secondcategory> secondCategoryList;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public List<Secondcategory> getSecondCategoryList() {
        return secondCategoryList;
    }

    public void setSecondCategoryList(List<Secondcategory> secondCategoryList) {
        this.secondCategoryList = secondCategoryList;
    }
}