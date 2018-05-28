package org.aousi.springboot.demo.Entities;

import java.util.Date;

public class cRecords {
    private Integer crid;

    private Integer coid;

    private Integer ccid;

    private Integer uid;

    private Date crTime;

    public cRecords() {
    }

    public cRecords(Integer coid, Integer ccid, Integer uid, Date crTime) {
        this.coid = coid;
        this.ccid = ccid;
        this.uid = uid;
        this.crTime = crTime;
    }

    public Integer getCrid() {
        return crid;
    }

    public void setCrid(Integer crid) {
        this.crid = crid;
    }

    public Integer getCoid() {
        return coid;
    }

    public void setCoid(Integer coid) {
        this.coid = coid;
    }

    public Integer getCcid() {
        return ccid;
    }

    public void setCcid(Integer ccid) {
        this.ccid = ccid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getCrTime() {
        return crTime;
    }

    public void setCrTime(Date crTime) {
        this.crTime = crTime;
    }
}