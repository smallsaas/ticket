package com.jfeat.cms.ticket.services.domain.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.cms.ticket.services.persistence.model.TicketStrategy;

import java.util.List;

/**
 * Created by Code Generator on 2017-11-09
 */
public interface QueryTicketStrategyDao extends BaseMapper<TicketStrategy> {
    List<TicketStrategy> findTicketStrategyPage(Page<TicketStrategy> page, TicketStrategy ticketstrategy);

    List<TicketStrategy> queryList();
}