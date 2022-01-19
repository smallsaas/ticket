package com.jfeat.module.smallsaas.ticket.services.gen.crud.service.impl;
// ServiceImpl start


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jfeat.crud.plus.impl.CRUDServiceOnlyImpl;
import com.jfeat.module.smallsaas.ticket.services.gen.crud.service.CRUDComplainRecordService;
import com.jfeat.module.smallsaas.ticket.services.gen.persistence.dao.ComplainRecordMapper;
import com.jfeat.module.smallsaas.ticket.services.gen.persistence.model.complainrecord.ComplainRecord;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * implementation
 * </p>
 * CRUDComplainRecordService
 *
 * @author Code generator
 * @since 2022-01-11
 */

@Service
public class CRUDComplainRecordServiceImpl extends CRUDServiceOnlyImpl<ComplainRecord> implements CRUDComplainRecordService {


    @Resource
    protected ComplainRecordMapper complainRecordMapper;

    @Override
    protected BaseMapper<ComplainRecord> getMasterMapper() {
        return complainRecordMapper;
    }


}


