package com.jfeat.cms.ticket.services.domain.dao;

import com.jfeat.cms.ticket.services.persistence.model.TicketExecutionItem;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * Created by Code Generator on 2017-11-09
 */
public interface QueryTicketExecutionItemDao extends BaseMapper<TicketExecutionItem> {
    List<TicketExecutionItem> findTicketExecutionItemPage(Page<TicketExecutionItem> page,TicketExecutionItem ticketexecutionitem);
}