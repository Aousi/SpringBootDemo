package org.aousi.springboot.demo.Controller;

import org.aousi.springboot.demo.Entities.User;
import org.aousi.springboot.demo.Entities.Role;
import org.aousi.springboot.demo.Service.userService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
                getBack.put("toUrl","/home");
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
}
