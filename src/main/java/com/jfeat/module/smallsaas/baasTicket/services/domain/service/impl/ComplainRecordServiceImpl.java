package com.jfeat.module.smallsaas.baasTicket.services.domain.service.impl;

import com.jfeat.module.smallsaas.baasTicket.services.domain.command.Complain.ComplainGenerateCommand;
import com.jfeat.module.smallsaas.baasTicket.services.domain.service.ComplainRecordService;
import com.jfeat.module.smallsaas.baasTicket.services.gen.crud.service.impl.CRUDComplainRecordServiceImpl;
import com.jfeat.module.smallsaas.baasTicket.services.gen.persistence.model.ComplainRecord.ComplainRecord;
import com.jfeat.module.smallsaas.baasTicket.services.gen.persistence.model.ComplainRecord.ComplainRecordStatus;
import org.springframework.stereotype.Service;
/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author admin
 * @since 2017-10-16
 */

@Service("complainRecordService")
public class ComplainRecordServiceImpl extends CRUDComplainRecordServiceImpl implements ComplainRecordService {

    @Override
    protected String entityName() {
        return "ComplainRecord";
    }


    @Override
    public void createComplain(ComplainGenerateCommand command) {
        this.createMaster(ComplainRecord.builder()
                .complainantId(command.getComplainantId())
                .relationOrderId(command.getRelationOrderId())
                .title(command.getTitle())
                .content(command.getContent())
                .credentialLink(command.getCredentialLink())
                .status(ComplainRecordStatus.PENDING_REPLY).build());
    }
}
