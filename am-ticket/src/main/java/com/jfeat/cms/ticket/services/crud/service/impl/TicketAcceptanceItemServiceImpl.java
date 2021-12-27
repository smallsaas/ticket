package com.jfeat.cms.ticket.services.crud.service.impl;
            
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jfeat.cms.ticket.services.persistence.model.TicketAcceptanceItem;
import com.jfeat.cms.ticket.services.persistence.dao.TicketAcceptanceItemMapper;
import com.jfeat.cms.ticket.services.crud.service.TicketAcceptanceItemService;
import com.jfeat.crud.plus.impl.CRUDServiceOnlyImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  implementation
 * </p>
 *
 * @author Code Generator
 * @since 2017-11-09
 */
@Service
public class TicketAcceptanceItemServiceImpl  extends CRUDServiceOnlyImpl<TicketAcceptanceItem> implements TicketAcceptanceItemService {


    @Resource
    private TicketAcceptanceItemMapper ticketAcceptanceItemMapper;

    @Override
    protected BaseMapper<TicketAcceptanceItem> getMasterMapper() {
        return ticketAcceptanceItemMapper;
    }
}


