package org.aousi.springboot.demo.mapper;

import org.aousi.springboot.demo.Entities.COrder;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface COrderMapper {
    int deleteByPrimaryKey(Integer coid);

    int insert(COrder record);

    int insertSelective(COrder record);

    COrder selectByPrimaryKey(Integer coid);

    int updateByPrimaryKeySelective(COrder record);

    int updateByPrimaryKey(COrder record);

    int ListInsert(@Param("list") List<COrder> cOrder);

    int orderIsExistByDate(Date oTime);

    List<COrder> selectByUid(@Param("uid")Integer uid);

    List<COrder> B_selectAll();

    List<COrder> B_selectByUid(@Param("uid")Integer uid);

    List<COrder> B_selectByDate(@Param("oTime")Date date);

    List<COrder> B_selectByDateUid(@Param("oTime")Date date,@Param("uid")Integer uid);

    List<COrder> B_selectByBreakfastDate(@Param("oTime")Date date);

    List<COrder> B_selectByLunchDate(@Param("oTime")Date date);

    List<COrder> B_selectByDinnerDate(@Param("oTime")Date date);



}