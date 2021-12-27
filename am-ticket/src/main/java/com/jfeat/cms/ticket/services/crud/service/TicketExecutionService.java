package com.jfeat.cms.ticket.services.crud.service;

import com.jfeat.crud.plus.CRUDServiceOverModel;
import com.jfeat.cms.ticket.services.domain.model.TicketExecutionModel;
import com.jfeat.cms.ticket.services.persistence.model.TicketExecution;


/**
 * <p>
 * service interface
 * </p>
 *
 * @author Code Generator
 * @since 2017-11-07
 */

public interface TicketExecutionService extends CRUDServiceOverModel<TicketExecution, TicketExecutionModel> {

    Integer executeOrder(Long userId, Long id);

    Long createByPlan(Long applicantId,Long planId);


    @Override
    Integer deleteMaster(long id);
}
