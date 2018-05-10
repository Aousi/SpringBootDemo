package org.aousi.springboot.demo.mapper;

import org.aousi.springboot.demo.Entities.User;
import org.springframework.stereotype.Component;

@Component(value = "userMapper")
public interface userMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByUserName(String username);
}