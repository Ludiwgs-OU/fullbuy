package com.we.fullbuy.dao;

import com.we.fullbuy.pojo.Product;

import java.util.List;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer productid);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer productid);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    /*new*/
    /*显示商品详情*/
    Product displayProductDetail(Integer productid);
    /*商品列表*/
    List<Product> showProducts ();
    /*根据关键字搜索商品*/
    List<Product> searchProductByKeyword(String keyword);
    /*根据一级种类搜索商品*/
    List<Product> searchProductByFirstCategory(Integer categoryId);
    /*二级种类搜索商品*/
    List<Product> searchProductBySecondCategory(Integer secondCategoryId);
    /*根据skuID查商品信息*/
    Product searchBySkuId(Integer skuid);
    /*根据销量查询商品*/
    List<Product> displayBySalesnum();
}