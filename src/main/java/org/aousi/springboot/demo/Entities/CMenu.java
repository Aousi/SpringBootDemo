package org.aousi.springboot.demo.Entities;

public class CMenu {
    private Integer cmid;

    private String sun;

    private String mon;

    private String tue;

    private String wed;

    private String thu;

    private String fri;

    private String sat;

    private Integer cmType;

    private Integer cmStatus;

    public Integer getCmid() {
        return cmid;
    }

    public void setCmid(Integer cmid) {
        this.cmid = cmid;
    }

    public String getSun() {
        return sun;
    }

    public void setSun(String sun) {
        this.sun = sun == null ? null : sun.trim();
    }

    public String getMon() {
        return mon;
    }

    public void setMon(String mon) {
        this.mon = mon == null ? null : mon.trim();
    }

    public String getTue() {
        return tue;
    }

    public void setTue(String tue) {
        this.tue = tue == null ? null : tue.trim();
    }

    public String getWed() {
        return wed;
    }

    public void setWed(String wed) {
        this.wed = wed == null ? null : wed.trim();
    }

    public String getThu() {
        return thu;
    }

    public void setThu(String thu) {
        this.thu = thu == null ? null : thu.trim();
    }

    public String getFri() {
        return fri;
    }

    public void setFri(String fri) {
        this.fri = fri == null ? null : fri.trim();
    }

    public String getSat() {
        return sat;
    }

    public void setSat(String sat) {
        this.sat = sat == null ? null : sat.trim();
    }

    public Integer getCmType() {
        return cmType;
    }

    public void setCmType(Integer cmType) {
        this.cmType = cmType;
    }

    public Integer getCmStatus() {
        return cmStatus;
    }

    public void setCmStatus(Integer cmStatus) {
        this.cmStatus = cmStatus;
    }
}