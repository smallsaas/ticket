package com.jfeat.am.module.ticket.services.domain.dao;

import com.jfeat.am.module.ticket.services.persistence.model.TicketAcceptance;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.am.module.ticket.services.persistence.model.TicketPlan;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * Created by Code Generator on 2017-11-09
 */
public interface QueryTicketAcceptanceDao extends BaseMapper<TicketAcceptance> {
    List<TicketAcceptance> findTicketAcceptancePage(Page<TicketAcceptance> page,TicketAcceptance ticketacceptance);

    List<TicketAcceptance> queryMasterList(Page<TicketAcceptance> page,
                                     @Param("applicantOrExecutorId") Long applicantOrExecutorId,
                                     @Param("applicant") String applicant,
                                     @Param("number") String number,
                                     @Param("name") String name,
                                     @Param("executor") String executor,
                                     @Param("planDepartmentName") String planDepartmentName,
                                     @Param("executeDepartmentName") String executeDepartmentName,
                                     @Param("startTime") String startTime,
                                     @Param("endTime") String endTime,
                                     @Param("status") String status);
}