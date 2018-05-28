package org.aousi.springboot.demo.Service;

import org.aousi.springboot.demo.mapper.UserMapper;
import org.aousi.springboot.demo.mapper.cOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class cOrderService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private cOrderMapper cOrderMapper;


}
