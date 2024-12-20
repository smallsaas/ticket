package com.jfeat.module.smallsaas.ticket.services.domain.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.crud.plus.QueryMasterDao;
import com.jfeat.module.smallsaas.ticket.services.domain.model.ComplainReplyRecordRecord;
import com.jfeat.module.smallsaas.ticket.services.gen.crud.model.ComplainReplyRecordModel;
import com.jfeat.module.smallsaas.ticket.services.gen.persistence.model.ComplainReplyRecord;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by Code generator on 2022-01-11
 */
public interface QueryComplainReplyRecordDao extends QueryMasterDao<ComplainReplyRecord> {
    /*
     * Query entity list by page
     */
    List<ComplainReplyRecordRecord> findComplainReplyRecordPage(Page<ComplainReplyRecordRecord> page, @Param("record") ComplainReplyRecordRecord record,
                                                                @Param("tag") String tag,
                                                                @Param("search") String search, @Param("orderBy") String orderBy,
                                                                @Param("startTime") Date startTime, @Param("endTime") Date endTime);

    /*
     * Query entity model for details
     */
    ComplainReplyRecordModel queryMasterModel(@Param("id") Long id);


    /*
     * Query entity model list for slave items
     */
    List<ComplainReplyRecordModel> queryMasterModelList(@Param("masterId") Object masterId);
}