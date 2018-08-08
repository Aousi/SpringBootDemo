package org.aousi.springboot.demo.Service;

import org.aousi.springboot.demo.Entities.CCompleted;
import org.aousi.springboot.demo.mapper.CCompletedMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CCService {

    @Autowired
    private CCompletedMapper ccMapper;

    public CCompleted singleCC(Integer ccid){

        return ccMapper.selectByPrimaryKey(ccid);
    }

    public Boolean compareDate(Integer ccid){
        CCompleted cc = ccMapper.selectByPrimaryKey(ccid);

        cc.getInputTime();

        return false;
    }


}
