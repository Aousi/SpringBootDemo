package org.aousi.springboot.demo.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.aousi.springboot.demo.Entities.Role;
import org.aousi.springboot.demo.Entities.User;
import org.aousi.springboot.demo.Entities.UserRole;
import org.aousi.springboot.demo.mapper.RoleMapper;
import org.aousi.springboot.demo.mapper.UserMapper;
import org.aousi.springboot.demo.mapper.UserRoleMapper;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Service("userService")
public class userService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private RoleMapper roleMapper;

    public Map<String,Object> signUp(User User, Set<Role> Roles){
        Map<String,Object> getBack = new HashMap<>();

        Date d = new Date();
        User.setRegisterTime(d);

        if (userMapper.userIsExist(User.getUsername()) > 0){
            getBack.put("stateCode",400);
            getBack.put("msg","该用户名已被使用！");
        }else {
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
                getBack.put("uid",u.getUid());

            }else {
                getBack.put("stateCode",400);
                getBack.put("msg","密码错误");
            }
        }
        return getBack;
    }

    public User identifyUser(String username){
        Map<String,Object> getBack = new HashMap<>();
        User u = userMapper.identifyUser(username);
        return u;
    }

    public Map<String,Object> findAllUsers(Integer page,Integer rows,String sort,String sortOrder){
        Map<String,Object> getBack = new HashMap<>();
        Page p = PageHelper.startPage(page,rows,""+sort+" "+sortOrder);
        List<User> u = userMapper.identifyUsers();
        getBack.put("total",u.size());
        getBack.put("rows",u);

        return getBack;


    }

    public Map<String,Object> findRegisterUsers(Integer page,Integer rows,String sort,String sortOrder){
        Map<String,Object> getBack = new HashMap<>();
        Page p = PageHelper.startPage(page,rows,""+sort+" "+sortOrder);
        List<User> u = userMapper.selectRegisterUser();
        getBack.put("total",u.size());
        getBack.put("rows",u);

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

    public Map<String,Object> updataUser(User user){
        Map<String,Object> getBack = new HashMap<>();
        int result = userMapper.updateByPrimaryKeySelective(user);
        if (result > 0){
            getBack.put("statusCode",200);
            getBack.put("msg","资料保存成功");
            getBack.put("toUrl","/user/getPerson.do?name="+user.getUsername());
        }else {
            getBack.put("statusCode",400);
            getBack.put("msg","资料保存失败");
            getBack.put("toUrl","/user/editPerson.do?name="+user.getUsername());
        }

        return getBack;
    }

    public Map<String,Object> updataPassword(User user,String oldPw,String newPw){
        Map<String,Object> getBack = new HashMap<>();
        User u =userMapper.loginSelect(user.getUsername());
        String oldpw_md5 = new SimpleHash("MD5",oldPw,user.getUsername(),2).toHex();
        if (u.getPassword().equals(oldpw_md5)){
            String neopw_md5 = new SimpleHash("MD5",newPw,user.getUsername(),2).toHex();
            user.setPassword(neopw_md5);
            int result = userMapper.updateByPrimaryKeySelective(user);
            if (result > 0){
                getBack.put("statusCode",200);
                getBack.put("msg","密码修改成功");
                return getBack;
            }else {
                getBack.put("statusCode",400);
                getBack.put("msg","密码修改失败");
                return getBack;
            }
        }else {
            getBack.put("statusCode",400);
            getBack.put("msg","原始密码错误，请重新输入");
            return getBack;
        }
    }

    public Map<String,Object> selectBasicInfo(Integer uid){
        Map<String,Object> getBack = new HashMap<>();
        User u = userMapper.selectUid_Name(uid);
        if (u != null){
            getBack.put("statusCode",200);
            getBack.put("user",u);

        }else {
            getBack.put("statusCode",400);
            getBack.put("user",null);
        }
        return getBack;
    }

    public Map<String,Object> changeRole(Map<String,String> prams){
        Map<String,Object> getBack = new HashMap<>();

        Integer uid = Integer.parseInt(prams.get("uid"));
        String rolename = prams.get("role");
        Integer rid = roleMapper.selectByRolename(rolename).getRid();
        if (userRoleMapper.changeRole(uid,rid)>0){
            getBack.put("statusCode",200);
            getBack.put("msg","用户组修改成功");
        }else {
            getBack.put("statusCode",400);
            getBack.put("msg","用户组修改失败");
        }
        return getBack;
    }

    public  Map<String,Object> passRegister(Integer uid){
        Map<String,Object> getBack = new HashMap<>();

        if (userRoleMapper.changeRole(uid,2)>0){
            getBack.put("statusCode",200);
            getBack.put("msg","用户组修改成功");
        }else {
            getBack.put("statusCode",400);
            getBack.put("msg","用户组修改失败");
        }

        return getBack;
    }
}
