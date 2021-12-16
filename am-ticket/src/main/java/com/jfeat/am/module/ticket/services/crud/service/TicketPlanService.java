package com.jfeat.am.module.ticket.services.crud.service;

import com.jfeat.am.common.crud.CRUDServiceOverModel;
import com.jfeat.am.module.ticket.services.domain.model.TicketPlanModel;
import com.jfeat.am.module.ticket.services.persistence.model.TicketPlan;


/**
 * <p>
 * service interface
 * </p>
 *
 * @author Code Generator
 * @since 2017-11-07
 */

public interface TicketPlanService extends CRUDServiceOverModel<TicketPlan, TicketPlanModel> {

    Long createByStrategy(Long applicantId, Long strategyId);

    @Override
    Integer deleteMaster(long id);

}
