package com.we.fullbuy.service;

import com.we.fullbuy.pojo.Item;
import com.we.fullbuy.pojo.Seconditem;

import java.util.List;

public interface ItemService {

    List<Item> displayItem();

    List<Seconditem> displaySecondItem();
}
