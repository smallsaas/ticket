package com.jfeat.cms.ticket.services.domain.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.cms.ticket.services.domain.dao.QueryTicketExecutionDao;
import com.jfeat.cms.ticket.services.domain.service.QueryTicketExecutionService;
import com.jfeat.cms.ticket.services.persistence.model.TicketExecution;
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
public class QueryTicketExecutionServiceImpl implements QueryTicketExecutionService {

    @Resource
    QueryTicketExecutionDao queryTicketExecutionDao;

    @Override
    public List<TicketExecution> findTicketExecutionPage(Page<TicketExecution> page, TicketExecution ticketexecution) {
        return queryTicketExecutionDao.findTicketExecutionPage(page, ticketexecution);
    }

    @Override
    public List<TicketExecution> queryMasterList(Page<TicketExecution> page, Long applicantOrExecutorId, String applicant, String number, String name, String executor, String planDepartmentName, String executeDepartmentName, String startTime, String endTime, String status) {
        return queryTicketExecutionDao.queryMasterList(page, applicantOrExecutorId, applicant, number, name, executor, planDepartmentName, executeDepartmentName, startTime, endTime, status);
    }

    public List<TicketExecution> queryList(String status) {
        return queryTicketExecutionDao.queryList(status);
    }

}
