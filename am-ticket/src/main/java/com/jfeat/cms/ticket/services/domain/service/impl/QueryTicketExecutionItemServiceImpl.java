package com.jfeat.cms.ticket.services.domain.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.cms.ticket.services.domain.dao.QueryTicketExecutionItemDao;
import com.jfeat.cms.ticket.services.domain.service.QueryTicketExecutionItemService;
import com.jfeat.cms.ticket.services.persistence.model.TicketExecutionItem;
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
public class QueryTicketExecutionItemServiceImpl implements QueryTicketExecutionItemService {

    @Resource
    QueryTicketExecutionItemDao queryTicketExecutionItemDao;

    @Override
    public List<TicketExecutionItem> findTicketExecutionItemPage(Page<TicketExecutionItem> page, TicketExecutionItem ticketexecutionitem) {
        return queryTicketExecutionItemDao.findTicketExecutionItemPage(page, ticketexecutionitem);
    }
}
