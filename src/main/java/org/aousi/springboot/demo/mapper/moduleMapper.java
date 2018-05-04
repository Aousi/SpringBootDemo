package org.aousi.springboot.demo.mapper;

import org.aousi.springboot.demo.Entities.module;

public interface moduleMapper {
    int deleteByPrimaryKey(Integer mid);

    int insert(module record);

    int insertSelective(module record);

    module selectByPrimaryKey(Integer mid);

    int updateByPrimaryKeySelective(module record);

    int updateByPrimaryKey(module record);
}