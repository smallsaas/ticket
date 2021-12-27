package com.jfeat.cms.article.services.crud.service.impl;
            
import com.baomidou.mybatisplus.core.mapper.BaseMapper;


import com.jfeat.cms.article.services.persistence.dao.ArticleTypeMapper;
import com.jfeat.cms.article.services.persistence.model.ArticleType;
import com.jfeat.cms.article.services.crud.service.CRUDTypeService;
import com.jfeat.crud.plus.impl.CRUDServiceOnlyImpl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * <p>
 *  implementation
 * </p>
 *CRUDTypeService
 * @author Code Generator
 * @since 2018-07-11
 */

@Service
public class CRUDTypeServiceImpl  extends CRUDServiceOnlyImpl<ArticleType> implements CRUDTypeService {





        @Resource
        private ArticleTypeMapper typeMapper;

        @Override
        protected BaseMapper<ArticleType> getMasterMapper() {
                return typeMapper;
        }







}


