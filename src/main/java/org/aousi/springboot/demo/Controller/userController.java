package org.aousi.springboot.demo.Controller;

import org.aousi.springboot.demo.Entities.User;
import org.aousi.springboot.demo.Entities.Role;
import org.aousi.springboot.demo.Service.userService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionContext;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.web.servlet.ShiroFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Controller("userController")
@RequestMapping("/user")
public class userController {

    @Autowired
    private userService userService;

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> signUp(@RequestParam Map<String,String> user){
        Map<String,Object> getBack = new HashMap<>();
        ModelAndView mav = new ModelAndView();

        String username = user.get("username");
        String password = user.get("password");
        String email = user.get("email");

        String pw_md5 = new SimpleHash("MD5",password,username,2).toHex();
        Role Role =new Role();
        Role.setRid(3);
        Set<Role> Roles = new HashSet<>();
        Roles.add(Role);
        User saveUser = new User(username,pw_md5,email, Roles);

        if (username.equals("") || password.equals("")){
            getBack.put("stateCode",400);
            getBack.put("msg","用户名和密码不能为空");
        }else {
            getBack = userService.signUp(saveUser, Roles);
        }

        return getBack;
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> login(@RequestParam Map<String,String> user, HttpSession httpSession){
        Map<String,Object> getBack = new HashMap<>();

        String username = user.get("username");
        String password = user.get("password");
        Boolean rememberMe = false;
        if(Integer.parseInt(user.get("rememberMe")) == 1){
            rememberMe = true;
        }else {
            rememberMe = false;
        }

        if (username.equals("") || password.equals("")){
            getBack.put("stateCode",400);
            getBack.put("msg","用户名和密码不能为空");
        }else {
//            getBack = userService.loginConfrim(user);
            UsernamePasswordToken token = new UsernamePasswordToken(username,password,rememberMe);
            Subject subject = SecurityUtils.getSubject();
            Session session =subject.getSession();

            try {
                subject.login(token);
                Integer uid = userService.queryUserByName(username).getUid();
                getBack.put("stateCode",200);
                getBack.put("msg","登陆成功");
                getBack.put("uid",uid);
                getBack.put("name",username);
                session.setAttribute("uid",uid);
                session.setAttribute("name",username);
                String lastIp = session.getHost();
                System.out.println(lastIp);
                getBack.put("toUrl","/");
            }catch (UnknownAccountException e){
                getBack.put("stateCode",404);
                getBack.put("msg","用户不存在");
                return getBack;
            }catch (IncorrectCredentialsException e){
                getBack.put("stateCode",400);
                getBack.put("msg","密码错误");
                return getBack;
            }
        }
        return getBack;
    }

    @RequestMapping("/getPerson.do")
    @ResponseBody
    public ModelAndView getPerson(@RequestParam("name") String name){

        return new ModelAndView("personalPage",userService.queryUserByUName(name));
    }



    @RequestMapping("/editPerson.do")
    @ResponseBody
    public ModelAndView editPerson(@RequestParam("name") String name){

        return new ModelAndView("editPersonal",userService.queryUserByUName(name));
    }

    @RequestMapping("/updatePerson.do")
    @ResponseBody
    public Map<String,Object> editPerson(@RequestBody Map<String,String> user){
//        Map<String,String> user = new HashMap<>();
        Integer uid =Integer.parseInt(user.get("uid"));
        String name =user.get("name");
        String nickname =user.get("nickname");
        String area =user.get("area");
        String department =user.get("department");
        String position =user.get("position");
        String tel =user.get("tel");
        String phone =user.get("phone");
        String email =user.get("email");

        User u =new User(uid,name,nickname,position,area,department,tel,phone,email);

        return userService.updataUser(u);
    }

    @RequestMapping("/editPassword.do")
    @ResponseBody
    public ModelAndView editPassword(@RequestParam("name") String name){

        return new ModelAndView("editPassword",userService.queryUserByUName(name));
    }

    @RequestMapping("/updatePassword.do")
    @ResponseBody
    public Map<String,Object> editPassword(@RequestBody Map<String,String> user){

        Integer uid = Integer.parseInt(user.get("uid"));
        String name = user.get("name");
        String oldPw = user.get("oldPw");
        String neoPw = user.get("neoPw");

        User u = new User(uid,name);

        return userService.updataPassword(u,oldPw,neoPw);
    }
    @RequestMapping("/logout.do")
    @ResponseBody
    public ModelAndView logout(){
        Map<String,Object> getBack = new HashMap<>();
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        getBack.put("msg","成功退出......");
        getBack.put("toUrl","/");

        return new ModelAndView("transition",getBack);
    }
    @RequestMapping("/getAllUser.do")
    @ResponseBody
    public Map<String,Object> allUserData(Integer page,Integer rows,String sort,String sortOrder){

        return userService.findAllUsers(page, rows, sort, sortOrder);
    }

    @RequestMapping("/getRegisterUser.do")
    @ResponseBody
    public Map<String,Object> registerUserData(Integer page,Integer rows,String sort,String sortOrder){

        return userService.findRegisterUsers(page, rows, sort, sortOrder);
    }

    @RequestMapping("/changeRole.do")
    @ResponseBody
    public Map<String,Object> changeUserGroup(@RequestBody Map<String,String> prams){

        return userService.changeRole(prams);
    }
    @RequestMapping("/passRegister.do")
    @ResponseBody
    public  Map<String,Object> passRegister(@RequestParam Integer uid){

        return userService.passRegister(uid);
    }

}
