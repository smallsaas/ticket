package com.jfeat.am.module.ticket.api.crud;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.jfeat.am.module.ticket.services.domain.service.QueryTicketExecutionReplaceItemService;
import com.jfeat.am.common.constant.tips.SuccessTip;
import com.jfeat.am.common.constant.tips.Tip;
import com.jfeat.am.module.log.annotation.BusinessLog;

import com.jfeat.am.module.ticket.services.crud.service.TicketExecutionReplaceItemService;
import com.jfeat.am.module.ticket.services.persistence.model.TicketExecutionReplaceItem;

import org.springframework.web.bind.annotation.RestController;
import com.jfeat.am.common.controller.BaseController;

import javax.annotation.Resource;
import java.util.Date;


/**
 * <p>
 * api
 * </p>
 *
 * @author Code Generator
 * @since 2018-03-01
 */
@RestController
@RequestMapping("/api/ticket/ticket-execution-replace-item")
public class TicketExecutionReplaceItemEndpoint extends BaseController {

    @Resource
    TicketExecutionReplaceItemService ticketExecutionReplaceItemService;

    @Resource
    QueryTicketExecutionReplaceItemService queryTicketExecutionReplaceItemService;

    @PostMapping
    @BusinessLog(name = "执行工单 修复项", value = "新增 执行工单 修复项")
    public Tip createTicketExecutionReplaceItem(@RequestBody TicketExecutionReplaceItem entity) {
        return SuccessTip.create(ticketExecutionReplaceItemService.createMaster(entity));
    }

    @GetMapping("/{id}")
    public Tip getTicketExecutionReplaceItem(@PathVariable Long id) {
        return SuccessTip.create(ticketExecutionReplaceItemService.retrieveMaster(id));
    }

    @PutMapping("/{id}")
    @BusinessLog(name = "执行工单 修复项", value = "修改 执行工单 修复项")
    public Tip updateTicketExecutionReplaceItem(@PathVariable Long id, @RequestBody TicketExecutionReplaceItem entity) {
        entity.setId(id);
        return SuccessTip.create(ticketExecutionReplaceItemService.updateMaster(entity));
    }

    @DeleteMapping("/{id}")
    @BusinessLog(name = "执行工单 修复项", value = "删除 执行工单 修复项")
    public Tip deleteTicketExecutionReplaceItem(@PathVariable Long id) {
        return SuccessTip.create(ticketExecutionReplaceItemService.deleteMaster(id));
    }

    @GetMapping
    public Tip queryTicketExecutionReplaceItems(Page<TicketExecutionReplaceItem> page,
                                                @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                                @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                                @RequestParam(name = "id", required = false) Long id,
                                                @RequestParam(name = "ticketId", required = false) Long ticketId,
                                                @RequestParam(name = "equipmentId", required = false) Long equipmentId,
                                                @RequestParam(name = "equipmentNumber", required = false) String equipmentNumber,
                                                @RequestParam(name = "equipmentCode", required = false) String equipmentCode,
                                                @RequestParam(name = "equipmentName", required = false) String equipmentName,
                                                @RequestParam(name = "equipmentUnit", required = false) String equipmentUnit,
                                                @RequestParam(name = "equipmentSpec", required = false) String equipmentSpec,
                                                @RequestParam(name = "warehouseId", required = false) Long warehouseId,
                                                @RequestParam(name = "warehouseName", required = false) String warehouseName,
                                                @RequestParam(name = "whWarehouseAreaId", required = false) Long whWarehouseAreaId,
                                                @RequestParam(name = "whWarehouseAreaName", required = false) String whWarehouseAreaName,
                                                @RequestParam(name = "whWarehouseSlotId", required = false) Long whWarehouseSlotId,
                                                @RequestParam(name = "whWarehouseSlotName", required = false) String whWarehouseSlotName,
                                                @RequestParam(name = "orderBy", required = false) String orderBy,
                                                @RequestParam(name = "sort", required = false) String sort) {
        if (orderBy != null && orderBy.length() > 0) {
            if (sort != null && sort.length() > 0) {
                String pattren = "(ASC|DESC|asc|desc)";
                if (!sort.matches(pattren)) {
                    throw new RuntimeException("sort must be ASC or DESC");//此处异常类型根据实际情况而定
                }
            } else {
                sort = "ASC";
            }
            orderBy = "`" + orderBy + "`" + " " + sort;
        }
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        TicketExecutionReplaceItem ticketExecutionReplaceItem = new TicketExecutionReplaceItem();
        ticketExecutionReplaceItem.setId(id);
        ticketExecutionReplaceItem.setTicketId(ticketId);
        ticketExecutionReplaceItem.setEquipmentId(equipmentId);
        ticketExecutionReplaceItem.setEquipmentNumber(equipmentNumber);
        ticketExecutionReplaceItem.setEquipmentCode(equipmentCode);
        ticketExecutionReplaceItem.setEquipmentName(equipmentName);
        ticketExecutionReplaceItem.setEquipmentUnit(equipmentUnit);
        ticketExecutionReplaceItem.setEquipmentSpec(equipmentSpec);
        ticketExecutionReplaceItem.setWarehouseId(warehouseId);
        ticketExecutionReplaceItem.setWarehouseName(warehouseName);
        ticketExecutionReplaceItem.setWhWarehouseAreaId(whWarehouseAreaId);
        ticketExecutionReplaceItem.setWhWarehouseAreaName(whWarehouseAreaName);
        ticketExecutionReplaceItem.setWhWarehouseSlotId(whWarehouseSlotId);
        ticketExecutionReplaceItem.setWhWarehouseSlotName(whWarehouseSlotName);

        page.setRecords(queryTicketExecutionReplaceItemService.findTicketExecutionReplaceItemPage(page, ticketExecutionReplaceItem, orderBy));

        return SuccessTip.create(page);
    }

}
