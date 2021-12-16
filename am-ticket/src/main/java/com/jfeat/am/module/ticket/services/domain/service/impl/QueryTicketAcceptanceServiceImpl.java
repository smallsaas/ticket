package com.jfeat.am.module.ticket.services.domain.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.ticket.services.domain.dao.QueryTicketAcceptanceDao;
import com.jfeat.am.module.ticket.services.domain.service.QueryTicketAcceptanceService;
import com.jfeat.am.module.ticket.services.persistence.model.TicketAcceptance;
import com.jfeat.am.module.ticket.services.persistence.model.TicketPlan;
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
public class QueryTicketAcceptanceServiceImpl implements QueryTicketAcceptanceService {

    @Resource
    QueryTicketAcceptanceDao queryTicketAcceptanceDao;

    @Override
    public List<TicketAcceptance> findTicketAcceptancePage(Page<TicketAcceptance> page, TicketAcceptance ticketacceptance) {
        return queryTicketAcceptanceDao.findTicketAcceptancePage(page, ticketacceptance);
    }


    @Override
    public List<TicketAcceptance> queryMasterList(Page<TicketAcceptance> page, Long applicantOrExecutorId, String applicant, String number, String name, String executor, String planDepartmentName, String executeDepartmentName, String startTime, String endTime, String status) {
        return queryTicketAcceptanceDao.queryMasterList(page, applicantOrExecutorId, applicant, number, name, executor, planDepartmentName, executeDepartmentName, startTime, endTime, status);
    }
}
