package org.aousi.springboot.demo.Controller;

import org.aousi.springboot.demo.Entities.role;
import org.aousi.springboot.demo.Service.userService;
import org.aousi.springboot.demo.mapper.userMapper;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.aousi.springboot.demo.Entities.user;
import org.aousi.springboot.demo.Entities.role;

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
    public Map<String,Object> signUp(@RequestParam Map<String,String> user, Model model){
        Map<String,Object> getBack = new HashMap<>();

        String username = user.get("username");
        String password = user.get("password");
        String email = user.get("email");

        String pw_md5 = new SimpleHash("MD5",password,username,2).toHex();
        role role =new role();
        role.setRid(2);
        Set<role> roles = new HashSet<>();
        roles.add(role);
        user saveUser = new user(username,pw_md5,email,roles);

        if (userService.signUp(saveUser,roles)){
            model.addAttribute("username",username);
            getBack.put("stateCode","200");
            getBack.put("msg","success");
        }else {
            getBack.put("stateCode","201");
            getBack.put("msg","fail");
        }



        return getBack;
    }

    public Map<String,Object> login(){
        Map<String,Object> getBack = new HashMap<>();

        return getBack;
    }
}
