package com.jfeat.am.module.ticket.services.crud.service;

import com.jfeat.am.module.ticket.services.persistence.model.TicketExecutionReplaceItem;

import com.jfeat.am.common.crud.CRUDServiceOnly;

import java.util.List;
import java.util.Map;


/**
 * <p>
 * service interface
 * </p>
 *
 * @author Code Generator
 * @since 2018-03-01
 */

public interface TicketExecutionReplaceItemService extends CRUDServiceOnly<TicketExecutionReplaceItem> {

    List<TicketExecutionReplaceItem> query(Map<String,String> map);

}
