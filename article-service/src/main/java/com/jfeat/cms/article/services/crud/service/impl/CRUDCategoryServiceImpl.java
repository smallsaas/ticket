package com.jfeat.cms.article.services.crud.service.impl;
            
import com.baomidou.mybatisplus.core.mapper.BaseMapper;


import com.jfeat.cms.article.services.persistence.dao.ArticleCategoryMapper;
import com.jfeat.cms.article.services.persistence.model.ArticleCategory;
import com.jfeat.cms.article.services.crud.service.CRUDCategoryService;
import com.jfeat.crud.plus.impl.CRUDServiceOnlyImpl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * <p>
 *  implementation
 * </p>
 *CRUDCategoryService
 * @author Code Generator
 * @since 2018-07-11
 */

@Service
public class CRUDCategoryServiceImpl  extends CRUDServiceOnlyImpl<ArticleCategory> implements CRUDCategoryService {





        @Resource
        private ArticleCategoryMapper articleCategoryMapper;

        @Override
        protected BaseMapper<ArticleCategory> getMasterMapper() {
                return articleCategoryMapper;
        }







}


