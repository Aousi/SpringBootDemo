package org.aousi.springboot.demo.Entities;

import java.util.Set;

public class Role {
    private Integer rid;

    private String rolename;

    private Set<User> users;

    private Set<Module> Modules;

    public Role() {
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Role(Set<Module> Modules) {
        this.Modules = Modules;
    }

    public Set<Module> getModules() {
        return Modules;
    }

    public void setModules(Set<Module> Modules) {
        this.Modules = Modules;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }
}