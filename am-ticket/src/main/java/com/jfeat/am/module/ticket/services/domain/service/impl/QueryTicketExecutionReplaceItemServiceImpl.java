package com.jfeat.am.module.ticket.services.domain.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.ticket.services.domain.dao.QueryTicketExecutionReplaceItemDao;
import com.jfeat.am.module.ticket.services.domain.service.QueryTicketExecutionReplaceItemService;
import com.jfeat.am.module.ticket.services.persistence.model.TicketExecutionReplaceItem;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2017-10-16
 */
@Service
public class QueryTicketExecutionReplaceItemServiceImpl implements QueryTicketExecutionReplaceItemService {

    @Resource
    QueryTicketExecutionReplaceItemDao queryTicketExecutionReplaceItemDao;

    @Override
    public List<TicketExecutionReplaceItem> findTicketExecutionReplaceItemPage(Page<TicketExecutionReplaceItem> page, TicketExecutionReplaceItem ticketExecutionReplaceItem,String orderBy) {
        return queryTicketExecutionReplaceItemDao.findTicketExecutionReplaceItemPage(page, ticketExecutionReplaceItem, orderBy);
    }
}
