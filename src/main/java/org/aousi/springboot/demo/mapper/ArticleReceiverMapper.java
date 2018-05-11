package org.aousi.springboot.demo.mapper;

import org.aousi.springboot.demo.Entities.ArticleReceiver;

public interface ArticleReceiverMapper {
    int insert(ArticleReceiver record);

    int insertSelective(ArticleReceiver record);
}