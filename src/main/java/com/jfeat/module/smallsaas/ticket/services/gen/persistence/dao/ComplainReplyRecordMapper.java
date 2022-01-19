package com.jfeat.module.smallsaas.ticket.services.gen.persistence.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jfeat.module.smallsaas.ticket.services.gen.persistence.model.ComplainReplyRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ComplainReplyRecordMapper extends BaseMapper<ComplainReplyRecord> {
    @Select("SELECT * FROM nft_complain_reply_record WHERE complain_record_id = #{complainId}")
    List<ComplainReplyRecord> queryByComplainId(@Param("complainId") Long complainId);
}
