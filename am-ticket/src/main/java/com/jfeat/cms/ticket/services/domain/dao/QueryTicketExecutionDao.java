package com.jfeat.cms.ticket.services.domain.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.cms.ticket.services.persistence.model.TicketExecution;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Code Generator on 2017-11-09
 */
public interface QueryTicketExecutionDao extends BaseMapper<TicketExecution> {
    List<TicketExecution> findTicketExecutionPage(Page<TicketExecution> page, TicketExecution ticketexecution);

    List<TicketExecution> queryMasterList(Page<TicketExecution> page,
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

    List<TicketExecution> queryList(@Param("status") String status);

    List<TicketExecution> queryWarnings(Page<TicketExecution> page);
}