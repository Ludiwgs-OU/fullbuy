package com.we.fullbuy.pojo;

import java.io.Serializable;

public class Item implements Serializable {
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
}