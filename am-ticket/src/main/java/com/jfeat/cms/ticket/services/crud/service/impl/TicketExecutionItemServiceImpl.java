package com.jfeat.cms.ticket.services.crud.service.impl;
            
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jfeat.cms.ticket.services.persistence.model.TicketExecutionItem;
import com.jfeat.cms.ticket.services.persistence.dao.TicketExecutionItemMapper;
import com.jfeat.cms.ticket.services.crud.service.TicketExecutionItemService;
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
public class TicketExecutionItemServiceImpl  extends CRUDServiceOnlyImpl<TicketExecutionItem> implements TicketExecutionItemService {


    @Resource
    private TicketExecutionItemMapper ticketExecutionItemMapper;

    @Override
    protected BaseMapper<TicketExecutionItem> getMasterMapper() {
        return ticketExecutionItemMapper;
    }
}


