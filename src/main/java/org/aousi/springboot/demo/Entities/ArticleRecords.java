package org.aousi.springboot.demo.Entities;

import java.util.Date;

public class ArticleRecords {
    private Integer arid;

    private Integer aid;

    private Date time;

    public Integer getArid() {
        return arid;
    }

    public void setArid(Integer arid) {
        this.arid = arid;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}