package com.jfeat.cms.ticket.services.domain.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.cms.ticket.services.persistence.model.TicketStrategy;

import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface QueryTicketStrategyService {
    List<TicketStrategy> findTicketStrategyPage(Page<TicketStrategy> page, TicketStrategy ticketstrategy);

    List<TicketStrategy> queryList();
}