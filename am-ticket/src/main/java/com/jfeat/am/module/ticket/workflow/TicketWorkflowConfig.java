package com.jfeat.am.module.ticket.workflow;

import com.jfeat.am.module.workflow.listener.InstanceChangeListenerRegister;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by kang on 2017/11/14.
 */
@Component
public class TicketWorkflowConfig implements ApplicationListener<ApplicationReadyEvent> {

    @Resource
    InstanceChangeListenerRegister instanceStatusChangeListenerRegister;

    @Resource
    TicketPlanInstanceChangeListener ticketPlanInstanceChangeListener;

    @Resource
    TicketExecutionInstanceChangeListener ticketExecutionInstanceChangeListener;
    @Resource
    TicketAcceptanceInstanceChangeListener ticketAcceptanceInstanceChangeListener;

    private static final String TICKET_PLAN = "ticket-plan";
    private static final String TICKET_EXECUTION = "ticket-execution";
    private static final String TICKET_ACCEPTANCE = "ticket-acceptance";


    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        instanceStatusChangeListenerRegister.register(TICKET_PLAN, ticketPlanInstanceChangeListener);
        instanceStatusChangeListenerRegister.register(TICKET_EXECUTION, ticketExecutionInstanceChangeListener);
        instanceStatusChangeListenerRegister.register(TICKET_ACCEPTANCE, ticketAcceptanceInstanceChangeListener);

    }
}
