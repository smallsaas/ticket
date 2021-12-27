package com.jfeat.cms.ticket.services.domain.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.cms.ticket.services.domain.dao.QueryTicketAcceptanceItemDao;
import com.jfeat.cms.ticket.services.domain.service.QueryTicketAcceptanceItemService;
import com.jfeat.cms.ticket.services.persistence.model.TicketAcceptanceItem;
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
