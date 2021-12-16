package com.jfeat.am.module.ticket.services.crud.service.impl;
            
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.am.module.ticket.services.persistence.model.TicketAcceptanceItem;
import com.jfeat.am.module.ticket.services.persistence.dao.TicketAcceptanceItemMapper;
import com.jfeat.am.module.ticket.services.crud.service.TicketAcceptanceItemService;
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


