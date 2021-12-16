package com.jfeat.am.module.ticket.services.domain.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.ticket.services.persistence.model.TicketPlan;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Code Generator on 2017-11-09
 */
public interface QueryTicketPlanDao extends BaseMapper<TicketPlan> {

    @Select("select count(id) from wf_process_instance where form_id=#{formId}")
    Integer checkProcessInstanceAssociated(@Param("formId") Long formId);

    @Select("select count(id) from wf_history where form_id=#{formId}")
    Integer checkProcessHistoryAssociated(@Param("formId") Long formId);


    List<TicketPlan> findTicketPlanPage(Page<TicketPlan> page, TicketPlan ticketplan);

    List<TicketPlan> queryMasterList(Page<TicketPlan> page,
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

    List<TicketPlan> queryList(@Param("status") String status);

    List<TicketPlan> planWarnings(Page<TicketPlan> page/*,
                                  @Param("configDays") Integer configDays*/);

    Integer deleteWfInstance(@Param("id") Long id,@Param("type") String type);

}