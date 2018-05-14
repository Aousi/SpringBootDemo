package org.aousi.springboot.demo.mapper;

import org.aousi.springboot.demo.Entities.Article;
import org.springframework.stereotype.Component;

@Component
public interface ArticleMapper {
    int deleteByPrimaryKey(Integer aid);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Integer aid);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);
}