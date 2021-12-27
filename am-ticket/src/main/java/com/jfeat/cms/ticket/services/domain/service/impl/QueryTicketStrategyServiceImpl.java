package com.jfeat.cms.ticket.services.domain.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.cms.ticket.services.domain.dao.QueryTicketStrategyDao;
import com.jfeat.cms.ticket.services.domain.service.QueryTicketStrategyService;
import com.jfeat.cms.ticket.services.persistence.model.TicketStrategy;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author admin
 * @since 2017-10-16
 */
@Service
public class QueryTicketStrategyServiceImpl implements QueryTicketStrategyService {

    @Resource
    QueryTicketStrategyDao queryTicketStrategyDao;

    @Override
    public List<TicketStrategy> findTicketStrategyPage(Page<TicketStrategy> page, TicketStrategy ticketstrategy) {
        return queryTicketStrategyDao.findTicketStrategyPage(page, ticketstrategy);
    }

    public List<TicketStrategy> queryList() {
        return queryTicketStrategyDao.queryList();
    }

}
