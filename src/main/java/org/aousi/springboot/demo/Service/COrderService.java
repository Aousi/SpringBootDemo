package org.aousi.springboot.demo.Service;

import org.aousi.springboot.demo.Entities.COrder;
import org.aousi.springboot.demo.mapper.COrderMapper;
import org.aousi.springboot.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class COrderService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private COrderMapper COrderMapper;

    public Map<String,Object> insetOrder(List<COrder> cOrder){
        Map<String,Object> back = new HashMap<>();
        int result = COrderMapper.ListInsert(cOrder);
        int len = cOrder.size();

        if (result == len){
            back.put("statusCode",200);
            back.put("msg","成功提交了"+result+"条订餐信息，详情请在订餐记录中查看。");
        }else {
            back.put("statusCode",400);
            back.put("msg","有"+(len - result)+"条订餐信息提交失败！成功的订餐详情请在订餐记录中查看。");
        }

        return back;
    }

    public Integer orderIsExistByDate(Date oTime){
        return COrderMapper.orderIsExistByDate(oTime);
    }


}
