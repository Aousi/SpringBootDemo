package org.aousi.springboot.demo.mapper;

import org.aousi.springboot.demo.Entities.ArticleAuthor;

public interface ArticleAuthorMapper {
    int insert(ArticleAuthor record);

    int insertSelective(ArticleAuthor record);
}