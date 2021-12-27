package com.jfeat.cms.ticket.services.domain.dao;

import com.jfeat.cms.ticket.services.persistence.model.TicketAcceptance;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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