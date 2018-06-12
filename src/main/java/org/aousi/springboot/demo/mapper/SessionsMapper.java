package org.aousi.springboot.demo.mapper;

import org.aousi.springboot.demo.Entities.Sessions;
import org.springframework.stereotype.Component;

@Component
public interface SessionsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Sessions record);

    int insertSelective(Sessions record);

    Sessions selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Sessions record);

    int updateByPrimaryKeyWithBLOBs(Sessions record);
}