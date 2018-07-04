package org.aousi.springboot.demo.Controller;

import org.aousi.springboot.demo.Entities.COrder;
import org.aousi.springboot.demo.Entities.toolssss;
import org.aousi.springboot.demo.Service.COrderService;
import org.aousi.springboot.demo.Service.userService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
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

    @RequestMapping("/userOrders")
    @ResponseBody
    public ModelAndView userOrders(@RequestParam("uid") Integer uid){
        Map<String,Object> back = userService.selectBasicInfo(uid);

        return new ModelAndView("COrderList",back);
    }

    @RequestMapping(value = "/takeOrder.do",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> takeOrder(@RequestBody Map<String,String> oParams){

        String start = oParams.get("start");
        String end = oParams.get("end");

        Date StartDate = null;
        Date EndDate = null;

        Date inputTime = new Date();

        StartDate =toolssss.Str2Date("yyyy-MM-dd",start);
        int len = toolssss.between2day(start,end);
        List<COrder> cOrders = new ArrayList<>();
        List<String> dateList = new ArrayList<>();
        Calendar c = toolssss.ClearCalendarWithTime(StartDate);

        Date limit = toolssss.setLimitTime(inputTime,17);

        Subject subject = SecurityUtils.getSubject();

        if (subject.hasRole("user") || subject.hasRole("admin")){
            if (inputTime.compareTo(limit) <= 0){
                if (!start.equals(end)){
                    for (int i = 0;i<=len;i++){
                        COrder co = receiveOrder(oParams);
                        co.setoCrtTime(inputTime);
                        if (i == 0){
                            c.add(Calendar.DATE,+0);
                        }else {
                            c.add(Calendar.DATE,+1);
                        }
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
                    COrder co = receiveOrder(oParams);
                    co.setoCrtTime(inputTime);
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
            }else {
                Map<String,Object> back = new HashMap<>();
                back.put("statusCode",400);
                back.put("msg","17点以后无法订餐。");
                return back;
            }
        }else {
            Map<String,Object> back = new HashMap<>();
            back.put("statusCode",400);
            back.put("msg","当前角色的用户组无法提交订单，请联系管理员审核帐号。");
            return back;
        }

    }

    @RequestMapping("/getUserOrders.do")
    @ResponseBody
    public Map<String,Object> ordersData(@RequestParam("page") Integer page,@RequestParam("rows")Integer rows,@RequestParam(value = "sort",required = false)String sort,
                                   @RequestParam("sortOrder")String sortOrder,@RequestParam("uid")Integer uid){


        return COrderService.userOrders(page,rows,sort,sortOrder,uid);
    }

    @RequestMapping("/getBackendOrders.do")
    @ResponseBody
    public Map<String,Object> backendOrdersData(@RequestParam("page") Integer page,@RequestParam("rows")Integer rows,@RequestParam(value = "sort",required = false)String sort,
                                         @RequestParam("sortOrder")String sortOrder){


        return COrderService.B_Orders(page,rows,sort,sortOrder);
    }


    @RequestMapping("/deleteOrder.do")
    @ResponseBody
    public Map<String,Object> deleteOrder(@RequestBody List<COrder> list){

        return COrderService.deleteOrder(list);
    }

    @RequestMapping("/editOrder.do")
    @ResponseBody
    public Map<String,Object> editOrder(@RequestBody Map<String,String> oParams){

        Map<String,Object> back= new HashMap<>();
        COrder order = receiveOrder(oParams);
        String str = oParams.get("otime");
        str = str.replaceAll("Z","UTC");
        Date otime = toolssss.Str2Date("yyyy-MM-dd'T'HH:mm:ss.SSSZ",str) ;
        Date now = new Date();

        if (otime.compareTo(now)> 0){
            return COrderService.editOrder(order);
        }else {
            back.put("statusCode",400);
            back.put("msg","今天以及之前的订餐信息无法修改。");
            return back;
        }
    }


    private COrder receiveOrder(Map<String,String> oParams){

        Integer coid = null;
        if (oParams.get("coid") == null){

        }else {
            coid = Integer.parseInt(oParams.get("coid"));
        }

        Integer uid = null;
        if (oParams.get("uid") == null){

        }else {
            uid = Integer.parseInt(oParams.get("uid"));
        }

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

        return new COrder(coid,bf,bf_many,l,l_many,d,d_many,uid);
    }
}
