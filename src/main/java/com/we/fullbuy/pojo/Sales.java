package com.we.fullbuy.pojo;

import java.io.Serializable;

public class Sales implements Serializable {
    private Integer salesid;

    private String salaespwd;

    private String salaesname;

    private String salesphone;

    private String salesaddress;

    private String salesdetail;

    private Integer salesstatus;

    private String salesemail;

    private Integer black;

    private String loginphone;

    private String salesimgpath;

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

    public Integer getSalesstatus() {
        return salesstatus;
    }

    public void setSalesstatus(Integer salesstatus) {
        this.salesstatus = salesstatus;
    }

    public String getSalesemail() {
        return salesemail;
    }

    public void setSalesemail(String salesemail) {
        this.salesemail = salesemail == null ? null : salesemail.trim();
    }

    public Integer getBlack() {
        return black;
    }

    public void setBlack(Integer black) {
        this.black = black;
    }

    public String getLoginphone() {
        return loginphone;
    }

    public void setLoginphone(String loginphone) {
        this.loginphone = loginphone == null ? null : loginphone.trim();
    }

    public String getSalesimgpath() {
        return salesimgpath;
    }

    public void setSalesimgpath(String salesimgpath) {
        this.salesimgpath = salesimgpath;
    }
}