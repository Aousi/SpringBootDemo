package org.aousi.springboot.demo.mapper;

import org.aousi.springboot.demo.Entities.cOrder;
import org.springframework.stereotype.Repository;

@Repository
public interface cOrderMapper {
    int deleteByPrimaryKey(Integer coid);

    int insert(cOrder record);

    int insertSelective(cOrder record);

    cOrder selectByPrimaryKey(Integer coid);

    int updateByPrimaryKeySelective(cOrder record);

    int updateByPrimaryKey(cOrder record);
}