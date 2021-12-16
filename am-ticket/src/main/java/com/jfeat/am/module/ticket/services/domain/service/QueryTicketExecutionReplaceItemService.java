package com.jfeat.am.module.ticket.services.domain.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.ticket.services.persistence.model.TicketExecutionReplaceItem;

import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface QueryTicketExecutionReplaceItemService {
    List<TicketExecutionReplaceItem> findTicketExecutionReplaceItemPage(Page<TicketExecutionReplaceItem> page, TicketExecutionReplaceItem ticketexecutionreplaceitem ,String orderBy );
}