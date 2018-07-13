package org.aousi.springboot.demo.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.aousi.springboot.demo.Entities.CCompleted;
import org.aousi.springboot.demo.Entities.CRecords;
import org.aousi.springboot.demo.Entities.toolssss;
import org.aousi.springboot.demo.mapper.CCompletedMapper;
import org.aousi.springboot.demo.mapper.CRecordsMapper;
import org.aousi.springboot.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CRService {

    @Autowired
    private CRecordsMapper recordsMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private toolssss util;

    public Map<String,Object> getUserList(Integer page,Integer rows,String sort,
                                      String sortOrder,Integer uid){
        Page p = PageHelper.startPage(page,rows,""+sort+" "+sortOrder);
        List<CRecords> cc = recordsMapper.userCRList(uid);
        return recordDataPackage(cc);
    }

    public Map<String,Object> B_CanteenRecord(Integer page,Integer rows,String sort,
                                          String sortOrder){
        List<CRecords> cc = null;
        if (page == null || rows == null){
            cc = recordsMapper.B_CanteenRecord();
        }else {
            Page p = PageHelper.startPage(page,rows,""+sort+" "+sortOrder);
            cc = recordsMapper.B_CanteenRecord();
        }

        return recordDataPackage(cc);
    }

    public Map<String,Object> B_userCanteenRecord(Integer page,Integer rows,String sort,
                                              String sortOrder,String username){
        Integer uid = userMapper.selectByUserName(username).getUid();

        Page p = PageHelper.startPage(page,rows,""+sort+" "+sortOrder);
        List<CRecords> cc = recordsMapper.B_userCanteenRecord(uid);
        return recordDataPackage(cc);
    }

    public Map<String,Object> B_dateCanteenRecord(Integer page,Integer rows,String sort,
                                                  String sortOrder,String dateStr){
        Date date = util.Str2Date("yyyy-MM-dd",dateStr);

        Page p = PageHelper.startPage(page,rows,""+sort+" "+sortOrder);
        List<CRecords> cc = recordsMapper.B_dateCanteenRecord(date);
        return recordDataPackage(cc);
    }

    public Map<String,Object> B_userDateCanteenRecord(Integer page,Integer rows,String sort,
                                                  String sortOrder,String username,String dateStr){
        Integer uid = userMapper.selectByUserName(username).getUid();
        Date date = util.Str2Date("yyyy-MM-dd",dateStr);

        Page p = PageHelper.startPage(page,rows,""+sort+" "+sortOrder);
        List<CRecords> cc = recordsMapper.B_userDateCanteenRecord(date,uid);
        return recordDataPackage(cc);
    }

    private Map<String, Object> recordDataPackage(List<CRecords> cc) {
        if (cc != null){
            Map<String,Object> back = new HashMap<>();
            back.put("total",cc.size());
            back.put("rows",cc);
            return back;
        }else {
            return null;
        }
    }

}
