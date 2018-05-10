package org.aousi.springboot.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class demoController {

    @RequestMapping("/")
    public String login(){
        return "login";
    }

    @RequestMapping("/home")
    public String home(){
        return "home";
    }

    @RequestMapping("/articleList")
    public String ArticleList(){
        return "ArticleList";
    }

    @RequestMapping("/article")
    public String Article(){
        return "Article";
    }

    @RequestMapping("/newArticle")
    public String newArticle(){
        return "newArticle";
    }
}
