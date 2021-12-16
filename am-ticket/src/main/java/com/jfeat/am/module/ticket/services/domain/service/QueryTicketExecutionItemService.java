package com.jfeat.am.module.ticket.services.domain.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.ticket.services.persistence.model.TicketExecutionItem;

import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface QueryTicketExecutionItemService {
    List<TicketExecutionItem> findTicketExecutionItemPage(Page<TicketExecutionItem> page, TicketExecutionItem ticketexecutionitem );
}