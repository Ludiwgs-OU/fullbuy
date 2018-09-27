package com.we.fullbuy.serviceImpl;

import com.we.fullbuy.dao.SkuMapper;
import com.we.fullbuy.pojo.Sku;
import com.we.fullbuy.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("SkuService")
public class SkuServiceImpl implements SkuService {
    @Autowired
    private SkuMapper skuMapper;

    @Override
    @Transactional
    public int addSku(Sku sku) {
        return skuMapper.insert(sku);
    }

    @Override
    @Transactional
    public int deleteSku(int skuId) {
        return skuMapper.deleteByPrimaryKey(skuId);
    }

    @Override
    public Sku showSku(int skuId) {
        return skuMapper.selectByPrimaryKey(skuId);
    }

    @Override
    @Transactional
    public int updateSku(Sku sku) {
        return skuMapper.updateByPrimaryKeySelective(sku);
    }

    @Override
    public Sku getPrice(int productId, int itemId, int secondItemId) {
        return skuMapper.getPrice(productId,itemId,secondItemId);
    }
}
