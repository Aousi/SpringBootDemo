package org.aousi.springboot.demo.Entities;

import java.util.Date;

public class Article {
    private Integer aid;

    private String title;

    private String author;

    private String context;

    private Date publishTime;

    private Date lastEditTime;

    private Date overdueTime;

    private Integer aLevel;

    private String aCode;

    private Integer aType;

    private Integer aStatus;

    public Article() {
    }

    public Article(String title, String author, String context, Integer aLevel, String aCode, Integer aType) {
        this.title = title;
        this.author = author;
        this.context = context;
        this.aLevel = aLevel;
        this.aCode = aCode;
        this.aType = aType;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Date getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }

    public Date getOverdueTime() {
        return overdueTime;
    }

    public void setOverdueTime(Date overdueTime) {
        this.overdueTime = overdueTime;
    }

    public Integer getaLevel() {
        return aLevel;
    }

    public void setaLevel(Integer aLevel) {
        this.aLevel = aLevel;
    }

    public String getaCode() {
        return aCode;
    }

    public void setaCode(String aCode) {
        this.aCode = aCode == null ? null : aCode.trim();
    }

    public Integer getaType() {
        return aType;
    }

    public void setaType(Integer aType) {
        this.aType = aType;
    }

    public Integer getaStatus() {
        return aStatus;
    }

    public void setaStatus(Integer aStatus) {
        this.aStatus = aStatus;
    }
}