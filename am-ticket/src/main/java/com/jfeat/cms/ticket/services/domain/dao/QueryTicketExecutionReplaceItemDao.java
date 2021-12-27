package com.jfeat.cms.ticket.services.domain.dao;

import com.jfeat.cms.ticket.services.persistence.model.TicketExecutionReplaceItem;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * Created by Code Generator on 2018-03-01
 */
public interface QueryTicketExecutionReplaceItemDao extends BaseMapper<TicketExecutionReplaceItem> {
    List<TicketExecutionReplaceItem> findTicketExecutionReplaceItemPage(Page<TicketExecutionReplaceItem> page,@Param("ticketExecutionReplaceItem") TicketExecutionReplaceItem ticketExecutionReplaceItem,@Param("orderBy") String orderBy);
}