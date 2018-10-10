package com.we.fullbuy.pojo;

import java.io.Serializable;
import java.util.List;

public class Sku implements Serializable {
    private Integer skuId;

    private Integer productId;

    private Integer itemId;

    private Integer secondItemId;

    private Double price;

    private Double gbPrice;

    private Integer quantity;

    private Item item;

    private Seconditem secondItem;

    private List<Item> itemList;

    private List<Seconditem> secondItemList;

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getSecondItemId() {
        return secondItemId;
    }

    public void setSecondItemId(Integer secondItemId) {
        this.secondItemId = secondItemId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getGbPrice() {
        return gbPrice;
    }

    public void setGbPrice(Double gbPrice) {
        this.gbPrice = gbPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Seconditem getSecondItem() {
        return secondItem;
    }

    public void setSecondItem(Seconditem secondItem) {
        this.secondItem = secondItem;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public List<Seconditem> getSecondItemList() {
        return secondItemList;
    }

    public void setSecondItemList(List<Seconditem> secondItemList) {
        this.secondItemList = secondItemList;
    }
}