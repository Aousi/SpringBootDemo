package org.aousi.springboot.demo.mapper;

import org.aousi.springboot.demo.Entities.Module;

public interface moduleMapper {
    int deleteByPrimaryKey(Integer mid);

    int insert(Module record);

    int insertSelective(Module record);

    Module selectByPrimaryKey(Integer mid);

    int updateByPrimaryKeySelective(Module record);

    int updateByPrimaryKey(Module record);
}