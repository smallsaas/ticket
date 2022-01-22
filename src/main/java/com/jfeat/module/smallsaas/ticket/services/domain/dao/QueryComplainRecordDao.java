package com.jfeat.module.smallsaas.ticket.services.domain.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.crud.plus.QueryMasterDao;
import com.jfeat.module.smallsaas.ticket.services.domain.model.ComplainRecordRecord;
import com.jfeat.module.smallsaas.ticket.services.gen.crud.model.ComplainRecordModel;
import com.jfeat.module.smallsaas.ticket.services.gen.persistence.model.complainrecord.ComplainRecord;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
    ComplainRecordRecord queryMasterModel(@Param("id") Long id);


    /*
     * Query entity model list for slave items
     */
    List<ComplainRecordModel> queryMasterModelList(@Param("masterId") Object masterId);

    @Select("select * from nft_complain_record Where request_type = #{requestType}")
    List<ComplainRecordRecord> queryComplainRecordPage(Page<ComplainRecordRecord> page, @Param("requestType") String requestType);

    @Select("select * from nft_complain_record Where complainant_id = #{complainantId} AND request_type  LIKE CONCAT('%',#{requestType},'%')  ")
    List<ComplainRecordRecord> queryComplainRecordPageByComplainantId(Page<ComplainRecordRecord> page,@Param("complainantId") Long complainantId,
                                                      @Param("requestType") String requestType);

    @Select("select count(*)  from nft_wisp_order Where id = #{orderId}")
    int OrderExist(@Param("orderId") Long orderId);

    @Update("update nft_wisp_order set  status= 'COMPLAINING' where id = #{orderId};")
    void changOrderStatus(@Param("orderId") Long orderId);
}