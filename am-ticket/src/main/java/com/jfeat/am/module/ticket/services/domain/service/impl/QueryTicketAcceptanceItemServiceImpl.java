package com.jfeat.am.module.ticket.services.domain.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.ticket.services.domain.dao.QueryTicketAcceptanceItemDao;
import com.jfeat.am.module.ticket.services.domain.service.QueryTicketAcceptanceItemService;
import com.jfeat.am.module.ticket.services.persistence.model.TicketAcceptanceItem;
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
public class QueryTicketAcceptanceItemServiceImpl implements QueryTicketAcceptanceItemService {

    @Resource
    QueryTicketAcceptanceItemDao queryTicketAcceptanceItemDao;

    @Override
    public List<TicketAcceptanceItem> findTicketAcceptanceItemPage(Page<TicketAcceptanceItem> page, TicketAcceptanceItem ticketacceptanceitem) {
        return queryTicketAcceptanceItemDao.findTicketAcceptanceItemPage(page, ticketacceptanceitem);
    }
}
