package com.jfeat.am.module.ticket.api.crud;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.common.annotation.Permission;
import com.jfeat.am.common.constant.tips.SuccessTip;
import com.jfeat.am.common.constant.tips.Tip;
import com.jfeat.am.common.controller.BaseController;
import com.jfeat.am.common.crud.CRUDObject;
import com.jfeat.am.core.jwt.JWTKit;
import com.jfeat.am.module.NumberGenerator.services.crud.service.PoolService;
import com.jfeat.am.module.log.annotation.BusinessLog;
import com.jfeat.am.module.ticket.api.permission.TicketPermission;
import com.jfeat.am.module.ticket.constant.ProgressionStatus;
import com.jfeat.am.module.ticket.services.crud.filter.TicketAcceptanceFilter;
import com.jfeat.am.module.ticket.services.crud.service.TicketAcceptanceService;
import com.jfeat.am.module.ticket.services.domain.model.TicketAcceptanceModel;
import com.jfeat.am.module.ticket.services.domain.service.QueryTicketAcceptanceService;
import com.jfeat.am.module.ticket.services.persistence.model.TicketAcceptance;
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
@RequestMapping("/api/ticket/ticket_acceptances")
public class TicketAcceptanceEndpoint extends BaseController {

    @Resource
    TicketAcceptanceService ticketAcceptanceService;
    @Resource
    QueryTicketAcceptanceService queryTicketAcceptanceService;
    @Resource
    PoolService poolService;

    /// For debug purpose
    @GetMapping("/empty")
    public Tip getEmptyTicketAcceptance() {
        return SuccessTip.create(new TicketAcceptance());
    }

    @PostMapping
    @Permission(TicketPermission.TICKET_SAVE)
    @BusinessLog(name = "执行工单", value = "新建 验收工单")
    public Tip createTicketAcceptance(@RequestBody TicketAcceptanceModel entity) {
        Long userId = JWTKit.getUserId(getHttpServletRequest());
        String account = JWTKit.getAccount(getHttpServletRequest());

        entity.setNumber(poolService.getSerialNumber("TAC"));
        entity.setStatus(ProgressionStatus.DRAFT);
        entity.setApplicantId(userId);
        entity.setApplicant(account);
        entity.setApplyTime(new Date());

        ticketAcceptanceService.createMaster(entity, new TicketAcceptanceFilter(), null, null);
        return SuccessTip.create(entity);
    }

    @Permission(TicketPermission.TICKET_SAVE)
    @PostMapping("/create_by_execution/{executionId}")
    @BusinessLog(name = "createByExecution", value = "新建 通过执行工单创建验收工单")
    public Tip createByExecution(@PathVariable Long executionId) {
        Long userId = JWTKit.getUserId(getHttpServletRequest());
        Long acceptanceId = ticketAcceptanceService.createByExecution(userId, executionId);
        return SuccessTip.create(acceptanceId);
    }

    @Permission(TicketPermission.TICKET_VIEW)
    @GetMapping("/{id}")
    public Tip getTicketAcceptance(@PathVariable Long id) {
        CRUDObject<TicketAcceptanceModel> crudObject = ticketAcceptanceService.retrieveMaster(id, new TicketAcceptanceFilter(), null, null);
        return SuccessTip.create(crudObject.toJSONObject());
    }

    @Permission(TicketPermission.TICKET_UPDATE)
    @PutMapping("/{id}")
    @BusinessLog(name = "执行工单", value = "更新 验收工单")
    public Tip updateTicketAcceptance(@PathVariable Long id, @RequestBody TicketAcceptanceModel entity) {
        entity.setId(id);
        return SuccessTip.create(ticketAcceptanceService.updateMaster(entity, new TicketAcceptanceFilter(), null, null));
    }

    @Permission(TicketPermission.TICKET_DELETE)
    @DeleteMapping("/{id}")
    @BusinessLog(name = "执行工单", value = "删除 验收工单")
    public Tip deleteTicketAcceptance(@PathVariable Long id) {
        return SuccessTip.create(ticketAcceptanceService.deleteMaster(id));
    }

    @Permission(TicketPermission.TICKETS_VIEW)
    @GetMapping
    //此方法可能需要自行添加需要的参数,按需要使用
    public Tip queryTicketAcceptances(Page page,
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
        page.setRecords(queryTicketAcceptanceService.queryMasterList(page, userId, applicant, number, name, executor, planDepartmentName, executeDepartmentName, startTime, endTime, status));
        return SuccessTip.create(page);
    }

    @Permission(TicketPermission.TICKET_UPDATE)
    @PatchMapping("/{id}")
    @BusinessLog(name = "执行工单" , value = "更新 执行工单")
    public Tip patch(@PathVariable Long id,
                     @RequestBody TicketAcceptance ticketAcceptance) {
        ticketAcceptance.setId(id);
        Integer result = ticketAcceptanceService.updateMaster(ticketAcceptance);
        return SuccessTip.create(result);
    }
}
