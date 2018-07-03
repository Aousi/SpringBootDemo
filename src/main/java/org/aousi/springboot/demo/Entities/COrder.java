package org.aousi.springboot.demo.Entities;

import java.util.Date;

public class COrder {
    private Integer coid;

    private Integer breakfast;

    private Integer bfMany;

    private Integer lunch;

    private Integer lMany;

    private Integer dinner;

    private Integer dMany;

    private Date oTime;

    private Date oCrtTime;

    private Date oEditTime;

    private Integer uid;

    private User user;

    public COrder() {
    }

    public COrder(Integer breakfast, Integer bfMany, Integer lunch, Integer lMany, Integer dinner, Integer dMany, Date oCrtTime, Integer uid) {
        this.breakfast = breakfast;
        this.bfMany = bfMany;
        this.lunch = lunch;
        this.lMany = lMany;
        this.dinner = dinner;
        this.dMany = dMany;
        this.oCrtTime = oCrtTime;
        this.uid = uid;
    }

    public COrder(Integer coid, Integer breakfast, Integer bfMany, Integer lunch, Integer lMany, Integer dinner, Integer dMany) {
        this.coid = coid;
        this.breakfast = breakfast;
        this.bfMany = bfMany;
        this.lunch = lunch;
        this.lMany = lMany;
        this.dinner = dinner;
        this.dMany = dMany;
    }

    public COrder(Integer coid, Integer breakfast, Integer bfMany, Integer lunch, Integer lMany, Integer dinner, Integer dMany, Integer uid) {
        this.coid = coid;
        this.breakfast = breakfast;
        this.bfMany = bfMany;
        this.lunch = lunch;
        this.lMany = lMany;
        this.dinner = dinner;
        this.dMany = dMany;
        this.uid = uid;
    }

    public COrder(Integer coid, Integer breakfast, Integer bfMany, Integer lunch, Integer lMany, Integer dinner, Integer dMany, Date oTime) {
        this.coid = coid;
        this.breakfast = breakfast;
        this.bfMany = bfMany;
        this.lunch = lunch;
        this.lMany = lMany;
        this.dinner = dinner;
        this.dMany = dMany;
        this.oTime = oTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getoEditTime() {
        return oEditTime;
    }

    public void setoEditTime(Date oEditTime) {
        this.oEditTime = oEditTime;
    }

    public Integer getCoid() {
        return coid;
    }

    public void setCoid(Integer coid) {
        this.coid = coid;
    }

    public Integer getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(Integer breakfast) {
        this.breakfast = breakfast;
    }

    public Integer getBfMany() {
        return bfMany;
    }

    public void setBfMany(Integer bfMany) {
        this.bfMany = bfMany;
    }

    public Integer getLunch() {
        return lunch;
    }

    public void setLunch(Integer lunch) {
        this.lunch = lunch;
    }

    public Integer getlMany() {
        return lMany;
    }

    public void setlMany(Integer lMany) {
        this.lMany = lMany;
    }

    public Integer getDinner() {
        return dinner;
    }

    public void setDinner(Integer dinner) {
        this.dinner = dinner;
    }

    public Integer getdMany() {
        return dMany;
    }

    public void setdMany(Integer dMany) {
        this.dMany = dMany;
    }

    public Date getoTime() {
        return oTime;
    }

    public void setoTime(Date oTime) {
        this.oTime = oTime;
    }

    public Date getoCrtTime() {
        return oCrtTime;
    }

    public void setoCrtTime(Date oCrtTime) {
        this.oCrtTime = oCrtTime;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}