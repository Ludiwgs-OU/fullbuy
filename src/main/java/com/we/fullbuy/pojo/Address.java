package com.we.fullbuy.pojo;

import java.io.Serializable;

public class Address implements Serializable {
    private Integer addressid;

    private Integer userid;

    private String addressdetail;

    private String postcode;

    private String phone;

    private String name;

    private Integer defaultaddress;

    private String province;

    private String city;

    private String street;

    public Integer getAddressid() {
        return addressid;
    }

    public void setAddressid(Integer addressid) {
        this.addressid = addressid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getAddressdetail() {
        return addressdetail;
    }

    public void setAddressdetail(String addressdetail) {
        this.addressdetail = addressdetail == null ? null : addressdetail.trim();
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode == null ? null : postcode.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getDefaultaddress() {
        return defaultaddress;
    }

    public void setDefaultaddress(Integer defaultaddress) {
        this.defaultaddress = defaultaddress;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getcity() {
        return city;
    }

    public void setcity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street == null ? null : street.trim();
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressid=" + addressid +
                ", userid=" + userid +
                ", addressdetail='" + addressdetail + '\'' +
                ", postcode='" + postcode + '\'' +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", defaultaddress=" + defaultaddress +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}