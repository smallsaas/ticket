package com.jfeat.am.module.ticket.services.crud.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.jfeat.am.module.ticket.services.persistence.model.TicketExecutionReplaceItem;
import com.jfeat.am.module.ticket.services.persistence.dao.TicketExecutionReplaceItemMapper;
import com.jfeat.am.module.ticket.services.crud.service.TicketExecutionReplaceItemService;
import com.jfeat.am.common.crud.impl.CRUDServiceOnlyImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.jfeat.am.common.crud.impl.CRUDServiceOnlyImpl;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * implementation
 * </p>
 *
 * @author Code Generator
 * @since 2018-03-01
 */
@Service
public class TicketExecutionReplaceItemServiceImpl extends CRUDServiceOnlyImpl<TicketExecutionReplaceItem> implements TicketExecutionReplaceItemService {


    @Resource
    private TicketExecutionReplaceItemMapper ticketExecutionReplaceItemMapper;

    @Override
    protected BaseMapper<TicketExecutionReplaceItem> getMasterMapper() {
        return ticketExecutionReplaceItemMapper;
    }

    @Override
    public List<TicketExecutionReplaceItem> query(Map<String, String> map) {
        EntityWrapper<TicketExecutionReplaceItem> entityWrapper = new EntityWrapper<>();
        if (map.size() > 0){
            map.forEach((k,v) -> {
                entityWrapper.eq(k,v);
            });
        }
        return getMasterMapper().selectList(entityWrapper);
    }
}


