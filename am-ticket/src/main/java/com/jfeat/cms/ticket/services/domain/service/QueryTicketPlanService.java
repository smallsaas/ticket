package com.jfeat.cms.ticket.services.domain.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.cms.ticket.services.persistence.model.TicketPlan;

import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface QueryTicketPlanService {

    List<TicketPlan> findTicketPlanPage(Page<TicketPlan> page, TicketPlan ticketplan );

    List<TicketPlan> queryMasterList(Page<TicketPlan> page, Long applicantOrExecutorId, String applicant, String number,String name,String executor,String planDepartmentName,String executeDepartmentName, String startTime, String endTime, String status);

    Integer deleteWfInstance(Long id);

    List<TicketPlan> queryList(String status);
}