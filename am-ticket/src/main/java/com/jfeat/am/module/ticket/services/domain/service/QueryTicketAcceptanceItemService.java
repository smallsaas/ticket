package com.jfeat.am.module.ticket.services.domain.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.ticket.services.persistence.model.TicketAcceptanceItem;

import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface QueryTicketAcceptanceItemService {
    List<TicketAcceptanceItem> findTicketAcceptanceItemPage(Page<TicketAcceptanceItem> page, TicketAcceptanceItem ticketacceptanceitem );
}