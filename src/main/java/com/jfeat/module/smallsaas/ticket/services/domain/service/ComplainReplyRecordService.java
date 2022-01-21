package com.jfeat.module.smallsaas.ticket.services.domain.service;

import com.jfeat.module.smallsaas.ticket.services.domain.command.complainrecord.ComplainReplyGenerateCommand;
import com.jfeat.module.smallsaas.ticket.services.gen.crud.service.CRUDComplainReplyRecordService;
import com.jfeat.module.smallsaas.ticket.services.gen.persistence.model.ComplainReplyRecord;

import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface ComplainReplyRecordService extends CRUDComplainReplyRecordService {

    void reply(ComplainReplyGenerateCommand command);

    List<ComplainReplyRecord> queryByComplainId(Long complainId);
}