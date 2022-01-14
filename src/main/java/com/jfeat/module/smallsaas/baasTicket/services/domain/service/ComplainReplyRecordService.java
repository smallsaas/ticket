package com.jfeat.module.smallsaas.baasTicket.services.domain.service;

import com.jfeat.module.smallsaas.baasTicket.services.domain.command.Complainrecord.ComplainReplyGenerateCommand;
import com.jfeat.module.smallsaas.baasTicket.services.gen.crud.service.CRUDComplainReplyRecordService;
import com.jfeat.module.smallsaas.baasTicket.services.gen.persistence.model.ComplainReplyRecord;

import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface ComplainReplyRecordService extends CRUDComplainReplyRecordService {

    void reply(ComplainReplyGenerateCommand command);

    List<ComplainReplyRecord> queryByComplainId(Long complainId);
}