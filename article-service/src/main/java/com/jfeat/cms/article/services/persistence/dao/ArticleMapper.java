package com.jfeat.cms.article.services.persistence.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jfeat.cms.article.services.persistence.model.Article;
import com.jfeat.cms.article.services.domain.model.ArticleModel;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author admin
 * @since 2018-03-27
 */
public interface ArticleMapper extends BaseMapper<Article> {

    ArticleModel selectArticleModel(@Param("id") Long id);
}
