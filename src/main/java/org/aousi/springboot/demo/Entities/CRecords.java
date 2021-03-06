package org.aousi.springboot.demo.Entities;

import java.util.Date;
import java.util.Set;

public class CRecords {
    private Integer crid;

    private Integer coid;

    private Integer ccid;

    private Integer uid;

    private Date crEdtTime;

    private Date crCrtTime;

    private COrder co;

    private CCompleted cc;

    public CRecords() {
    }

    public COrder getCo() {
        return co;
    }

    public void setCo(COrder co) {
        this.co = co;
    }

    public CCompleted getCc() {
        return cc;
    }

    public void setCc(CCompleted cc) {
        this.cc = cc;
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

    public Date getCrEdtTime() {
        return crEdtTime;
    }

    public void setCrEdtTime(Date crEdtTime) {
        this.crEdtTime = crEdtTime;
    }

    public Date getCrCrtTime() {
        return crCrtTime;
    }

    public void setCrCrtTime(Date crCrtTime) {
        this.crCrtTime = crCrtTime;
    }
}