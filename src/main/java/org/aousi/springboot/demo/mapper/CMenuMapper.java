package org.aousi.springboot.demo.mapper;

import org.aousi.springboot.demo.Entities.CMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CMenuMapper {
    int deleteByPrimaryKey(Integer cmid);

    int insert(CMenu record);

    int insertSelective(CMenu record);

    CMenu selectByPrimaryKey(Integer cmid);

    int updateByPrimaryKeySelective(CMenu record);

    int updateByPrimaryKey(CMenu record);

    List<CMenu> selectByStatus(Integer cms);
}