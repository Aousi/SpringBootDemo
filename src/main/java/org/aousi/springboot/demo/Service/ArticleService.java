package org.aousi.springboot.demo.Service;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.aousi.springboot.demo.Entities.Article;
import org.aousi.springboot.demo.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ArticleService {

    @Autowired
    private ArticleMapper ArticleMapper;

    public Map<String,Object> insertArticle(Article article){
        Map<String,Object> back =new HashMap<>();
        Integer result = ArticleMapper.insertSelective(article);
        Integer aid =article.getAid();

        if(result > 0 ){
            back.put("stateCode",200);
            back.put("aid", aid);
            if(article.getaStatus() == 0){
                back.put("msg","文章草稿保存成功！");
            }else if (article.getaStatus() == 2){
                back.put("msg","文章已发布，等待管理员审核！文章编号："+aid+"。");
            }
        }else {
            back.put("stateCode",400);
            back.put("msg","发布或保存草稿失败！");
        }

        return  back;
    }

    public Map<String,Object> queryArticleP(Integer type,Integer status,Integer page,Integer rows){
        Map<String,Object> back =new HashMap<>();
        Page p = PageHelper.startPage(page,rows,"PUBLISH_TIME desc");
        List<Article> articles = ArticleMapper.selectByTypeAndStatus(type,status);

        if (articles.size() > 0 ){
            back.put("stateCode",200);
            long total =p.getTotal();
            back.put("totals",p.getTotal());
            back.put("pageSizes",p.getPageSize());
            back.put("nowPage",page);
            back.put("articles", articles);
            back.put("msg","查询成功");
        }else {
            back.put("stateCode",400);
            back.put("msg","查询失败。");
            back.put("articles",null);
        }


        return back;
    }
}
