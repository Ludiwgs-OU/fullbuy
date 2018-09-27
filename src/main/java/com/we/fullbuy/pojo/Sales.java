package com.we.fullbuy.pojo;

import java.io.Serializable;

public class Sales implements Serializable {
    private Integer salesId;

    private String salaesPwd;

    private String salaesName;

    private String salesPhone;

    private String salesAddress;

    private String salesDetail;

    private Integer salesStatus;

    private String salesEmail;

    private Integer black;

    private String loginPhone;

    private String salesImgPath;

    public Integer getSalesId() {
        return salesId;
    }

    public void setSalesId(Integer salesId) {
        this.salesId = salesId;
    }

    public String getSalaesPwd() {
        return salaesPwd;
    }

    public void setSalaesPwd(String salaesPwd) {
        this.salaesPwd = salaesPwd == null ? null : salaesPwd.trim();
    }

    public String getSalaesName() {
        return salaesName;
    }

    public void setSalaesName(String salaesName) {
        this.salaesName = salaesName == null ? null : salaesName.trim();
    }

    public String getSalesPhone() {
        return salesPhone;
    }

    public void setSalesPhone(String salesPhone) {
        this.salesPhone = salesPhone == null ? null : salesPhone.trim();
    }

    public String getSalesAddress() {
        return salesAddress;
    }

    public void setSalesAddress(String salesAddress) {
        this.salesAddress = salesAddress == null ? null : salesAddress.trim();
    }

    public String getSalesDetail() {
        return salesDetail;
    }

    public void setSalesDetail(String salesDetail) {
        this.salesDetail = salesDetail == null ? null : salesDetail.trim();
    }

    public Integer getSalesStatus() {
        return salesStatus;
    }

    public void setSalesStatus(Integer salesStatus) {
        this.salesStatus = salesStatus;
    }

    public String getSalesEmail() {
        return salesEmail;
    }

    public void setSalesEmail(String salesEmail) {
        this.salesEmail = salesEmail == null ? null : salesEmail.trim();
    }

    public Integer getBlack() {
        return black;
    }

    public void setBlack(Integer black) {
        this.black = black;
    }

    public String getLoginPhone() {
        return loginPhone;
    }

    public void setLoginPhone(String loginPhone) {
        this.loginPhone = loginPhone == null ? null : loginPhone.trim();
    }

    public String getSalesImgPath() {
        return salesImgPath;
    }

    public void setSalesImgPath(String salesImgPath) {
        this.salesImgPath = salesImgPath == null ? null : salesImgPath.trim();
    }
}