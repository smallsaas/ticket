package com.jfeat.am.module.ticket.services.domain.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.ticket.services.persistence.model.TicketStrategy;

import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface QueryTicketStrategyService {
    List<TicketStrategy> findTicketStrategyPage(Page<TicketStrategy> page, TicketStrategy ticketstrategy);

    List<TicketStrategy> queryList();
}