package com.jfeat.cms.ticket.services.crud.service;

import com.jfeat.crud.plus.CRUDServiceOverModel;
import com.jfeat.cms.ticket.services.domain.model.TicketPlanModel;
import com.jfeat.cms.ticket.services.persistence.model.TicketPlan;


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
