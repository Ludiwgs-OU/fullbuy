package com.we.fullbuy.pojo;

public class Sku {
    private Integer skuid;

    private Integer productid;

    private Integer itemid;

    private Integer seconditemid;

    private Double price;

    private Integer quantity;

    private Double gbprice;

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
}