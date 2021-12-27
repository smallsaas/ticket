package com.jfeat.cms.ticket.services.crud.service;
            
import com.jfeat.cms.ticket.services.persistence.model.TicketStrategy;

import com.jfeat.crud.plus.CRUDServiceOnly;

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
