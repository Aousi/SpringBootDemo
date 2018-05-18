package org.aousi.springboot.demo.Controller;

import javafx.scene.input.DataFormat;
import org.aousi.springboot.demo.Entities.Article;
import org.aousi.springboot.demo.Service.ArticleService;
import org.aousi.springboot.demo.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/Article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/submit.do")
    @ResponseBody
    public Map<String,Object> insertArticle(@RequestParam Map<String,String> article){
        Map<String,Object> back =new HashMap<>();
        String title = article.get("title");
        String author =article.get("author");
        String context = article.get("context");
        String code =article.get("code");
        Integer level =Integer.parseInt(article.get("level"));
        Integer type =Integer.parseInt(article.get("type"));
        Integer flag = Integer.parseInt(article.get("flag"));

        Article a = new Article(title,author,context,level,code,type);

        a.setPublishTime(new Date());

        if (flag == 1){
            a.setaStatus(2); // 2 == 提交审核
        }else {
            a.setaStatus(0); // 0 == 保存草稿
        }
        return articleService.insertArticle(a);
    }

    @RequestMapping("/ArticleListP.do")
    @ResponseBody
    public Map<String,Object> queryArticleListP(@RequestParam Map<String,String> parms){
        Map<String,Object> back =new HashMap<>();
        Integer page = !parms.get("page").equals("") ?Integer.parseInt(parms.get("page")):1 ;
        Integer rows = !parms.get("rows").equals("") ?Integer.parseInt(parms.get("rows")):10 ;

        return articleService.queryArticleP(1,2,page,rows);
    }

    @RequestMapping("/userArticle.do")
    @ResponseBody
    public Map<String,Object> queryUserArticleList(@RequestParam Map<String,String> parms){
        Map<String,Object> back =new HashMap<>();
        Integer page = !parms.get("page").equals("") ?Integer.parseInt(parms.get("page")):1 ;
        Integer rows = !parms.get("rows").equals("") ?Integer.parseInt(parms.get("rows")):10 ;
        String name = parms.get("user");

        return articleService.queryUserArticle(page,rows,name);
    }

    @RequestMapping("/showArticle.do")
    @ResponseBody
    public ModelAndView showArticle(@RequestParam("aid") Integer aid){
        Map<String,Object> back = articleService.queryArticleById(aid);
        return new ModelAndView("Article",back);
    }

    @RequestMapping("/editArticle.do")
    @ResponseBody
    public ModelAndView editArticle(@RequestParam("aid") Integer aid){
        Map<String,Object> back = articleService.queryArticleById(aid);
        return new ModelAndView("editArticle",back);
    }
    @RequestMapping("/edit.do")
    @ResponseBody
    public Map<String,Object> updataArticle(@RequestParam Map<String,String> article){
        Map<String,Object> back =new HashMap<>();
        Integer aid = Integer.parseInt(article.get("aid"));
        String title = article.get("title");
        String author =article.get("author");
        String context = article.get("context");
        String code =article.get("code");
        Integer level =Integer.parseInt(article.get("level"));
        Integer type =Integer.parseInt(article.get("type"));
        Integer flag = Integer.parseInt(article.get("flag"));

        Article a = new Article();
        a.setAid(aid);
        if(!title.equals("")){
            a.setTitle(title);
        }
        if (!context.equals("")){
            a.setContext(context);
        }
        if (!code.equals("")){
            a.setaCode(code);
        }
        if (level != 99){
            a.setaLevel(level);
        }
        if (type != 99){
            a.setaType(type);
        }

        if (flag == 1){
            a.setaStatus(2); // 2 == 提交审核
        }else {
            a.setaStatus(0); // 0 == 保存草稿
        }
        return articleService.updataArticle(a);
    }
}
