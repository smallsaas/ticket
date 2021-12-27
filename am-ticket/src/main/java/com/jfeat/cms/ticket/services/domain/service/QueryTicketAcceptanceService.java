package com.jfeat.cms.ticket.services.domain.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.cms.ticket.services.persistence.model.TicketAcceptance;

import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface QueryTicketAcceptanceService {
    List<TicketAcceptance> findTicketAcceptancePage(Page<TicketAcceptance> page, TicketAcceptance ticketacceptance);

    List<TicketAcceptance> queryMasterList(Page<TicketAcceptance> page, Long applicantOrExecutorId, String applicant, String number, String name, String executor, String planDepartmentName, String executeDepartmentName, String startTime, String endTime, String status);

}