package org.aousi.springboot.demo.Entities;

import java.util.HashSet;
import java.util.Set;

public class role {
    private Integer rid;

    private String rolename;

    private Set<user> users = new HashSet<>();

    private Set<module> modules = new HashSet<>();

    public Set<module> getModules() {
        return modules;
    }

    public void setModules(Set<module> modules) {
        this.modules = modules;
    }

    public Set<user> getUsers() {
        return users;
    }

    public void setUsers(Set<user> users) {
        this.users = users;
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