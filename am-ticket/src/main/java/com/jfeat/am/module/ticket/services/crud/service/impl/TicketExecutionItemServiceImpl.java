package com.jfeat.am.module.ticket.services.crud.service.impl;
            
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.am.module.ticket.services.persistence.model.TicketExecutionItem;
import com.jfeat.am.module.ticket.services.persistence.dao.TicketExecutionItemMapper;
import com.jfeat.am.module.ticket.services.crud.service.TicketExecutionItemService;
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
public class TicketExecutionItemServiceImpl  extends CRUDServiceOnlyImpl<TicketExecutionItem> implements TicketExecutionItemService {


    @Resource
    private TicketExecutionItemMapper ticketExecutionItemMapper;

    @Override
    protected BaseMapper<TicketExecutionItem> getMasterMapper() {
        return ticketExecutionItemMapper;
    }
}


