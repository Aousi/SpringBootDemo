package org.aousi.springboot.demo.Entities;

import java.util.HashSet;
import java.util.Set;

public class User {
    private Integer uid;

    private String username;

    private String password;

    private String area;

    private String department;

    private String tel;

    private String phone;

    private String eMail;

    private Set<Role> Roles = new HashSet<>();

    public User() {
    }



    public User(String username, String password, String eMail, Set<Role> Roles) {
        this.username = username;
        this.password = password;
        this.eMail = eMail;
        this.Roles = Roles;
    }

    public Set<Role> getRoles() {
        return Roles;
    }

    public void setRoles(Set<Role> Roles) {
        this.Roles = Roles;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail == null ? null : eMail.trim();
    }
}