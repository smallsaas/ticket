package com.jfeat.cms.ticket.services.domain.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.cms.ticket.services.domain.dao.QueryTicketPlanDao;
import com.jfeat.cms.ticket.services.domain.service.QueryTicketPlanService;
import com.jfeat.cms.ticket.services.persistence.model.TicketPlan;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author admin
 * @since 2017-10-16
 */
@Service
public class QueryTicketPlanServiceImpl implements QueryTicketPlanService {

    @Resource
    QueryTicketPlanDao queryTicketPlanDao;

    @Override
    public List<TicketPlan> findTicketPlanPage(Page<TicketPlan> page, TicketPlan ticketplan) {
        return queryTicketPlanDao.findTicketPlanPage(page, ticketplan);
    }

    @Override
    public List<TicketPlan> queryMasterList(Page<TicketPlan> page, Long applicantOrExecutorId, String applicant, String number, String name, String executor, String planDepartmentName, String executeDepartmentName, String startTime, String endTime, String status) {
        return queryTicketPlanDao.queryMasterList(page, applicantOrExecutorId, applicant, number, name, executor, planDepartmentName, executeDepartmentName, startTime, endTime, status);
    }

    @Override
    public Integer deleteWfInstance(Long id){
        return queryTicketPlanDao.deleteWfInstance(id,"ticket-plan");
    }

    public List<TicketPlan> queryList(String status) {
        return queryTicketPlanDao.queryList(status);
    }
}
