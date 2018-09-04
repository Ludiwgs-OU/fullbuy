package com.we.fullbuy.pojo;

import java.util.Date;

public class User {
    private Integer userid;

    private String loginname;

    private String loginpwd;

    private String username;

    private Integer usertype;

    private String userqq;

    private String userphone;

    private String useremail;

    private String sex;

    private Integer userscore;

    private Integer userstatus;

    private Date lastlogintime;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname == null ? null : loginname.trim();
    }

    public String getLoginpwd() {
        return loginpwd;
    }

    public void setLoginpwd(String loginpwd) {
        this.loginpwd = loginpwd == null ? null : loginpwd.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Integer getUsertype() {
        return usertype;
    }

    public void setUsertype(Integer usertype) {
        this.usertype = usertype;
    }

    public String getUserqq() {
        return userqq;
    }

    public void setUserqq(String userqq) {
        this.userqq = userqq == null ? null : userqq.trim();
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone == null ? null : userphone.trim();
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail == null ? null : useremail.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Integer getUserscore() {
        return userscore;
    }

    public void setUserscore(Integer userscore) {
        this.userscore = userscore;
    }

    public Integer getUserstatus() {
        return userstatus;
    }

    public void setUserstatus(Integer userstatus) {
        this.userstatus = userstatus;
    }

    public Date getLastlogintime() {
        return lastlogintime;
    }

    public void setLastlogintime(Date lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", loginname='" + loginname + '\'' +
                ", loginpwd='" + loginpwd + '\'' +
                ", username='" + username + '\'' +
                ", usertype=" + usertype +
                ", userqq='" + userqq + '\'' +
                ", userphone='" + userphone + '\'' +
                ", useremail='" + useremail + '\'' +
                ", sex='" + sex + '\'' +
                ", userscore=" + userscore +
                ", userstatus=" + userstatus +
                ", lastlogintime=" + lastlogintime +
                '}';
    }
}