package org.aousi.springboot.demo.mapper;

import org.aousi.springboot.demo.Entities.RoleModule;
import org.springframework.stereotype.Component;

@Component(value = "RoleModuleMapper")
public interface RoleModuleMapper {
    int insert(RoleModule record);

    int insertSelective(RoleModule record);
}