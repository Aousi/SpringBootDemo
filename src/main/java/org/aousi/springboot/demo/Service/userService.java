package org.aousi.springboot.demo.Service;

import org.aousi.springboot.demo.Entities.user;
import org.aousi.springboot.demo.mapper.userMapper;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class userService {

    @Autowired
    private userMapper userMapper;

    public boolean signUp(user user){
        int result = userMapper.insertSelective(user);
        return (result > 0 ? true:false);
    }
}
