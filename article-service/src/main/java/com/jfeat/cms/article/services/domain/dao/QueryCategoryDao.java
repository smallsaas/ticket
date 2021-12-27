package com.jfeat.cms.article.services.domain.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.cms.article.services.domain.model.record.CategoryRecord;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * Created by Code Generator on 2018-07-11
 */
public interface QueryCategoryDao extends BaseMapper<CategoryRecord> {
    List<CategoryRecord> findCategoryPage(Page<CategoryRecord> page, @Param("record") CategoryRecord record, @Param("orderBy") String orderBy);
}