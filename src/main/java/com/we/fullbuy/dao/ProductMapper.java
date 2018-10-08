package com.we.fullbuy.dao;

import com.we.fullbuy.pojo.Product;

import java.util.List;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer productId);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer productId);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    /*new*/
    /*显示商品详情*/
    Product displayProductDetail(Integer productId);
    /*商品列表*/
    List<Product> showProducts();
    /*显示商家商品*/
    List<Product> displaySalesProducts(Integer salesId);
    /*根据关键字搜索商品*/
    List<Product> searchProductByKeyword(String keyword);
    /*根据一级种类搜索商品*/
    List<Product> searchProductByFirstCategory(Integer categoryId);
    /*二级种类搜索商品*/
    List<Product> searchProductBySecondCategory(Integer secondCategoryId);
    /*根据skuID查商品信息*/
    Product searchBySkuId(Integer skuId);
    /*根据销量显示商品*/
    List<Product> displayBySalesnum();
    /*根据评分显示商品*/
    List<Product> displayByScore();
    /*根据上传时间显示商品*/
    List<Product> displayByPosttime();
    /*详情图片*/
    Product detailImgPth(Integer productId);
    /*相关商品推荐*/
    List<Product> relatedProduct(Integer productId);

}