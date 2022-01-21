package com.jfeat.module.smallsaas.ticket.services.domain.service;

import com.jfeat.module.smallsaas.ticket.services.domain.command.complain.ComplainGenerateCommand;
import com.jfeat.module.smallsaas.ticket.services.gen.crud.service.CRUDComplainRecordService;

/**
 * Created by vincent on 2017/10/19.
 */
public interface ComplainRecordService extends CRUDComplainRecordService {

    void createComplain(ComplainGenerateCommand command);

    void complainEnd(Long complainId ,Long complainantId);
}