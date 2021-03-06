package com.we.fullbuy.serviceImpl;

import com.we.fullbuy.dao.ProductMapper;
import com.we.fullbuy.pojo.Product;
import com.we.fullbuy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("ProductService")
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    @Transactional
    public int addProduct(Product product) {
        return productMapper.insert(product);
    }

    @Override
    @Transactional
    public int modifyProduct(Product product) {
        return productMapper.updateByPrimaryKeySelective(product);
    }

    @Override
    @Transactional
    public int deleteProduct(int productId) {
        return productMapper.deleteByPrimaryKey(productId);
    }

    @Override
    public List<Product> showProduct() {
        return productMapper.showProducts();
    }

    @Override
    public List<Product> displaySalesProducts(int salesId) {
        return productMapper.displaySalesProducts(salesId);
    }

    @Override
    public Product showProductDetail(int productId) {
        return productMapper.displayProductDetail(productId);
    }

    @Override
    public List<Product> searchProductByKeyword(String keyword) {
        return productMapper.searchProductByKeyword(keyword);
    }

    @Override
    public List<Product> searchProductByFirstCategory(int categoryId) {
        return productMapper.searchProductByFirstCategory(categoryId);
    }

    @Override
    public List<Product> searchProductBySecondCategory(int secondCategoryId) {
        return productMapper.searchProductBySecondCategory(secondCategoryId);
    }

    @Override
    public Product searchBySkuId(int skuId) {
        return productMapper.searchBySkuId(skuId);
    }

    @Override
    public List<Product> displayBySalesnum() {
        return productMapper.displayBySalesnum();
    }

    @Override
    public List<Product> displayByScore() {
        return productMapper.displayByScore();
    }

    @Override
    public List<Product> displayByPosttime() {
        return productMapper.displayByPosttime();
    }

    @Override
    public Product detailImgPth(int productId) {
        return productMapper.detailImgPth(productId);
    }

    @Override
    public List<Product> relatedProduct(int productId) {
        return productMapper.relatedProduct(productId);
    }
}
