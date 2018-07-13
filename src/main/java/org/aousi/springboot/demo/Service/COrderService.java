package org.aousi.springboot.demo.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.aousi.springboot.demo.Entities.COrder;
import org.aousi.springboot.demo.Entities.toolssss;
import org.aousi.springboot.demo.mapper.COrderMapper;
import org.aousi.springboot.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sun.rmi.runtime.Log;

import java.util.*;

@Service
public class COrderService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private COrderMapper COrderMapper;
    @Autowired
    private toolssss util;

    public Map<String,Object> insetOrder(List<COrder> cOrder){
        Map<String,Object> back = new HashMap<>();
        int len = cOrder.size();
        if (len == 0){
            back.put("statusCode",400);
            back.put("msg","无记录传入，原因：所选日期范围内都已存在订餐记录。请在订餐记录中修改。");
        }else {
            int result = COrderMapper.ListInsert(cOrder);

            if (result == len){
                back.put("statusCode",200);
                back.put("msg","成功提交了"+result+"条订餐信息，详情请在订餐记录中查看。");
            }else {
                back.put("statusCode",400);
                back.put("msg","有"+(len - result)+"条订餐信息提交失败！成功的订餐详情请在订餐记录中查看。");
            }
        }

        return back;
    }

    public Integer orderIsExistByDate(Date oTime){
        return COrderMapper.orderIsExistByDate(oTime);
    }

    public Map<String,Object> userOrders(Integer page,Integer rows,String sort,
                                   String sortOrder, Integer uid){
        Page p = PageHelper.startPage(page,rows,""+sort+" "+sortOrder);
        List<COrder> orders = COrderMapper.selectByUid(uid);

        Map<String,Object> back= new HashMap<>();
        back.put("total",orders.size());
        back.put("rows",orders);

        return back;
    }

    public Map<String,Object> B_namelist(Integer type, Date generateDate){
        List<COrder> orders = null;
        switch (type){
            case 1:orders = COrderMapper.B_selectByBreakfastDate(generateDate);break;

            case 2:orders = COrderMapper.B_selectByLunchDate(generateDate);break;

            case 3:orders = COrderMapper.B_selectByDinnerDate(generateDate);break;

            default:break;
        }
        Map<String,Object> back= new HashMap<>();
        if (orders == null){
            back.put("statusCode",404);
            return back;
        }else {
            back.put("total",orders.size());
            back.put("rows",orders);
        }
        return back;
    }

    public Map<String,Object> B_Orders(Integer page,Integer rows,String sort,
                                         String sortOrder){
        List<COrder> orders =null;

        if (page == null || rows == null){
            orders = COrderMapper.B_selectAll();
        }else {
            Page p = PageHelper.startPage(page,rows,""+sort+" "+sortOrder);
            orders = COrderMapper.B_selectAll();
        }

        Map<String,Object> back= new HashMap<>();
        back.put("total",orders.size());
        back.put("rows",orders);

        return back;
    }

    public Map<String,Object> B_userOrders(Integer page,Integer rows,String sort,
                                       String sortOrder,  String username){

        Integer uid = userMapper.selectByUserName(username).getUid();

        Page p = PageHelper.startPage(page,rows,""+sort+" "+sortOrder);
        List<COrder> orders = COrderMapper.B_selectByUid(uid);

        Map<String,Object> back= new HashMap<>();
        back.put("total",orders.size());
        back.put("rows",orders);

        return back;
    }

    public Map<String,Object> B_dateOrders(Integer page,Integer rows,String sort,
                                       String sortOrder, String date){

        Date d = util.Str2Date("yyyy-MM-dd",date);

        Page p = PageHelper.startPage(page,rows,""+sort+" "+sortOrder);
        List<COrder> orders = COrderMapper.B_selectByDate(d);

        Map<String,Object> back= new HashMap<>();
        back.put("total",orders.size());
        back.put("rows",orders);

        return back;
    }

    public Map<String,Object> B_userDateOrders(Integer page,Integer rows,String sort,
                                           String sortOrder,  String username, String date){

        Integer uid = userMapper.selectByUserName(username).getUid();
        Date d = util.Str2Date("yyyy-MM-dd",date);

        Page p = PageHelper.startPage(page,rows,""+sort+" "+sortOrder);
        List<COrder> orders = COrderMapper.B_selectByDateUid(d,uid);

        Map<String,Object> back= new HashMap<>();
        back.put("total",orders.size());
        back.put("rows",orders);

        return back;
    }



    public Map<String,Object> deleteOrder(List<COrder> list){
        Map<String,Object> back= new HashMap<>();
        int result = 0;
        List<Integer> fail = new ArrayList<>();
        if (list.size()>0){
            for (COrder c:list){
                int coid=c.getCoid();
                int i =COrderMapper.deleteByPrimaryKey(coid);
                if (i == 0){
                    fail.add(coid);
                }else {
                    result +=i;
                }
            }
            back.put("statusCode",200);
            back.put("msg","成功删除了"+result+"条订餐信息。");
            back.put("fail",fail);

        }else {
            back.put("statusCode",400);
            back.put("msg","请先勾选需要删除的记录");
        }
        return back;
    }

    public Map<String,Object> editOrder(COrder order){
        Map<String,Object> back= new HashMap<>();
        int result = 0;
        if (order != null){
            result = COrderMapper.updateByPrimaryKeySelective(order);
            if (result>0){
                back.put("statusCode",200);
                back.put("msg","成功修改了订单编号为"+order.getCoid()+"的订餐信息。");
            }else {
                back.put("statusCode",400);
                back.put("msg","订餐信息修改失败。");
            }
        }else {
            back.put("statusCode",404);
            back.put("msg","传入的数据为空，修改失败。");
        }

        return back;
    }


}
