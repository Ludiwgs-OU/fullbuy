package com.we.fullbuy.serviceImpl;

import com.we.fullbuy.dao.ItemMapper;
import com.we.fullbuy.dao.SeconditemMapper;
import com.we.fullbuy.pojo.Item;
import com.we.fullbuy.pojo.Seconditem;
import com.we.fullbuy.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ItemService")
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private SeconditemMapper seconditemMapper;

    @Override
    public List<Item> displayItem() {
        return itemMapper.displayItem();
    }

    @Override
    public List<Seconditem> displaySecondItem() {
        return seconditemMapper.displaySecondItem();
    }

    @Override
    public int addItem(Item item) {
        return itemMapper.insert(item);
    }

    @Override
    public int addSecondItem(Seconditem seconditem) {
        return seconditemMapper.insert(seconditem);
    }
}
