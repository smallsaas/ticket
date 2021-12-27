package com.jfeat.cms.ticket.api.crud;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.am.common.annotation.Permission;
import com.jfeat.cms.ticket.api.permission.TicketPermission;
import com.jfeat.cms.ticket.constant.ProgressionStatus;
import com.jfeat.cms.ticket.services.crud.filter.TicketPlanFilter;
import com.jfeat.cms.ticket.services.crud.service.TicketPlanService;
import com.jfeat.cms.ticket.services.domain.dao.QueryTicketPlanDao;
import com.jfeat.cms.ticket.services.domain.model.TicketPlanModel;
import com.jfeat.cms.ticket.services.domain.service.QueryTicketPlanService;
import com.jfeat.cms.ticket.services.persistence.model.TicketPlan;
import com.jfeat.crud.base.tips.SuccessTip;
import com.jfeat.crud.base.tips.Tip;
import com.jfeat.am.common.controller.BaseController;
import com.jfeat.am.common.crud.CRUDObject;
import com.jfeat.am.common.exception.BusinessCode;
import com.jfeat.am.common.exception.BusinessException;
import com.jfeat.am.core.jwt.JWTKit;
import com.jfeat.am.module.NumberGenerator.services.crud.service.PoolService;
import com.jfeat.am.module.fault.services.crud.service.TicketService;
import com.jfeat.am.module.fault.services.persistence.model.Ticket;
import com.jfeat.crud.base.annotation.BusinessLog;
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
@RequestMapping("/api/ticket/ticket_plans")
public class TicketPlanEndpoint extends BaseController {

    @Resource
    TicketPlanService ticketPlanService;

    @Resource
    QueryTicketPlanService queryTicketPlanService;

    @Resource
    QueryTicketPlanDao queryTicketPlanDao;
    @Resource
    TicketService ticketService;

    @Resource
    PoolService poolService;

    /// For debug purpose
    @GetMapping("/empty")
    public Tip getEmptyTicketPlan() {
        return SuccessTip.create(new TicketPlan());
    }

    @Permission(TicketPermission.TICKET_SAVE)
    @PostMapping
    @BusinessLog(name = "工单计划", value = "新建 工单计划")
    public Tip createTicketPlan(@RequestBody TicketPlanModel entity) {
        Long userId = JWTKit.getUserId(getHttpServletRequest());
        String account = JWTKit.getAccount(getHttpServletRequest());

        entity.setNumber(poolService.getSerialNumber("TPL"));
        entity.setStatus(ProgressionStatus.DRAFT);
        entity.setApplicantId(userId);
        entity.setApplicant(account);
        entity.setApplyTime(new Date());

        ticketPlanService.createMaster(entity, new TicketPlanFilter(), null, null);
        return SuccessTip.create(entity);
    }

    @Permission(TicketPermission.TICKET_SAVE)
    @PostMapping("/create_by_strategy/{strategyId}")
    @BusinessLog(name = "工单计划", value = "新建 通过工单策略新建工单计划")
    public Tip createByStrategy(@PathVariable Long strategyId) {
        Long userId = JWTKit.getUserId(getHttpServletRequest());
        Long planId = ticketPlanService.createByStrategy(userId, strategyId);
        return SuccessTip.create(planId);
    }

    @GetMapping("/{id}")
    @Permission(TicketPermission.TICKET_VIEW)
    public Tip getTicketPlan(@PathVariable Long id) {
        CRUDObject<TicketPlanModel> crudObject = ticketPlanService.retrieveMaster(id, new TicketPlanFilter(), null, null);
        if(crudObject==null){
            throw new BusinessException(BusinessCode.BadRequest.getCode(), "系统错误：不存在的工单计划->"+id);
        }
        return SuccessTip.create(crudObject.toJSONObject());
    }


    @PutMapping("/{id}")
    @Permission(TicketPermission.TICKET_UPDATE)
    @BusinessLog(name = "工单计划", value = "更新 工单计划")
    public Tip updateTicketPlan(@PathVariable Long id, @RequestBody TicketPlanModel ticketPlanModel) {
        ticketPlanModel.setId(id);
        if (ticketPlanModel.getFaultTicketId() != null) {
            Ticket ticket = ticketService.retrieveMaster(ticketPlanModel.getFaultTicketId());
            ticketPlanModel.setFaultName(ticket.getFaultName());
            ticketPlanModel.setFaultTicketNumber(ticket.getNumber());
        }
        Integer result = ticketPlanService.updateMaster(ticketPlanModel, new TicketPlanFilter(), null, null);
        return SuccessTip.create(result);
    }

    @DeleteMapping("/{id}")
    @Permission(TicketPermission.TICKET_DELETE)
    @BusinessLog(name = "工单计划", value = "删除 工单计划")
    public Tip deleteTicketPlan(@PathVariable Long id) {
        return SuccessTip.create(ticketPlanService.deleteMaster(id));
    }

    @GetMapping
    @Permission(TicketPermission.TICKETS_VIEW)
    public Tip queryTicketPlans(Page page,
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
        page.setRecords(queryTicketPlanService.queryMasterList(page, userId, applicant, number, name, executor, planDepartmentName, executeDepartmentName, startTime, endTime, status));

        return SuccessTip.create(page);
    }

    /**
     * 不限制必须是applicant或executor，用于创建或编辑执行单据时需要查询的计划单列表
     */
    @GetMapping("/all")
    public Tip queryAllTicketPlans(Page page,
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
        page.setRecords(queryTicketPlanService.queryMasterList(page, null, applicant, number, name, executor, planDepartmentName, executeDepartmentName, startTime, endTime, status));

        return SuccessTip.create(page);
    }

    @GetMapping("/list")
    @Permission(TicketPermission.TICKETS_VIEW)
    public Tip queryTicketPlans(@RequestParam(required = false) String status) {
        return SuccessTip.create(queryTicketPlanService.queryList(status));
    }

    @Permission(TicketPermission.TICKET_UPDATE)
    @PatchMapping("/{id}")
    @BusinessLog(name = "工单计划", value = "修改 工单计划")
    public Tip patch(@PathVariable Long id,
                     @RequestBody TicketPlan ticketPlan) {
        ticketPlan.setId(id);
        Integer result = ticketPlanService.updateMaster(ticketPlan);
        return SuccessTip.create(result);
    }

    @GetMapping("/warnings")
    @Permission(TicketPermission.TICKETS_VIEW)
    public Tip planWarnings(Page page,
                            @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                            @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        page.setRecords(queryTicketPlanDao.planWarnings(page));

        return SuccessTip.create(page);
    }

}
