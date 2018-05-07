package org.aousi.springboot.demo.mapper;

import org.aousi.springboot.demo.Entities.UserRole;
import org.springframework.stereotype.Component;

@Component(value = "UserRoleMapper")
public interface UserRoleMapper {
    int insert(UserRole record);

    int insertSelective(UserRole record);
}