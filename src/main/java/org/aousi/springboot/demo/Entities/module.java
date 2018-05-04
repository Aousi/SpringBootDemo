package org.aousi.springboot.demo.Entities;

import java.util.HashSet;
import java.util.Set;

public class module {
    private Integer mid;

    private String modulename;

    private Set<role> roles = new HashSet<>();

    public Set<role> getRoles() {
        return roles;
    }

    public void setRoles(Set<role> roles) {
        this.roles = roles;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getModulename() {
        return modulename;
    }

    public void setModulename(String modulename) {
        this.modulename = modulename == null ? null : modulename.trim();
    }

}