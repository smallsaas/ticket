package com.jfeat.am.module.ticket.services.domain.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.ticket.services.persistence.model.TicketExecution;

import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface QueryTicketExecutionService {
    List<TicketExecution> findTicketExecutionPage(Page<TicketExecution> page, TicketExecution ticketexecution);

    List<TicketExecution> queryMasterList(Page<TicketExecution> page, Long applicantOrExecutorId, String applicant, String number, String name, String executor, String planDepartmentName, String executeDepartmentName, String startTime, String endTime, String status);

    List<TicketExecution> queryList(String status);
}