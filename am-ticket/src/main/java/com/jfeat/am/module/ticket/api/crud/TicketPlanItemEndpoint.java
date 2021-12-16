package com.jfeat.am.module.ticket.api.crud;
import com.jfeat.am.module.log.annotation.BusinessLog;
import org.springframework.web.bind.annotation.GetMapping;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.jfeat.am.module.ticket.services.domain.service.QueryTicketPlanItemService;
import com.jfeat.am.common.constant.tips.ErrorTip;
import com.jfeat.am.common.constant.tips.SuccessTip;
import com.jfeat.am.common.constant.tips.Tip;

import com.jfeat.am.module.ticket.services.crud.service.TicketPlanItemService;
import com.jfeat.am.module.ticket.services.persistence.model.TicketPlanItem;

import org.springframework.web.bind.annotation.RestController;
import com.jfeat.am.common.controller.BaseController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.HashMap;

/**
 * <p>
 *  api
 * </p>
 *
 * @author Code Generator
 * @since 2017-11-07
 */
@RestController
@RequestMapping("/api/ticket/ticket_plan_items")
public class TicketPlanItemEndpoint extends BaseController {

    @Resource
    TicketPlanItemService ticketPlanItemService;

    @Resource
    QueryTicketPlanItemService queryTicketPlanItemService;

    /// For debug purpose
    @GetMapping("/empty")
    public Tip getEmptyTicketPlanItem() {
        return SuccessTip.create(new TicketPlanItem());
    }

    @PostMapping
    @BusinessLog(name = "工单计划子项", value="新增 工单计划子项")
    public Tip createTicketPlanItem(@RequestBody TicketPlanItem entity) {
        return SuccessTip.create(ticketPlanItemService.createMaster(entity));
    }

    @GetMapping("/{id}")
    public Tip getTicketPlanItem(@PathVariable Long id) {
        return SuccessTip.create(ticketPlanItemService.retrieveMaster(id));
    }


    @PutMapping("/{id}")
    @BusinessLog(name = "工单计划子项", value="修改 工单计划子项")
    public Tip updateTicketPlanItem(@PathVariable Long id, @RequestBody TicketPlanItem entity) {
        entity.setId(id);
        return SuccessTip.create(ticketPlanItemService.updateMaster(entity));
    }

    @DeleteMapping("/{id}")
    @BusinessLog(name = "工单计划子项", value="删除 工单计划子项")
    public Tip deleteTicketPlanItem(@PathVariable Long id) {
        return SuccessTip.create(ticketPlanItemService.deleteMaster(id));
    }

    /*@GetMapping
    //此方法可能需要自行添加需要的参数,按需要使用
    public Tip queryTicketPlanItems(Page page,
                @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize,
                @RequestParam(name = "name", required = false) String name,
                @RequestParam(name = "status", required = false) String status) {

        page.setCurrent(pageNum);
        page.setSize(pageSize);
        page.setRecords(queryTicketPlanItemService.findTicketPlanItemPage(page, ticketplanitem));

        return SuccessTip.create(page);
    }*/
}
