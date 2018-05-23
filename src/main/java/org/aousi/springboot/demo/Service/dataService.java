package org.aousi.springboot.demo.Service;

import org.aousi.springboot.demo.Entities.Area;
import org.aousi.springboot.demo.Entities.Department;
import org.aousi.springboot.demo.mapper.AreaMapper;
import org.aousi.springboot.demo.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class dataService {

    @Autowired
    private AreaMapper areaMapper;
    @Autowired
    private DepartmentMapper departmentMapper;

    public Map<String,Object> getArea(){
        Map<String,Object> back = new HashMap<>();
        List<Area> areas = areaMapper.selectAll();
        if (areas.size() > 0){
            back.put("areas",areas);
            back.put("statusCode",200);
        }else {
            back.put("areas",null);
            back.put("statusCode",400);
        }
        return back;
    }

    public Map<String,Object> getDepartment(){
        Map<String,Object> back = new HashMap<>();
        List<Department> departments = departmentMapper.selectAll();
        if (departments.size() > 0){
            back.put("departments",departments);
            back.put("statusCode",200);
        }else {
            back.put("areas",null);
            back.put("statusCode",400);
        }
        return back;
    }
}
