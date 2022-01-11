package com.jfeat.module.smallsaas.baasTicket.services.domain.dao;

import com.jfeat.module.smallsaas.baasTicket.services.domain.model.ComplainRecordRecord;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.crud.plus.QueryMasterDao;
import org.apache.ibatis.annotations.Param;
import com.jfeat.module.smallsaas.baasTicket.services.gen.persistence.model.ComplainRecord.ComplainRecord;
import com.jfeat.module.smallsaas.baasTicket.services.gen.crud.model.ComplainRecordModel;

import java.util.Date;
import java.util.List;

/**
 * Created by Code generator on 2022-01-11
 */
public interface QueryComplainRecordDao extends QueryMasterDao<ComplainRecord> {
    /*
     * Query entity list by page
     */
    List<ComplainRecordRecord> findComplainRecordPage(Page<ComplainRecordRecord> page, @Param("record") ComplainRecordRecord record,
                                                      @Param("tag") String tag,
                                                      @Param("search") String search, @Param("orderBy") String orderBy,
                                                      @Param("startTime") Date startTime, @Param("endTime") Date endTime);

    /*
     * Query entity model for details
     */
    ComplainRecordModel queryMasterModel(@Param("id") Long id);


    /*
     * Query entity model list for slave items
     */
    List<ComplainRecordModel> queryMasterModelList(@Param("masterId") Object masterId);
}