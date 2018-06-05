package org.aousi.springboot.demo.mapper;

import org.aousi.springboot.demo.Entities.CRecords;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CRecordsMapper {
    int deleteByPrimaryKey(Integer crid);

    int insert(CRecords record);

    int insertSelective(CRecords record);

    CRecords selectByPrimaryKey(Integer crid);

    int updateByPrimaryKeySelective(CRecords record);

    int updateByPrimaryKey(CRecords record);

    List<CRecords> userCRList(Integer uid);
}