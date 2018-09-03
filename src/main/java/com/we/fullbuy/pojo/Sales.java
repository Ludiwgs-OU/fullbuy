package com.we.fullbuy.pojo;

public class Sales {
    private Integer salesid;

    private String salaespwd;

    private String salaesname;

    private String salesphone;

    private String salesaddress;

    private String salesdetail;

    public Integer getSalesid() {
        return salesid;
    }

    public void setSalesid(Integer salesid) {
        this.salesid = salesid;
    }

    public String getSalaespwd() {
        return salaespwd;
    }

    public void setSalaespwd(String salaespwd) {
        this.salaespwd = salaespwd == null ? null : salaespwd.trim();
    }

    public String getSalaesname() {
        return salaesname;
    }

    public void setSalaesname(String salaesname) {
        this.salaesname = salaesname == null ? null : salaesname.trim();
    }

    public String getSalesphone() {
        return salesphone;
    }

    public void setSalesphone(String salesphone) {
        this.salesphone = salesphone == null ? null : salesphone.trim();
    }

    public String getSalesaddress() {
        return salesaddress;
    }

    public void setSalesaddress(String salesaddress) {
        this.salesaddress = salesaddress == null ? null : salesaddress.trim();
    }

    public String getSalesdetail() {
        return salesdetail;
    }

    public void setSalesdetail(String salesdetail) {
        this.salesdetail = salesdetail == null ? null : salesdetail.trim();
    }
}