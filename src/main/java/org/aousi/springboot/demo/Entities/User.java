package org.aousi.springboot.demo.Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class User implements Serializable{



    private Integer uid;

    private String username;

    private String password;

    private String nickname;

    private String position;

    private String area;

    private String department;

    private String tel;

    private String phone;

    private String email;

    private Date registerTime;

    private Set<Role> roles;

    private Set<Module> modules;

    public User() {
    }

    public User(Integer uid, String username) {
        this.uid = uid;
        this.username = username;
    }

    public User(String username, String password, String email, Set<Role> roles) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.roles = roles;
    }

    public User(Integer uid, String username, String nickname, String position, String area, String department, String tel, String phone, String email) {
        this.uid = uid;
        this.username = username;
        this.nickname = nickname;
        this.position = position;
        this.area = area;
        this.department = department;
        this.tel = tel;
        this.phone = phone;
        this.email = email;
    }

    public Set<Module> getModules() {
        return modules;
    }

    public void setModules(Set<Module> modules) {
        this.modules = modules;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", position='" + position + '\'' +
                ", area='" + area + '\'' +
                ", department='" + department + '\'' +
                ", tel='" + tel + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", registerTime=" + registerTime +
                ", roles=" + roles +
                ", modules=" + modules +
                '}';
    }
}