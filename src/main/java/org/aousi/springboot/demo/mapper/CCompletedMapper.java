package org.aousi.springboot.demo.mapper;

import org.aousi.springboot.demo.Entities.CCompleted;
import org.springframework.stereotype.Repository;

@Repository
public interface CCompletedMapper {
    int deleteByPrimaryKey(Integer ccid);

    int insert(CCompleted record);

    int insertSelective(CCompleted record);

    CCompleted selectByPrimaryKey(Integer ccid);

    int updateByPrimaryKeySelective(CCompleted record);

    int updateByPrimaryKey(CCompleted record);
}