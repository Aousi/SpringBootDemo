package org.aousi.springboot.demo.Controller;

import org.aousi.springboot.demo.Service.dataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/data")
public class dataController {

    @Autowired
    private dataService dataService;

    @RequestMapping("/getArea.do")
    @ResponseBody
    public Map<String,Object> getArea(){
        Map<String,Object> back = new HashMap<>();

        return dataService.getArea();
    }

    @RequestMapping("/getDepartment.do")
    @ResponseBody
    public Map<String,Object> getDepartment(){
        Map<String,Object> back = new HashMap<>();

        return dataService.getDepartment();
    }
    @RequestMapping("/getRoles.do")
    @ResponseBody
    public Map<String,Object> getRoles(){

        return dataService.getRoles();
    }

}
