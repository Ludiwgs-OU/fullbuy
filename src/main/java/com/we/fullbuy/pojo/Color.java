package com.we.fullbuy.pojo;

public class Color {
    private Integer colorid;

    private String colorname;

    public Integer getColorid() {
        return colorid;
    }

    public void setColorid(Integer colorid) {
        this.colorid = colorid;
    }

    public String getColorname() {
        return colorname;
    }

    public void setColorname(String colorname) {
        this.colorname = colorname == null ? null : colorname.trim();
    }

    @Override
    public String toString() {
        return "Color{" +
                "colorid=" + colorid +
                ", colorname='" + colorname + '\'' +
                '}';
    }
}