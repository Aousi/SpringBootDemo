package org.aousi.springboot.demo.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import jdk.nashorn.internal.parser.JSONParser;
import org.aousi.springboot.demo.Entities.*;
import org.aousi.springboot.demo.Service.COrderService;
import org.aousi.springboot.demo.Service.CRService;
import org.aousi.springboot.demo.Service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/CR")
public class CRController {

    @Autowired
    private CRService crs;
    @Autowired
    private userService us;
    @Autowired
    private toolssss util;

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

    @ResponseBody
    @RequestMapping("/B_CanteenRecord.do")
    public Map<String,Object> B_CanteenRecord(@RequestParam(value = "page",required = false) Integer page, @RequestParam(value = "rows",required = false)Integer rows,
                                              @RequestParam(value = "sort",required = false)String sort, @RequestParam("sortOrder")String sortOrder,
                                              @RequestParam(value = "date",required = false) String date, @RequestParam(value = "personName",required = false) String personName){

        if (date == "" && personName == ""){
            return crs.B_CanteenRecord(page, rows, sort, sortOrder);
        }else if (date != "" && personName == ""){
            return crs.B_dateCanteenRecord(page, rows, sort, sortOrder, date);
        }else if (date == "" && personName != ""){
            return crs.B_userCanteenRecord(page,rows,sort,sortOrder,personName);
        }else {
            return crs.B_userDateCanteenRecord(page, rows, sort, sortOrder, personName,date);
        }

    }

    @ResponseBody
    @RequestMapping("/defaultEdit")
    public Map<String,Object> defaultComplete(@RequestBody List<CRecords> list){

        return crs.defaultEdit(list);
    }

    @ResponseBody
    @RequestMapping("/saveEdit")
    public Map<String,Object> saveComplete(@RequestParam(value = "list") String strJson){

        Date now = new Date();

        JSONObject jsonObject = JSONObject.parseObject(strJson);
        Date orderDate = jsonObject.getObject("co", COrder.class).getoTime();
        Integer ccid = jsonObject.getInteger("ccid");

        if (orderDate.after(util.setLimitTime(now,0,0,-7))){
            Integer breakfast = null;
            Integer lunch = null;
            Integer dinner = null;
//        List<CRecords> list = JSON.parseArray(strJson,CRecords.class);
            if (jsonObject.getInteger("cc.breakfast") != null){
                breakfast = jsonObject.getInteger("cc.breakfast");
            }
            if (jsonObject.getInteger("cc.lunch") != null){
                lunch = jsonObject.getInteger("cc.lunch");
            }
            if (jsonObject.getInteger("cc.dinner") != null){
                dinner = jsonObject.getInteger("cc.dinner");
            }

            CCompleted cc = new CCompleted();
            cc.setCcid(ccid);
            cc.setBreakfast(breakfast);
            cc.setLunch(lunch);
            cc.setDinner(dinner);

            return crs.singalEdit(cc);
        }else {
            Map<String,Object> result = new HashMap<>();
            result.put("msg","超过可录入时间，无法修改！");
            result.put("statusCode",500);
            return result;
        }


    }


}
