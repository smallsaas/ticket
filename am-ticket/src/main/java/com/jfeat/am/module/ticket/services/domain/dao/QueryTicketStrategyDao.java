package com.jfeat.am.module.ticket.services.domain.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.ticket.services.persistence.model.TicketStrategy;

import java.util.List;

/**
 * Created by Code Generator on 2017-11-09
 */
public interface QueryTicketStrategyDao extends BaseMapper<TicketStrategy> {
    List<TicketStrategy> findTicketStrategyPage(Page<TicketStrategy> page, TicketStrategy ticketstrategy);

    List<TicketStrategy> queryList();
}