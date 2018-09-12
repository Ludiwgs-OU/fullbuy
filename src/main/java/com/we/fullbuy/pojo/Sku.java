package com.we.fullbuy.pojo;

import java.util.List;

public class Sku {
    private Integer skuid;

    private Integer productid;

    private Integer itemid;

    private Integer seconditemid;

    private Double price;

    private Integer quantity;

    private Double gbprice;

    private List<Item> itemList;

    private List<Seconditem> seconditemList;

    public Integer getSkuid() {
        return skuid;
    }

    public void setSkuid(Integer skuid) {
        this.skuid = skuid;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    public Integer getSeconditemid() {
        return seconditemid;
    }

    public void setSeconditemid(Integer seconditemid) {
        this.seconditemid = seconditemid;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getGbprice() {
        return gbprice;
    }

    public void setGbprice(Double gbprice) {
        this.gbprice = gbprice;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public List<Seconditem> getSeconditemList() {
        return seconditemList;
    }

    public void setSeconditemList(List<Seconditem> seconditemList) {
        this.seconditemList = seconditemList;
    }

    @Override
    public String toString() {
        return "Sku{" +
                "skuid=" + skuid +
                ", productid=" + productid +
                ", itemid=" + itemid +
                ", seconditemid=" + seconditemid +
                ", price=" + price +
                ", quantity=" + quantity +
                ", gbprice=" + gbprice +
                ", itemList=" + itemList +
                ", seconditemList=" + seconditemList +
                '}';
    }
}