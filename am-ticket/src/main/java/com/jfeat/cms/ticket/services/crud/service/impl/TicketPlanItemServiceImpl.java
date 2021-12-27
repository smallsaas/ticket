package com.jfeat.cms.ticket.services.crud.service.impl;
            
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jfeat.cms.ticket.services.persistence.model.TicketPlanItem;
import com.jfeat.cms.ticket.services.persistence.dao.TicketPlanItemMapper;
import com.jfeat.cms.ticket.services.crud.service.TicketPlanItemService;
import com.jfeat.crud.plus.impl.CRUDServiceOnlyImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
/**
 * <p>
 *  implementation
 * </p>
 *
 * @author Code Generator
 * @since 2017-11-07
 */
@Service
public class TicketPlanItemServiceImpl  extends CRUDServiceOnlyImpl<TicketPlanItem> implements TicketPlanItemService {


    @Resource
    private TicketPlanItemMapper ticketPlanItemMapper;

    @Override
    protected BaseMapper<TicketPlanItem> getMasterMapper() {
        return ticketPlanItemMapper;
    }
}


