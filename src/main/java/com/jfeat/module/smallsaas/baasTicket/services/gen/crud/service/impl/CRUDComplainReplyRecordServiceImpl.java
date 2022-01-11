package com.jfeat.module.smallsaas.baasTicket.services.gen.crud.service.impl;
// ServiceImpl start


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jfeat.crud.plus.FIELD;
import com.jfeat.module.smallsaas.baasTicket.services.gen.persistence.model.ComplainReplyRecord;
import com.jfeat.module.smallsaas.baasTicket.services.gen.persistence.dao.ComplainReplyRecordMapper;
import com.jfeat.module.smallsaas.baasTicket.services.gen.crud.service.CRUDComplainReplyRecordService;
import org.springframework.stereotype.Service;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;

import javax.annotation.Resource;

import com.jfeat.crud.plus.impl.CRUDServiceOnlyImpl;

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


