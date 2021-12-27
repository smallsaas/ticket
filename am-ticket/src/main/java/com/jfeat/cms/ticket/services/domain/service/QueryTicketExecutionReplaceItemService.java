package com.jfeat.cms.ticket.services.domain.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.cms.ticket.services.persistence.model.TicketExecutionReplaceItem;

import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface QueryTicketExecutionReplaceItemService {
    List<TicketExecutionReplaceItem> findTicketExecutionReplaceItemPage(Page<TicketExecutionReplaceItem> page, TicketExecutionReplaceItem ticketexecutionreplaceitem , String orderBy );
}