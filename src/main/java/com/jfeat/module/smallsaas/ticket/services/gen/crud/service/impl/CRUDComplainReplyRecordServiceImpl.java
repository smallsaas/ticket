package com.jfeat.module.smallsaas.ticket.services.gen.crud.service.impl;
// ServiceImpl start


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jfeat.crud.plus.impl.CRUDServiceOnlyImpl;
import com.jfeat.module.smallsaas.ticket.services.gen.crud.service.CRUDComplainReplyRecordService;
import com.jfeat.module.smallsaas.ticket.services.gen.persistence.dao.ComplainReplyRecordMapper;
import com.jfeat.module.smallsaas.ticket.services.gen.persistence.model.ComplainReplyRecord;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * implementation
 * </p>
 * CRUDComplainReplyRecordService
 *
 * @author Code generator
 * @since 2022-01-11
 */

@Service
public class CRUDComplainReplyRecordServiceImpl extends CRUDServiceOnlyImpl<ComplainReplyRecord> implements CRUDComplainReplyRecordService {


    @Resource
    protected ComplainReplyRecordMapper complainReplyRecordMapper;

    @Override
    protected BaseMapper<ComplainReplyRecord> getMasterMapper() {
        return complainReplyRecordMapper;
    }


}


