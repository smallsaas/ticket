package com.jfeat.module.smallsaas.baasTicket.services.domain.service;

import com.jfeat.module.smallsaas.baasTicket.services.domain.command.Complainrecord.ComplainReplyGenerateCommand;
import com.jfeat.module.smallsaas.baasTicket.services.gen.crud.service.CRUDComplainReplyRecordService;

/**
 * Created by vincent on 2017/10/19.
 */
public interface ComplainReplyRecordService extends CRUDComplainReplyRecordService {

    void createComplainReply(ComplainReplyGenerateCommand command);
}