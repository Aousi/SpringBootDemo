package org.aousi.springboot.demo.Controller;

import org.aousi.springboot.demo.Entities.COrder;
import org.aousi.springboot.demo.Entities.toolssss;
import org.aousi.springboot.demo.Service.COrderService;
import org.aousi.springboot.demo.Service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

@Controller
@RequestMapping("/canteen")
public class COrderController {

    @Autowired
    private COrderService COrderService;
    @Autowired
    private userService userService;
    @Autowired
    private toolssss toolssss;

    @RequestMapping("/orderPage")
    @ResponseBody
    public ModelAndView orderPage(@RequestParam("uid") Integer uid){
        Map<String,Object> back = userService.selectBasicInfo(uid);

        return new ModelAndView("canteenOrder",back);
    }

    @RequestMapping(value = "/takeOrder.do",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> takeOrder(@RequestBody Map<String,String> oParams){

        Integer uid = Integer.parseInt(oParams.get("uid"));
        String start = oParams.get("start");
        String end = oParams.get("end");

        Integer bf = null;
        if (oParams.get("breakfast") == null){
            bf = 0;
        }else {
            bf = Integer.parseInt(oParams.get("breakfast"));
        }
        Integer l = null;
        if (oParams.get("lunch") == null){
            l = 0;
        }else {
            l = Integer.parseInt(oParams.get("lunch"));
        }
        Integer d = null;
        if (oParams.get("dinner") == null){
            d = 0;
        }else {
            d = Integer.parseInt(oParams.get("dinner"));
        }
        Integer bf_many = Integer.parseInt(oParams.get("bfMany"));
        Integer l_many = Integer.parseInt(oParams.get("lMany"));
        Integer d_many = Integer.parseInt(oParams.get("dMany"));
        Date StartDate = null;
        Date EndDate = null;

        COrder co = new COrder(bf,bf_many,l,l_many,d,d_many,new Date(),uid);

        StartDate =toolssss.Str2Date("yyyy-MM-dd",start);
        int len = toolssss.between2day(start,end);
        List<COrder> cOrders = new ArrayList<>();
        List<String> dateList = new ArrayList<>();

        if (!start.equals(end)){
            Calendar c = toolssss.ClearCalendarWithTime(StartDate);

            for (int i = 0;i<=len;i++){
                c.set(Calendar.DATE,+i);
                co.setoTime(c.getTime());
                if (COrderService.orderIsExistByDate(c.getTime()) == 0){
                    cOrders.add(co);
                }else {
                    dateList.add(toolssss.Date2Str("yyyy-MM-dd",c.getTime()));
                }
            }
            Map<String,Object> back =COrderService.insetOrder(cOrders);
            back.put("failDate",dateList);
            return back;
        }else {
            co.setoTime(StartDate);
            if (COrderService.orderIsExistByDate(StartDate) == 0){
                cOrders.add(co);
            }else {
                dateList.add(toolssss.Date2Str("yyyy-MM-dd",StartDate));
            }
            Map<String,Object> back =COrderService.insetOrder(cOrders);
            back.put("failDate",dateList);
            return back;
        }
    }
}
