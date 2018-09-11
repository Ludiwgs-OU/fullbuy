package com.we.fullbuy.serviceImpl;

import com.we.fullbuy.dao.ProductMapper;
import com.we.fullbuy.pojo.Product;
import com.we.fullbuy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ProductService")
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public int addProduct(Product product) {
        return productMapper.insert(product);
    }

    @Override
    public int modifyProduct(Product product) {
        return productMapper.updateByPrimaryKeySelective(product);
    }

    @Override
    public int deleteProduct(int productId) {
        return productMapper.deleteByPrimaryKey(productId);
    }

    @Override
    public List<Product> showProduct() {
        return null;
    }

    @Override
    public Product showProductDetail(int productId) {
        return productMapper.selectByPrimaryKey(productId);
    }

    @Override
    public List<Product> searchProductByKeyword(String keyword) {
        return null;
    }

    @Override
    public List<Product> searchProductByCategory(int categoryId, int secondCategoryId) {
        return null;
    }
}
