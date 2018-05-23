package org.aousi.springboot.demo.Service;

import org.aousi.springboot.demo.Entities.Role;
import org.aousi.springboot.demo.Entities.User;
import org.aousi.springboot.demo.Entities.UserRole;
import org.aousi.springboot.demo.mapper.UserMapper;
import org.aousi.springboot.demo.mapper.UserRoleMapper;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("userService")
public class userService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    public Map<String,Object> signUp(User User, Set<Role> Roles){
        Map<String,Object> getBack = new HashMap<>();

        Date d = new Date();
        User.setRegisterTime(d);

        int result = userMapper.insertSelective(User);
        int result2 = 0;
        if (result > 0 ){
            int id = User.getUid();
            Iterator it = Roles.iterator();

            if (it.hasNext()){
                UserRole ur =new UserRole(id);
                Role r = (Role) it.next();
                ur.setRid(r.getRid());
                result2 = userRoleMapper.insert(ur);
            }
        }

        if (result2 > 0){
            getBack.put("stateCode",200);
            getBack.put("msg","注册成功");
        }else {
            if(result > 0){
                getBack.put("stateCode",400);
                getBack.put("msg","用户角色设定失败");
            }else {
                getBack.put("stateCode",400);
                getBack.put("msg","注册失败");
            }
        }
        return getBack;
    }

    public Map<String,Object> loginConfrim(Map<String,String> user){
        Map<String,Object> getBack = new HashMap<>();
        String username = user.get("username");
        String password = user.get("password");

        String pw_md5 = new SimpleHash("MD5",password,username,2).toHex();
        User u = userMapper.loginSelect(username);
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

    public User queryUserByName(String name){
        User u = userMapper.selectByUserName(name);
        return u;
    }

    public Map<String,Object> queryUserByUName(String name){
        Map<String,Object> getBack = new HashMap<>();
        User u = userMapper.selectByUserName(name);
        if (u != null){
            getBack.put("statusCode",200);
            getBack.put("user",u);
        }else {
            getBack.put("statusCode",400);
            getBack.put("user",null);
        }
        return getBack;
    }
}
