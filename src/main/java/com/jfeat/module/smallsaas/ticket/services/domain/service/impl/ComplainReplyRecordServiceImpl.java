package com.jfeat.module.smallsaas.ticket.services.domain.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import com.jfeat.module.smallsaas.ticket.services.domain.command.complainrecord.ComplainReplyGenerateCommand;
import com.jfeat.module.smallsaas.ticket.services.domain.service.ComplainRecordService;
import com.jfeat.module.smallsaas.ticket.services.domain.service.ComplainReplyRecordService;
import com.jfeat.module.smallsaas.ticket.services.gen.crud.service.impl.CRUDComplainReplyRecordServiceImpl;
import com.jfeat.module.smallsaas.ticket.services.gen.persistence.model.complainrecord.ComplainRecordStatus;
import com.jfeat.module.smallsaas.ticket.services.gen.persistence.model.ComplainReplyRecord;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service("complainReplyRecordService")
public class ComplainReplyRecordServiceImpl extends CRUDComplainReplyRecordServiceImpl implements ComplainReplyRecordService {
    @Resource
    private ComplainRecordService complainRecordService;

    @Override
    public void reply(ComplainReplyGenerateCommand command) {
        var complainRecord = Optional.ofNullable(complainRecordService.retrieveMaster(command.getComplainRecordId()))
                .orElseThrow(() -> new BusinessException(BusinessCode.BadRequest, String.format("申诉单[ID:%s]不存在", command.getComplainRecordId())))
                .setStatus(command.getIsManagerReply() == 1 ? ComplainRecordStatus.REPLIED : ComplainRecordStatus.PENDING_REPLY);

        complainRecordService.updateMaster(complainRecord);

        createMaster(ComplainReplyRecord.builder()
                .complainRecordId(command.getComplainRecordId())
                .replierId(command.getReplierId())
                .isManagerReply(command.getIsManagerReply())
                .content(command.getContent())
                .build());
    }

    @Override
    public List<ComplainReplyRecord> queryByComplainId(Long complainId) {
        return complainReplyRecordMapper.selectList(new LambdaQueryWrapper<ComplainReplyRecord>()
                .eq(ComplainReplyRecord::getComplainRecordId, complainId));
    }
}
