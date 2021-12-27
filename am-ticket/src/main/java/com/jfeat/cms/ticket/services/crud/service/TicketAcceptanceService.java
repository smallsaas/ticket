package com.jfeat.cms.ticket.services.crud.service;
            
import com.jfeat.cms.ticket.services.domain.model.TicketAcceptanceModel;
import com.jfeat.cms.ticket.services.persistence.model.TicketAcceptance;

import com.jfeat.cms.ticket.services.persistence.model.TicketAcceptanceItem;
import com.jfeat.crud.plus.CRUDServiceOverModel;


/**
 * <p>
 *  service interface
 * </p>
 *
 * @author Code Generator
 * @since 2017-11-07
 */

public interface TicketAcceptanceService  extends CRUDServiceOverModel<TicketAcceptance, TicketAcceptanceModel> {

    Integer addSlaveItem(Long masterId, TicketAcceptanceItem item);

    Long createByExecution(Long applicantId, Long executionId);

    @Override
    Integer deleteMaster(long id);
}

