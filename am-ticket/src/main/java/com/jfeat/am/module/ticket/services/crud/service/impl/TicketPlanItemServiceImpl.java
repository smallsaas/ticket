package com.jfeat.am.module.ticket.services.crud.service.impl;
            
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.am.module.ticket.services.persistence.model.TicketPlanItem;
import com.jfeat.am.module.ticket.services.persistence.dao.TicketPlanItemMapper;
import com.jfeat.am.module.ticket.services.crud.service.TicketPlanItemService;
import com.jfeat.am.common.crud.impl.CRUDServiceOnlyImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import com.jfeat.am.common.crud.impl.CRUDServiceOnlyImpl;
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


