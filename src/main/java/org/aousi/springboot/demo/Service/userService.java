package org.aousi.springboot.demo.Service;

import org.aousi.springboot.demo.Entities.UserRole;
import org.aousi.springboot.demo.Entities.role;
import org.aousi.springboot.demo.Entities.user;
import org.aousi.springboot.demo.mapper.UserRoleMapper;
import org.aousi.springboot.demo.mapper.userMapper;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Set;

@Service("userService")
public class userService {

    @Autowired
    private userMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    public boolean signUp(user user, Set<role> roles){
        int result = userMapper.insertSelective(user);
        int id = user.getUid();
        Iterator it = roles.iterator();
        int result2 =0;
        if (it.hasNext()){
            UserRole ur =new UserRole(id);
            role r = (role) it.next();
            ur.setRid(r.getRid());
            result2 = userRoleMapper.insert(ur);
        }

        if (result == result2|| result > 0){
            return true;
        }else {
            return false;
        }

    }
}
