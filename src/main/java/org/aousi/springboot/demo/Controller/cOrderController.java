package org.aousi.springboot.demo.Controller;

import org.aousi.springboot.demo.Service.cOrderService;
import org.aousi.springboot.demo.Service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/canteen")
public class cOrderController {

    @Autowired
    private cOrderService cOrderService;
    @Autowired
    private userService userService;

    @RequestMapping("/orderPage")
    @ResponseBody
    public ModelAndView orderPage(@RequestParam("uid") Integer uid){


        return new ModelAndView();
    }
}
