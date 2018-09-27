package com.we.fullbuy.pojo;

import java.io.Serializable;
import java.util.List;

public class Item implements Serializable {
    private Integer itemId;

    private String itemName;

    private List<Seconditem> seconditemList;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public List<Seconditem> getSeconditemList() {
        return seconditemList;
    }

    public void setSeconditemList(List<Seconditem> seconditemList) {
        this.seconditemList = seconditemList;
    }
}