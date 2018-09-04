package com.we.fullbuy.pojo;

public class Sku {
    private Integer skuid;

    private Integer productid;

    private Integer colorid;

    private Integer itemid;

    private Double price;

    private Integer quantity;

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

    public Integer getColorid() {
        return colorid;
    }

    public void setColorid(Integer colorid) {
        this.colorid = colorid;
    }

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
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

    @Override
    public String toString() {
        return "Sku{" +
                "skuid=" + skuid +
                ", productid=" + productid +
                ", colorid=" + colorid +
                ", itemid=" + itemid +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}