package com.we.fullbuy.pojo;

public class Item {
    private Integer itemid;

    private String itemname;

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname == null ? null : itemname.trim();
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemid=" + itemid +
                ", itemname='" + itemname + '\'' +
                '}';
    }
}