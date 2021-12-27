package com.jfeat.cms.ticket.services.crud.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jfeat.crud.plus.impl.CRUDServiceOnlyImpl;
import com.jfeat.cms.ticket.services.crud.service.TicketStrategyService;
import com.jfeat.cms.ticket.services.persistence.dao.TicketStrategyMapper;
import com.jfeat.cms.ticket.services.persistence.model.TicketStrategy;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * implementation
 * </p>
 *
 * @author Code Generator
 * @since 2017-11-07
 */
@Service
public class TicketStrategyServiceImpl extends CRUDServiceOnlyImpl<TicketStrategy> implements TicketStrategyService {


    @Resource
    private TicketStrategyMapper ticketStrategyMapper;

    @Override
    protected BaseMapper<TicketStrategy> getMasterMapper() {
        return ticketStrategyMapper;
    }

    public Integer bulkRemoveTicketStrategies(List<Long> ids) {
        return bulkDeleteMasterList(ids);
    }
}


