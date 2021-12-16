package com.jfeat.am.module.ticket.services.crud.service;
            
import com.jfeat.am.module.ticket.services.persistence.model.TicketStrategy;

import com.jfeat.am.common.crud.CRUDServiceOnly;

import java.util.List;


/**
 * <p>
 *  service interface
 * </p>
 *
 * @author Code Generator
 * @since 2017-11-07
 */

public interface TicketStrategyService  extends CRUDServiceOnly<TicketStrategy> {
    Integer bulkRemoveTicketStrategies(List<Long> ids);
}
