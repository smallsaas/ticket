package com.jfeat.cms.ticket.services.crud.service;

import com.jfeat.cms.ticket.services.persistence.model.TicketExecutionReplaceItem;

import com.jfeat.crud.plus.CRUDServiceOnly;

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
