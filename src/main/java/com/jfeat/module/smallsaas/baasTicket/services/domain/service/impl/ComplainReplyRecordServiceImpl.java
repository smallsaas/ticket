package com.jfeat.module.smallsaas.baasTicket.services.domain.service.impl;

import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import com.jfeat.module.smallsaas.baasTicket.services.domain.command.Complainrecord.ComplainReplyGenerateCommand;
import com.jfeat.module.smallsaas.baasTicket.services.domain.dao.QueryComplainRecordDao;
import com.jfeat.module.smallsaas.baasTicket.services.domain.dao.QueryComplainReplyRecordDao;
import com.jfeat.module.smallsaas.baasTicket.services.domain.service.ComplainReplyRecordService;
import com.jfeat.module.smallsaas.baasTicket.services.gen.crud.service.impl.CRUDComplainReplyRecordServiceImpl;
import com.jfeat.module.smallsaas.baasTicket.services.gen.persistence.model.ComplainReplyRecord;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author admin
 * @since 2017-10-16
 */

@Service("complainReplyRecordService")
public class ComplainReplyRecordServiceImpl extends CRUDComplainReplyRecordServiceImpl implements ComplainReplyRecordService {


    @Resource
    private QueryComplainReplyRecordDao queryComplainReplyRecordDao;
    @Resource
    private QueryComplainRecordDao queryComplainRecordDao;

    @Override
    protected String entityName() {
        return "ComplainReplyRecord";
    }

    @Override
    public void createComplainReply(ComplainReplyGenerateCommand command) {

        Optional.ofNullable(queryComplainRecordDao.queryMasterModel(command.getComplainRecordId()))
                .orElseThrow(() -> new BusinessException(BusinessCode.BadRequest, "申述单不存在"));

        Optional.ofNullable(this.queryComplainReplyRecordDao.IsUserExistenceByReplyerId(command.getReplyerId()))
                .orElseThrow(() -> new BusinessException(BusinessCode.BadRequest, "回复人不存在"));

        var isManager=  this.queryComplainReplyRecordDao.IsManagerByReplyerId(command.getReplyerId());

        this.getMasterMapper().insert(ComplainReplyRecord.builder()
                .complainRecordId(command.getComplainRecordId())
                .replyerId(command.getReplyerId())
                .isManagerReply(isManager)
                .content(command.getContent())
                .build());
    }
}
