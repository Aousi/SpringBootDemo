package org.aousi.springboot.demo.mapper;

import org.aousi.springboot.demo.Entities.cRecords;
import org.springframework.stereotype.Repository;

@Repository
public interface cRecordsMapper {
    int deleteByPrimaryKey(Integer crid);

    int insert(cRecords record);

    int insertSelective(cRecords record);

    cRecords selectByPrimaryKey(Integer crid);

    int updateByPrimaryKeySelective(cRecords record);

    int updateByPrimaryKey(cRecords record);
}