package com.jfeat.cms.ticket.workflow;

import com.jfeat.am.module.equipment.constant.ProgressionStatus;
import com.jfeat.am.module.equipment.services.persistence.model.EquipmentAllot;
import com.jfeat.am.module.equipment.services.service.EquipmentAllotService;
import com.jfeat.cms.ticket.services.crud.service.TicketPlanService;
import com.jfeat.cms.ticket.services.persistence.model.TicketPlan;
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
public class TicketPlanInstanceChangeListener implements InstanceChangeListener {
    private static final Logger logger = LoggerFactory.getLogger(InstanceChangeListener.class);

    @Resource
    TicketPlanService ticketPlanService;

    @Override
    public void notify(Long formId, ProcessInstance processInstance) {
        logger.debug("formId = {}, processInstance = {}", formId, processInstance);
        TicketPlan ticketPlan = ticketPlanService.retrieveMaster(formId);
        logger.debug("ticketPlan: {}", ticketPlan);
        ticketPlan.setStatus(convert(processInstance.getStatus()));
        ticketPlan.setProcessInstanceId(processInstance.getId());
        ticketPlanService.updateMaster(ticketPlan);
        logger.debug("updated ticketPlan: {}", ticketPlan);
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
