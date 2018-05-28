package org.aousi.springboot.demo.mapper;

import org.aousi.springboot.demo.Entities.cCompleted;
import org.springframework.stereotype.Repository;

@Repository
public interface cCompletedMapper {
    int deleteByPrimaryKey(Integer ccid);

    int insert(cCompleted record);

    int insertSelective(cCompleted record);

    cCompleted selectByPrimaryKey(Integer ccid);

    int updateByPrimaryKeySelective(cCompleted record);

    int updateByPrimaryKey(cCompleted record);
}