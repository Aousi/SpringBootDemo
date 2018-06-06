package org.aousi.springboot.demo.Controller;

import org.aousi.springboot.demo.Entities.CRecords;
import org.aousi.springboot.demo.Entities.User;
import org.aousi.springboot.demo.Service.COrderService;
import org.aousi.springboot.demo.Service.CRService;
import org.aousi.springboot.demo.Service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/CR")
public class CRController {

    @Autowired
    private CRService crs;
    @Autowired
    private userService us;

    @ResponseBody
    @RequestMapping("/userCRPage")
    public ModelAndView userCRPage(@RequestParam("uid") Integer uid){

        return new ModelAndView("CRecordList",us.selectBasicInfo(uid));
    }

    @ResponseBody
    @RequestMapping("/getUserCR.do")
    public Map<String,Object> getUserCR(@RequestParam("page") Integer page, @RequestParam("rows")Integer rows, @RequestParam(value = "sort",required = false)String sort,
                                         @RequestParam("sortOrder")String sortOrder, @RequestParam("uid")Integer uid){


        return crs.getUserList(page, rows, sort, sortOrder, uid);
    }


}
