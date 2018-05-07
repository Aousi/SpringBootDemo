package org.aousi.springboot.demo.Service;

import org.aousi.springboot.demo.Entities.UserRole;
import org.aousi.springboot.demo.Entities.role;
import org.aousi.springboot.demo.Entities.user;
import org.aousi.springboot.demo.mapper.UserRoleMapper;
import org.aousi.springboot.demo.mapper.userMapper;
import org.apache.catalina.User;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
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

        if (result == result2 && result > 0){
            return true;
        }else {
            return false;
        }
    }

    public Map<String,Object> loginConfrim(Map<String,String> user){
        Map<String,Object> getBack = new HashMap<>();
        String username = user.get("username");
        String password = user.get("password");

        String pw_md5 = new SimpleHash("MD5",password,username,2).toHex();
        user u = this.queryUserByName(username);
        if (u == null){
            getBack.put("stateCode",404);
            getBack.put("msg","用户不存在");
        }else {
            if (u.getPassword().equals(pw_md5)){
                getBack.put("stateCode",200);
                getBack.put("msg","登陆成功");
            }else {
                getBack.put("stateCode",400);
                getBack.put("msg","密码错误");
            }
        }
        return getBack;
    }

    public user queryUserByName(String name){
        user u = userMapper.selectByUserName(name);

        return u;
    }
}
