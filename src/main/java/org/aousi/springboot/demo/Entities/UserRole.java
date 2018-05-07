package org.aousi.springboot.demo.Entities;

public class UserRole {
    private Integer uid;

    private Integer rid;

    public UserRole() {
    }

    public UserRole(Integer uid) {
        this.uid = uid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }
}