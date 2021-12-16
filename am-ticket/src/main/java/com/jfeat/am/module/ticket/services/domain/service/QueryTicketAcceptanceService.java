package com.jfeat.am.module.ticket.services.domain.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.ticket.services.persistence.model.TicketAcceptance;

import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface QueryTicketAcceptanceService {
    List<TicketAcceptance> findTicketAcceptancePage(Page<TicketAcceptance> page, TicketAcceptance ticketacceptance);

    List<TicketAcceptance> queryMasterList(Page<TicketAcceptance> page, Long applicantOrExecutorId, String applicant, String number, String name, String executor, String planDepartmentName, String executeDepartmentName, String startTime, String endTime, String status);

}