package org.aousi.springboot.demo.Service;

import org.aousi.springboot.demo.Entities.Role;
import org.aousi.springboot.demo.Entities.User;
import org.aousi.springboot.demo.Entities.UserRole;
import org.aousi.springboot.demo.mapper.UserRoleMapper;
import org.aousi.springboot.demo.mapper.userMapper;
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

    public Map<String,Object> signUp(User User, Set<Role> Roles){
        Map<String,Object> getBack = new HashMap<>();

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
        User u = this.queryUserByName(username);
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
}
