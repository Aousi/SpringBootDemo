package org.aousi.springboot.demo.Service;

import org.aousi.springboot.demo.Entities.CMenu;
import org.aousi.springboot.demo.mapper.CMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CMenuService {
    @Autowired
    private CMenuMapper cMenuMapper;

    public Map<String,Object> selectMenu(Integer status){
        List<CMenu> menus = cMenuMapper.selectByStatus(status);
        return menuPackage(menus);
    }

    private Map<String,Object> menuPackage(List<CMenu> menus){

        return responseData(menus, menus != null);
    }

    static Map<String, Object> responseData(List<CMenu> menus, boolean b) {
        if (b){
            Map<String,Object> data = new HashMap<>();

            data.put("total",menus.size());
            data.put("rows",menus);

            return data;
        }else {
            return null;
        }
    }


}
