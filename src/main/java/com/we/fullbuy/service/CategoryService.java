package com.we.fullbuy.service;

import com.we.fullbuy.pojo.Category;
import com.we.fullbuy.pojo.Secondcategory;

import java.util.List;

public interface CategoryService {

    /*获取Category*/
    List<Category> displayCategory();
    /*获取二级Category*/
    List<Secondcategory> displaySecondCategory(int categoryId);
}
