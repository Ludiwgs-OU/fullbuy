package com.we.fullbuy.serviceImpl;

import com.we.fullbuy.dao.CategoryMapper;
import com.we.fullbuy.dao.SecondcategoryMapper;
import com.we.fullbuy.pojo.Category;
import com.we.fullbuy.pojo.Secondcategory;
import com.we.fullbuy.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CategoryService")
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private SecondcategoryMapper secondcategoryMapper;

    @Override
    public List<Category> displayCategory() {
        return null;
    }

    @Override
    public List<Secondcategory> displaySecondCategory(int categoryId) {
        return null;
    }
}
