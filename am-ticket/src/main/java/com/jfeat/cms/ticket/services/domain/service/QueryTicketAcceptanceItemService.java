package com.jfeat.cms.ticket.services.domain.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.cms.ticket.services.persistence.model.TicketAcceptanceItem;

import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface QueryTicketAcceptanceItemService {
    List<TicketAcceptanceItem> findTicketAcceptanceItemPage(Page<TicketAcceptanceItem> page, TicketAcceptanceItem ticketacceptanceitem );
}