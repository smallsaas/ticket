package com.jfeat.am.module.ticket.api.crud;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.common.annotation.Permission;
import com.jfeat.am.common.constant.tips.ErrorTip;
import com.jfeat.am.common.constant.tips.SuccessTip;
import com.jfeat.am.common.constant.tips.Tip;
import com.jfeat.am.common.controller.BaseController;
import com.jfeat.am.common.crud.CRUDObject;
import com.jfeat.am.common.exception.BusinessException;
import com.jfeat.am.core.jwt.JWTKit;
import com.jfeat.am.module.NumberGenerator.services.crud.service.PoolService;
import com.jfeat.am.module.fault.services.crud.service.TicketService;
import com.jfeat.am.module.fault.services.persistence.model.Ticket;
import com.jfeat.am.module.log.annotation.BusinessLog;
import com.jfeat.am.module.ticket.api.permission.TicketPermission;
import com.jfeat.am.module.ticket.constant.ProgressionStatus;
import com.jfeat.am.module.ticket.services.crud.filter.TicketExecutionFilter;
import com.jfeat.am.module.ticket.services.crud.service.TicketExecutionService;
import com.jfeat.am.module.ticket.services.crud.service.TicketPlanService;
import com.jfeat.am.module.ticket.services.domain.dao.QueryTicketExecutionDao;
import com.jfeat.am.module.ticket.services.domain.model.TicketExecutionModel;
import com.jfeat.am.module.ticket.services.domain.service.QueryTicketExecutionService;
import com.jfeat.am.module.ticket.services.persistence.model.TicketExecution;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

/**
 * <p>
 * api
 * </p>
 *
 * @author Code Generator
 * @since 2017-11-07
 */
@RestController
@RequestMapping("/api/ticket/ticket_executions")
public class TicketExecutionEndpoint extends BaseController {

    @Resource
    TicketExecutionService ticketExecutionService;

    @Resource
    QueryTicketExecutionService queryTicketExecutionService;

    @Resource
    QueryTicketExecutionDao queryTicketExecutionDao;

    @Resource
    TicketPlanService ticketPlanService;

    @Resource
    TicketService ticketService;

    @Resource
    PoolService poolService;

    /// For debug purpose
    @GetMapping("/empty")
    public Tip getEmptyTicketExecution() {
        return SuccessTip.create(new TicketExecution());
    }

    @Permission(TicketPermission.TICKET_SAVE)
    @PostMapping
    @BusinessLog(name = "执行工单", value = "新建 执行工单")
    public Tip createTicketExecution(@RequestBody TicketExecutionModel entity) {
        Long userId = JWTKit.getUserId(getHttpServletRequest());
        String account = JWTKit.getAccount(getHttpServletRequest());

        entity.setNumber(poolService.getSerialNumber("TEX"));
        entity.setStatus(ProgressionStatus.DRAFT);
        entity.setApplicantId(userId);
        entity.setApplicant(account);
        entity.setApplyTime(new Date());

        ticketExecutionService.createMaster(entity, new TicketExecutionFilter(), null, null);
        return SuccessTip.create(entity);
    }

    @Permission(TicketPermission.TICKET_VIEW)
    @GetMapping("/{id}")
    public Tip getTicketExecution(@PathVariable Long id) {
        System.out.println(id);
        CRUDObject<TicketExecutionModel> crudObject = ticketExecutionService.retrieveMaster(id, new TicketExecutionFilter(), null, null);
        return SuccessTip.create(crudObject.toJSONObject());
    }

    @Permission(TicketPermission.TICKET_SAVE)
    @PostMapping("/create_by_plan/{planId}")
    @BusinessLog(name = "执行工单", value = "工单计划生成 执行工单")
    public Tip createByPlan(@PathVariable Long planId) {
        Long userId = JWTKit.getUserId(getHttpServletRequest());
        Long executionId = ticketExecutionService.createByPlan(userId, planId);
        return SuccessTip.create(executionId);
    }

    @Permission(TicketPermission.TICKET_UPDATE)
    @PutMapping("/{id}")
    @BusinessLog(name = "执行工单", value = "更新 执行工单")
    public Tip updateTicketExecution(@PathVariable Long id, @RequestBody TicketExecutionModel entity) {
        entity.setId(id);
        if (entity.getPlanId() != null) {
            entity.setPlanName(ticketPlanService.retrieveMaster(entity.getPlanId()).getName());
        }
        if (entity.getFaultTicketId() != null) {
            Ticket ticket = ticketService.retrieveMaster(entity.getFaultTicketId());
            entity.setFaultName(ticket.getFaultName());
            entity.setFaultTicketNumber(ticket.getNumber());
        }
        return SuccessTip.create(ticketExecutionService.updateMaster(entity, new TicketExecutionFilter(), null, null));
    }

