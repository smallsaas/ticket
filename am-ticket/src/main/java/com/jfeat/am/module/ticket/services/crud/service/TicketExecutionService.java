package com.jfeat.am.module.ticket.services.crud.service;

import com.jfeat.am.common.crud.CRUDServiceOverModel;
import com.jfeat.am.module.ticket.services.domain.model.TicketExecutionModel;
import com.jfeat.am.module.ticket.services.persistence.model.TicketExecution;
import com.jfeat.am.module.ticket.services.persistence.model.TicketExecutionItem;

import java.util.List;


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
