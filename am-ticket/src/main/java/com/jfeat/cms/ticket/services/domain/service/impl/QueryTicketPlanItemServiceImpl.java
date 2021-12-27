package com.jfeat.cms.ticket.services.domain.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.cms.ticket.services.domain.dao.QueryTicketPlanItemDao;
import com.jfeat.cms.ticket.services.domain.service.QueryTicketPlanItemService;
import com.jfeat.cms.ticket.services.persistence.model.TicketPlanItem;
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
public class QueryTicketPlanItemServiceImpl implements QueryTicketPlanItemService {

    @Resource
    QueryTicketPlanItemDao queryTicketPlanItemDao;

    @Override
    public List<TicketPlanItem> findTicketPlanItemPage(Page<TicketPlanItem> page, TicketPlanItem ticketplanitem) {
        return queryTicketPlanItemDao.findTicketPlanItemPage(page, ticketplanitem);
    }
}
