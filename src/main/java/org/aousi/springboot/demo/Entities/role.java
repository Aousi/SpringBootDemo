package org.aousi.springboot.demo.Entities;

import java.util.Set;

public class role {
    private Integer rid;

    private String rolename;

    private Set<module> modules;

    public role() {
    }

    public role(Set<module> modules) {
        this.modules = modules;
    }

    public Set<module> getModules() {
        return modules;
    }

    public void setModules(Set<module> modules) {
        this.modules = modules;
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