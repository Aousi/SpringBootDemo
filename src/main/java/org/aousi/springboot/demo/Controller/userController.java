package org.aousi.springboot.demo.Controller;

import org.aousi.springboot.demo.Entities.User;
import org.aousi.springboot.demo.Entities.Role;
import org.aousi.springboot.demo.Service.userService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
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
        Role.setRid(2);
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

        if (username.equals("") || password.equals("")){
            getBack.put("stateCode",400);
            getBack.put("msg","用户名和密码不能为空");
        }else {
            getBack = userService.loginConfrim(user);
            if ((Integer) getBack.get("stateCode") == 200){
                getBack.put("toUrl","/");
                getBack.put("name",username);
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

        getBack.put("msg","成功退出......");
        getBack.put("toUrl","/");

        return new ModelAndView("transition",getBack);
    }

}
