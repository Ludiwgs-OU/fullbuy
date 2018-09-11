package com.we.fullbuy.serviceImpl;

import com.we.fullbuy.dao.SkuMapper;
import com.we.fullbuy.pojo.Sku;
import com.we.fullbuy.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SkuService")
public class SkuServiceImpl implements SkuService {
    @Autowired
    private SkuMapper skuMapper;

    @Override
    public int addSku(Sku sku) {
        return skuMapper.insert(sku);
    }

    @Override
    public int deleteSku(int skuId) {
        return skuMapper.deleteByPrimaryKey(skuId);
    }

    @Override
    public Sku showSku(int skuId) {
        return skuMapper.selectByPrimaryKey(skuId);
    }

    @Override
    public int updateSku(Sku sku) {
        return skuMapper.updateByPrimaryKeySelective(sku);
    }
}
