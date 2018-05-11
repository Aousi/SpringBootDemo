package org.aousi.springboot.demo.mapper;

import org.aousi.springboot.demo.Entities.ArticleRecords;

public interface ArticleRecordsMapper {
    int deleteByPrimaryKey(Integer arid);

    int insert(ArticleRecords record);

    int insertSelective(ArticleRecords record);

    ArticleRecords selectByPrimaryKey(Integer arid);

    int updateByPrimaryKeySelective(ArticleRecords record);

    int updateByPrimaryKey(ArticleRecords record);
}