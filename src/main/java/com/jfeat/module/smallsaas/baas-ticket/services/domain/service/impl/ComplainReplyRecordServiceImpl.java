package com.jfeat.module.smallsaas.baas-ticket.services.domain.service.impl;
import com.jfeat.module.smallsaas.baas-ticket.services.domain.service.ComplainReplyRecordService;
import com.jfeat.module.smallsaas.baas-ticket.services.gen.crud.service.impl.CRUDComplainReplyRecordServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2017-10-16
 */

@Service("complainReplyRecordService")
public class ComplainReplyRecordServiceImpl extends CRUDComplainReplyRecordServiceImpl implements ComplainReplyRecordService {

    @Override
    protected String entityName() {
        return "ComplainReplyRecord";
    }


                            }
