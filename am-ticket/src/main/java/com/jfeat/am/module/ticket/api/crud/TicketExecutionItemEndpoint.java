package com.jfeat.am.module.ticket.api.crud;
import com.jfeat.am.module.log.annotation.BusinessLog;
import org.springframework.web.bind.annotation.GetMapping;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.jfeat.am.module.ticket.services.domain.service.QueryTicketExecutionItemService;
import com.jfeat.am.common.constant.tips.SuccessTip;
import com.jfeat.am.common.constant.tips.Tip;

import com.jfeat.am.module.ticket.services.crud.service.TicketExecutionItemService;
import com.jfeat.am.module.ticket.services.persistence.model.TicketExecutionItem;

import org.springframework.web.bind.annotation.RestController;
import com.jfeat.am.common.controller.BaseController;

import javax.annotation.Resource;
import java.util.Date;


/**
 * <p>
 *  api
 * </p>
 *
 * @author Code Generator
 * @since 2017-11-09
 */
@RestController
@RequestMapping("/api/ticket/ticket_execution_items")
public class TicketExecutionItemEndpoint extends BaseController {

    @Resource
    TicketExecutionItemService ticketExecutionItemService;

    @Resource
    QueryTicketExecutionItemService queryTicketExecutionItemService;

    /// For debug purpose
    @GetMapping("/empty")
    public Tip getEmptyTicketExecutionItem() {
        return SuccessTip.create(new TicketExecutionItem());
    }

    @PostMapping
    @BusinessLog(name = "执行工单子项", value="新增 执行工单子项")
    public Tip createTicketExecutionItem(@RequestBody TicketExecutionItem entity) {
        return SuccessTip.create(ticketExecutionItemService.createMaster(entity));
    }

    @GetMapping("/{id}")
    public Tip getTicketExecutionItem(@PathVariable Long id) {
        return SuccessTip.create(ticketExecutionItemService.retrieveMaster(id));
    }


    @PutMapping("/{id}")
    @BusinessLog(name = "执行工单子项", value="更新 执行工单子项")
    public Tip updateTicketExecutionItem(@PathVariable Long id, @RequestBody TicketExecutionItem entity) {
        return SuccessTip.create(ticketExecutionItemService.updateMaster(entity));
    }

    @DeleteMapping("/{id}")
    @BusinessLog(name = "执行工单子项", value="删除 执行工单子项")
    public Tip deleteTicketExecutionItem(@PathVariable Long id) {
        return SuccessTip.create(ticketExecutionItemService.deleteMaster(id));
    }

    /*@GetMapping
    //此方法可能需要自行添加需要的参数,按需要使用
    public Tip queryTicketExecutionItems(Page<TicketExecutionItem> page,
                @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                        @RequestParam(name = "id", required = false) Long id,
                                                @RequestParam(name = "ticket_executionId", required = false) Long ticket_executionId,
                                                @RequestParam(name = "equipmentId", required = false) Long equipmentId,
                                            @RequestParam(name = "equipmentNumber", required = false) String equipmentNumber,
                                            @RequestParam(name = "equipmentCode", required = false) String equipmentCode,
                                            @RequestParam(name = "equipmentName", required = false) String equipmentName,
                                            @RequestParam(name = "equipmentUnit", required = false) String equipmentUnit,
                                            @RequestParam(name = "equipmentSpec", required = false) String equipmentSpec,
                                                @RequestParam(name = "warehouseId", required = false) Long warehouseId,
                                            @RequestParam(name = "warehouseName", required = false) String warehouseName,
                                                @RequestParam(name = "wh_warehouse_areaId", required = false) Long wh_warehouse_areaId,
                                            @RequestParam(name = "wh_warehouse_areaName", required = false) String wh_warehouse_areaName,
                                                @RequestParam(name = "wh_warehouse_slotId", required = false) Long wh_warehouse_slotId,
                                            @RequestParam(name = "wh_warehouse_slotName", required = false) String wh_warehouse_slotName) {
            page.setCurrent(pageNum);
        page.setSize(pageSize);
        TicketExecutionItem ticketexecutionitem = new TicketExecutionItem();
            ticketexecutionitem .setId(id);
                ticketexecutionitem .setTicket_executionId(ticket_executionId);
                ticketexecutionitem .setEquipmentId(equipmentId);
                ticketexecutionitem .setEquipmentNumber(equipmentNumber);
                ticketexecutionitem .setEquipmentCode(equipmentCode);
                ticketexecutionitem .setEquipmentName(equipmentName);
                ticketexecutionitem .setEquipmentUnit(equipmentUnit);
                ticketexecutionitem .setEquipmentSpec(equipmentSpec);
                ticketexecutionitem .setWarehouseId(warehouseId);
                ticketexecutionitem .setWarehouseName(warehouseName);
                ticketexecutionitem .setWh_warehouse_areaId(wh_warehouse_areaId);
                ticketexecutionitem .setWh_warehouse_areaName(wh_warehouse_areaName);
                ticketexecutionitem .setWh_warehouse_slotId(wh_warehouse_slotId);
                ticketexecutionitem .setWh_warehouse_slotName(wh_warehouse_slotName);

        page.setRecords(queryTicketExecutionItemService.findTicketExecutionItemPage(page, ticketexecutionitem));

        return SuccessTip.create(page);
    }*/
}
