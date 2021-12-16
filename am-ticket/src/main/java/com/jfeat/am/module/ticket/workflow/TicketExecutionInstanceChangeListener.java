package com.jfeat.am.module.ticket.workflow;

import com.jfeat.am.module.equipment.constant.ProgressionStatus;
import com.jfeat.am.module.ticket.services.crud.service.TicketExecutionService;
import com.jfeat.am.module.ticket.services.crud.service.TicketPlanService;
import com.jfeat.am.module.ticket.services.persistence.model.TicketExecution;
import com.jfeat.am.module.ticket.services.persistence.model.TicketPlan;
import com.jfeat.am.module.workflow.constant.ProcessInstanceStatusEnum;
import com.jfeat.am.module.workflow.listener.InstanceChangeListener;
import com.jfeat.am.module.workflow.services.persistence.model.ProcessInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by kang on 2017/11/14.
 */
@Service
public class TicketExecutionInstanceChangeListener implements InstanceChangeListener {
    private static final Logger logger = LoggerFactory.getLogger(InstanceChangeListener.class);

    @Resource
    TicketExecutionService ticketExecutionService;

    @Override
    public void notify(Long formId, ProcessInstance processInstance) {
        logger.debug("formId = {}, processInstance = {}", formId, processInstance);
        TicketExecution ticketExecution = ticketExecutionService.retrieveMaster(formId);
        logger.debug("ticketExecution: {}", ticketExecution);
        ticketExecution.setStatus(convert(processInstance.getStatus()));
        ticketExecution.setProcessInstanceId(processInstance.getId());
        ticketExecutionService.updateMaster(ticketExecution);
        logger.debug("updated ticketExecution: {}", ticketExecution);
    }

    private String convert(String instanceStatus) {
        ProcessInstanceStatusEnum processInstanceStatusEnum = ProcessInstanceStatusEnum.valueOf(instanceStatus);
        if (processInstanceStatusEnum == ProcessInstanceStatusEnum.START) {
            return ProgressionStatus.DRAFT;
        }
        if (processInstanceStatusEnum == ProcessInstanceStatusEnum.VERIFYING) {
            return ProgressionStatus.VERIFYING;
        }
        if (processInstanceStatusEnum == ProcessInstanceStatusEnum.CLOSE_APPROVED) {
            return ProgressionStatus.VERIFIED;
        }
        if (processInstanceStatusEnum == ProcessInstanceStatusEnum.CLOSE_REJECTED) {
            return ProgressionStatus.CLOSED;
        }
        throw new IllegalStateException("invalid status: " + instanceStatus);
    }
}
