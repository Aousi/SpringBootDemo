package org.aousi.springboot.demo.mapper;

import org.aousi.springboot.demo.Entities.user;

public interface userMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(user record);

    int insertSelective(user record);

    user selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(user record);

    int updateByPrimaryKey(user record);
}