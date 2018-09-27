package com.we.fullbuy.pojo;

import java.io.Serializable;

public class Seconditem implements Serializable {
    private Integer secondItemId;

    private String secondItemName;

    public Integer getSecondItemId() {
        return secondItemId;
    }

    public void setSecondItemId(Integer secondItemId) {
        this.secondItemId = secondItemId;
    }

    public String getSecondItemName() {
        return secondItemName;
    }

    public void setSecondItemName(String secondItemName) {
        this.secondItemName = secondItemName == null ? null : secondItemName.trim();
    }
}