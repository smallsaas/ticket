package com.jfeat.cms.ticket.workflow;

import com.jfeat.am.module.equipment.constant.ProgressionStatus;
import com.jfeat.cms.ticket.services.crud.service.TicketAcceptanceService;
import com.jfeat.cms.ticket.services.persistence.model.TicketAcceptance;
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
public class TicketAcceptanceInstanceChangeListener implements InstanceChangeListener {
    private static final Logger logger = LoggerFactory.getLogger(InstanceChangeListener.class);

    @Resource
    TicketAcceptanceService ticketAcceptanceService;

    @Override
    public void notify(Long formId, ProcessInstance processInstance) {
        logger.debug("formId = {}, processInstance = {}", formId, processInstance);
        TicketAcceptance ticketAcceptance = ticketAcceptanceService.retrieveMaster(formId);
        logger.debug("ticketAcceptance: {}", ticketAcceptance);
        ticketAcceptance.setStatus(convert(processInstance.getStatus()));
        ticketAcceptance.setProcessInstanceId(processInstance.getId());
        ticketAcceptanceService.updateMaster(ticketAcceptance);
        logger.debug("updated ticketAcceptance: {}", ticketAcceptance);
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
