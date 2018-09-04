package com.we.fullbuy.pojo;

public class News {
    private Integer newsid;

    private String newsdetail;

    private String newsimgpath;

    public Integer getNewsid() {
        return newsid;
    }

    public void setNewsid(Integer newsid) {
        this.newsid = newsid;
    }

    public String getNewsdetail() {
        return newsdetail;
    }

    public void setNewsdetail(String newsdetail) {
        this.newsdetail = newsdetail == null ? null : newsdetail.trim();
    }

    public String getNewsimgpath() {
        return newsimgpath;
    }

    public void setNewsimgpath(String newsimgpath) {
        this.newsimgpath = newsimgpath == null ? null : newsimgpath.trim();
    }

    @Override
    public String toString() {
        return "News{" +
                "newsid=" + newsid +
                ", newsdetail='" + newsdetail + '\'' +
                ", newsimgpath='" + newsimgpath + '\'' +
                '}';
    }
}