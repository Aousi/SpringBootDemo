package org.aousi.springboot.demo.Controller;

import org.aousi.springboot.demo.Service.CMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/menu")
public class CMenuController {

    @Autowired
    private CMenuService menuService;

    @RequestMapping( value = "/status",method = RequestMethod.GET)
    @ResponseBody
    private Map<String,Object> getMenu(@RequestParam(value = "menuFlag")Integer status){


        return menuService.selectMenu(status);
    }
}
