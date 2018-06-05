package org.aousi.springboot.demo.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.aousi.springboot.demo.Entities.CCompleted;
import org.aousi.springboot.demo.Entities.CRecords;
import org.aousi.springboot.demo.mapper.CCompletedMapper;
import org.aousi.springboot.demo.mapper.CRecordsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CRService {

    @Autowired
    private CRecordsMapper recordsMapper;

    public Map<String,Object> getUserList(Integer page,Integer rows,String sort,
                                      String sortOrder,Integer uid){
        Page p = PageHelper.startPage(page,rows,""+sort+" "+sortOrder);
        List<CRecords> cc = recordsMapper.userCRList(uid);
        if (cc != null){
            Map<String,Object> back = new HashMap<>();
            back.put("totals",cc.size());
            back.put("rows",cc);
            return back;
        }else {
            return null;

        }
    }

}
