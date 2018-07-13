package org.aousi.springboot.demo.mapper;

import org.aousi.springboot.demo.Entities.CRecords;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
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

    List<CRecords> B_CanteenRecord();

    List<CRecords> B_userCanteenRecord(Integer uid);

    List<CRecords> B_dateCanteenRecord(Date time);

    List<CRecords> B_userDateCanteenRecord(@Param("time")Date date, @Param("uid")Integer uid);
}