package org.aousi.springboot.demo.mapper;

import org.aousi.springboot.demo.Entities.role;

public interface roleMapper {
    int deleteByPrimaryKey(Integer rid);

    int insert(role record);

    int insertSelective(role record);

    role selectByPrimaryKey(Integer rid);

    int updateByPrimaryKeySelective(role record);

    int updateByPrimaryKey(role record);
}