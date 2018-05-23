package org.aousi.springboot.demo.mapper;

import org.aousi.springboot.demo.Entities.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer did);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer did);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    List<Department> selectAll();
}