package org.aousi.springboot.demo;

import org.aousi.springboot.demo.Entities.User;
import org.aousi.springboot.demo.Service.userService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class demoController {

    @Autowired
    private userService userService;

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/")
    public ModelAndView home(){
        return new ModelAndView("home");
    }

    @RequestMapping("/home")
    public ModelAndView home2(){
        return new ModelAndView("home");
    }

    @RequestMapping("/articleList")
    public ModelAndView ArticleList(){
        return new ModelAndView("ArticleList");
    }

    @RequestMapping("/article")
    public ModelAndView Article(){
        return new ModelAndView("Article");
    }

    @RequestMapping("/newArticle")
    public String newArticle(){
        return "newArticle";
    }

    @RequestMapping("/myArticle")
    public String myArticle(){
        return "myArticle";
    }

    @RequestMapping("/recycledArticle")
    public String recycleArticle(){
        return "recycleArticle";
    }

    @RequestMapping("/kicked")
    public ModelAndView kickout(){
        Map<String,Object> back = new HashMap<>();
        back.put("msg","此账号已在另一个地方登陆！");
        back.put("toUrl","/");
        return new ModelAndView("transition",back);
    }
    @RequestMapping("/intoConsole")
    @ResponseBody
    @RequiresRoles("admin")
    public ModelAndView enterConsole(@RequestParam(name = "name",required = false) String name){
        Map<String,Object> back = new HashMap<>();
        back.put("toUrl","/Console?name="+name);
        return new ModelAndView("transition",back);
    }

    @RequestMapping("/Console")
    @ResponseBody
    @RequiresRoles("admin")
    public ModelAndView Console(@RequestParam(name = "name",required = false) String name){
        Map<String,Object> back = new HashMap<>();
        User u = userService.queryUserByName(name);
        back.put("user",u);
        return new ModelAndView("sysBackend",back);
    }

    @RequestMapping("/sysBackend-persons")
    @ResponseBody
    @RequiresRoles("admin")
    public ModelAndView personCtrl(@RequestParam(name = "name",required = false) String name){
        Map<String,Object> back = new HashMap<>();
        User u = userService.queryUserByName(name);
        back.put("user",u);
        return new ModelAndView("sysBackend-persons",back);
    }

}
