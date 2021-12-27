package com.jfeat.cms.article.services.domain.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.cms.article.services.domain.model.record.ImageRecord;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * Created by Code Generator on 2018-07-11
 */
public interface QueryImageDao extends BaseMapper<ImageRecord> {
    List<ImageRecord> findImagePage(Page<ImageRecord> page, @Param("record") ImageRecord record, @Param("orderBy") String orderBy);
}