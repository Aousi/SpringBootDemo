package org.aousi.springboot.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class demoController {

    @RequestMapping("/")
    public String login(){
        return "login";
    }

    @RequestMapping("/home")
    public ModelAndView home(){
        return new ModelAndView("home");
    }

    @RequestMapping("/articleList")
    public String ArticleList(){
        return "ArticleList";
    }

    @RequestMapping("/article")
    public ModelAndView Article(){
        return new ModelAndView("Article");
    }

    @RequestMapping("/newArticle")
    public String newArticle(){
        return "newArticle";
    }
}
