package com.jfeat.am.module.ticket.services.domain.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.ticket.services.persistence.model.TicketPlanItem;

import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface QueryTicketPlanItemService {
    List<TicketPlanItem> findTicketPlanItemPage(Page<TicketPlanItem> page, TicketPlanItem ticketplanitem );
}