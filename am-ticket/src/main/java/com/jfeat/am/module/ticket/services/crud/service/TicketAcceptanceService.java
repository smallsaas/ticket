package com.jfeat.am.module.ticket.services.crud.service;
            
import com.jfeat.am.common.crud.CRUDServiceOverModel;
import com.jfeat.am.module.ticket.services.domain.model.TicketAcceptanceModel;
import com.jfeat.am.module.ticket.services.persistence.dao.TicketAcceptanceMapper;
import com.jfeat.am.module.ticket.services.persistence.model.TicketAcceptance;

import com.jfeat.am.common.crud.CRUDServiceOnly;
import com.jfeat.am.module.ticket.services.persistence.model.TicketAcceptanceItem;
import com.jfeat.am.module.ticket.services.persistence.model.TicketExecutionItem;

import java.util.List;


/**
 * <p>
 *  service interface
 * </p>
 *
 * @author Code Generator
 * @since 2017-11-07
 */

public interface TicketAcceptanceService  extends CRUDServiceOverModel<TicketAcceptance,TicketAcceptanceModel> {

    Integer addSlaveItem(Long masterId, TicketAcceptanceItem item);

    Long createByExecution(Long applicantId, Long executionId);

    @Override
    Integer deleteMaster(long id);
}

