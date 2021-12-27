package com.jfeat.cms.article.services.domain.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.cms.article.services.persistence.model.Article;
import com.jfeat.cms.article.services.crud.service.CRUDArticleService;
import com.jfeat.cms.article.services.domain.model.ArticleModel;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface CMSArticleService extends CRUDArticleService{


    @Transactional
    Article createArticle(ArticleModel model);

    @Transactional
    Integer updateArticle(Long articleId,ArticleModel model);


    Integer publishArticle(Long id);
    Integer forbiddenArticle(Long id);



    /**
     *
     *  文章 详情 包括 收藏数 以及 点赞数
     * */
    ArticleModel showArticle(Long id,Long userId);

    /**
     * 我发表的文章or others
     * */
    List<Article> myArticle(Page<Article> page, Long userId, String typeName);


    /**
     * xia jia wen zhang
     * */
    @Transactional
    Integer deprecatedArticle(Long id);

    /**
     *  chong xin fa bu wen zhang
     * */
    @Transactional
    Integer rePublishArticle(Long id);


    /**
     * 我发表的 Diary
     */
    List<ArticleModel> myDiaryRecords(Page<Article> page, Long userId);


    /**
     * 置顶文章
     * */
    public Integer stickyArticle(Long articleId);


    /**
     * 审核拒绝
     * */
    Integer auditRejectedArticle(Long articleId);

    //根据id返回article
    public ArticleModel selectArticleModel(Long articleId);

}