package com.jfeat.am.module.ticket.api.crud;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.common.annotation.Permission;
import com.jfeat.am.common.constant.tips.SuccessTip;
import com.jfeat.am.common.constant.tips.Tip;
import com.jfeat.am.common.controller.BaseController;
import com.jfeat.am.core.jwt.JWTKit;
import com.jfeat.am.module.NumberGenerator.services.crud.service.PoolService;
import com.jfeat.am.module.fault.services.domain.model.Ids;
import com.jfeat.am.module.log.annotation.BusinessLog;
import com.jfeat.am.module.ticket.api.permission.TicketPermission;
import com.jfeat.am.module.ticket.constant.ProgressionStatus;
import com.jfeat.am.module.ticket.services.crud.service.TicketStrategyService;
import com.jfeat.am.module.ticket.services.domain.service.QueryTicketStrategyService;
import com.jfeat.am.module.ticket.services.persistence.model.TicketStrategy;
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
@RequestMapping("/api/ticket/ticket_strategies")
public class TicketStrategyEndpoint extends BaseController {

    @Resource
    TicketStrategyService ticketStrategyService;

    @Resource
    QueryTicketStrategyService queryTicketStrategyService;

    /// For debug purpose
    @GetMapping("/empty")
    public Tip getEmptyTicketStrategy() {
        return SuccessTip.create(new TicketStrategy());
    }

    @PostMapping
    @Permission(TicketPermission.TICKET_SAVE)
    @BusinessLog(name = "工单策略", value = "新建 工单策略")
    public Tip createTicketStrategy(@RequestBody TicketStrategy entity) {
        return SuccessTip.create(ticketStrategyService.createMaster(entity));
    }

    @GetMapping("/{id}")
    @Permission(TicketPermission.TICKET_VIEW)
    public Tip getTicketStrategy(@PathVariable Long id) {
        return SuccessTip.create(ticketStrategyService.retrieveMaster(id));
    }


    @PutMapping("/{id}")
    @Permission(TicketPermission.TICKET_UPDATE)
    @BusinessLog(name = "工单策略", value = "更新 工单策略")
    public Tip updateTicketStrategy(@PathVariable Long id, @RequestBody TicketStrategy entity) {
        entity.setId(id);
        return SuccessTip.create(ticketStrategyService.updateMaster(entity));
    }

    @DeleteMapping("/{id}")
    @Permission(TicketPermission.TICKET_DELETE)
    @BusinessLog(name = "工单策略", value = "删除 工单策略")
    public Tip deleteTicketStrategy(@PathVariable Long id) {
        return SuccessTip.create(ticketStrategyService.deleteMaster(id));
    }

    @GetMapping
    @Permission(TicketPermission.TICKETS_VIEW)
    //此方法可能需要自行添加需要的参数,按需要使用
    public Tip queryTicketStrategys(Page page,
                                    @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                    @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize,
                                    @RequestParam(name = "name", required = false) String name,
                                    @RequestParam(name = "executeDepartmentName", required = false) String executeDepartmentName) {
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        TicketStrategy ticketStrategy = new TicketStrategy();
        ticketStrategy.setName(name);
        ticketStrategy.setExecuteDepartmentName(executeDepartmentName);
        page.setRecords(queryTicketStrategyService.findTicketStrategyPage(page, ticketStrategy));

        return SuccessTip.create(page);
    }

    @Permission(TicketPermission.TICKETS_VIEW)
    @GetMapping("/list")
    public Tip queryList() {
        return SuccessTip.create(queryTicketStrategyService.queryList());
    }

    @Permission(TicketPermission.TICKET_DELETE)
    @PostMapping("/bulk/delete")
    @BusinessLog(name = "工单策略", value = "批量删除 工单策略")
    public Tip bulkDelete(@RequestBody Ids ids) {
        Integer result = ticketStrategyService.bulkRemoveTicketStrategies(ids.getIds());
        return SuccessTip.create(result);
    }

    @Permission(TicketPermission.TICKET_UPDATE)
    @PatchMapping("/{id}")
    @BusinessLog(name = "工单策略", value = "更新 工单策略")
    public Tip patch(@PathVariable Long id,
                     @RequestBody TicketStrategy ticketStrategy) {
        ticketStrategy.setId(id);
        Integer result = ticketStrategyService.updateMaster(ticketStrategy);
        return SuccessTip.create(result);
    }
}
