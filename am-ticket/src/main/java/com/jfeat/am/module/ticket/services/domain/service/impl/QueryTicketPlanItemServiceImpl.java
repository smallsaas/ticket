package com.jfeat.am.module.ticket.services.domain.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.ticket.services.domain.dao.QueryTicketPlanItemDao;
import com.jfeat.am.module.ticket.services.domain.service.QueryTicketPlanItemService;
import com.jfeat.am.module.ticket.services.persistence.model.TicketPlanItem;
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
