package org.aousi.springboot.demo.mapper;

import org.aousi.springboot.demo.Entities.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByUserName(@Param("name") String name);

    User loginSelect(@Param("name") String name);

    int userIsExist(@Param("name") String name);

    User selectUid_Name(Integer uid);

    User identifyUser(@Param("name")String name);

    List<User> identifyUsers();

    List<User> selectRegisterUser();
}