    @Permission(TicketPermission.TICKET_DELETE)
    @DeleteMapping("/{id}")
    @BusinessLog(name = "执行工单", value = "删除 执行工单")
    public Tip deleteTicketExecution(@PathVariable Long id) {
        return SuccessTip.create(ticketExecutionService.deleteMaster(id));
    }

    @Permission(TicketPermission.TICKETS_VIEW)
    @GetMapping
    //此方法可能需要自行添加需要的参数,按需要使用
    public Tip queryTicketExecutions(Page page,
                                     @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                     @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                                     @RequestParam(required = false) String applicant,
                                     @RequestParam(required = false) String number,
                                     @RequestParam(required = false) String name,
                                     @RequestParam(required = false) String executor,
                                     @RequestParam(required = false) String planDepartmentName,
                                     @RequestParam(required = false) String executeDepartmentName,
                                     @RequestParam(required = false) String startTime,
                                     @RequestParam(required = false) String endTime,
                                     @RequestParam(required = false) String status) {
        Long userId = JWTKit.getUserId(getHttpServletRequest());
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        page.setRecords(queryTicketExecutionService.queryMasterList(page, userId, applicant, number, name, executor, planDepartmentName, executeDepartmentName, startTime, endTime, status));

        return SuccessTip.create(page);
    }

    /**
     * 不限制必须是applicant或executor，用于创建或编辑验收单据时需要查询的执行单列表
     */
    @GetMapping("/all")
    public Tip queryAllTicketExecutions(Page page,
                                        @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                        @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                                        @RequestParam(required = false) String applicant,
                                        @RequestParam(required = false) String number,
                                        @RequestParam(required = false) String name,
                                        @RequestParam(required = false) String executor,
                                        @RequestParam(required = false) String planDepartmentName,
                                        @RequestParam(required = false) String executeDepartmentName,
                                        @RequestParam(required = false) String startTime,
                                        @RequestParam(required = false) String endTime,
                                        @RequestParam(required = false) String status) {
        Long userId = JWTKit.getUserId(getHttpServletRequest());
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        page.setRecords(queryTicketExecutionService.queryMasterList(page, null, applicant, number, name, executor, planDepartmentName, executeDepartmentName, startTime, endTime, status));

        return SuccessTip.create(page);
    }


    //不分页
    @Permission(TicketPermission.TICKETS_VIEW)
    @GetMapping("list")
    //此方法可能需要自行添加需要的参数,按需要使用
    public Tip queryTicketExecutionList(String status) {
        return SuccessTip.create(queryTicketExecutionService.queryList(status));
    }

    @PatchMapping("/{id}")
    @Permission(TicketPermission.TICKET_UPDATE)
    @BusinessLog(name = "执行工单", value = "修改 执行工单")
    public Tip patch(@PathVariable Long id,
                     @RequestBody TicketExecution ticketExecution) {
        ticketExecution.setId(id);
        Integer result = ticketExecutionService.updateMaster(ticketExecution);
        return SuccessTip.create(result);
    }

    @PutMapping("/{id}/execute")
    @Permission(TicketPermission.TICKET_UPDATE)
    @BusinessLog(name = "执行工单", value = "执行 执行工单")
    public Tip executeOrder(@PathVariable Long id) {
        Long userId = JWTKit.getUserId(getHttpServletRequest());
        try {
            ticketExecutionService.executeOrder(userId, id);
        } catch (BusinessException e) {
            return ErrorTip.create(e.getCode(), e.getMessage());
        }
        return SuccessTip.create();
    }

    //不分页
    @Permission(TicketPermission.TICKETS_VIEW)
    @GetMapping("/warnings")
    //此方法可能需要自行添加需要的参数,按需要使用
    public Tip queryWarnings(Page page,
                             @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                             @RequestParam(required = false, defaultValue = "10") Integer pageSize) {

        page.setCurrent(pageNum);
        page.setSize(pageSize);
        page.setRecords(queryTicketExecutionDao.queryWarnings(page));
        return SuccessTip.create(page);
    }

}
