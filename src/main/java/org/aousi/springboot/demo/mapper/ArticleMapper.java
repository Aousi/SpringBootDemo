package org.aousi.springboot.demo.mapper;

import org.aousi.springboot.demo.Entities.Article;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ArticleMapper {
    int deleteByPrimaryKey(Integer aid);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Integer aid);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);

    List<Article> selectByTypeAndStatus(@Param("type") Integer type,@Param("status") Integer status);

    List<Article> selectUserArticle(@Param("name") String name);

    List<Article> selectByUserAndStatus(@Param("name") String name,@Param("status") Integer status);
}