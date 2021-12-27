package com.jfeat.cms.ticket.api.crud;
import com.jfeat.am.common.annotation.Permission;
import com.jfeat.cms.ticket.api.permission.TicketPermission;
import com.jfeat.cms.ticket.services.crud.service.TicketAcceptanceItemService;
import com.jfeat.cms.ticket.services.domain.service.QueryTicketAcceptanceItemService;
import com.jfeat.cms.ticket.services.persistence.model.TicketAcceptanceItem;
import com.jfeat.crud.base.annotation.BusinessLog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.jfeat.crud.base.tips.SuccessTip;
import com.jfeat.crud.base.tips.Tip;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * <p>
 *  api
 * </p>
 *
 * @author Code Generator
 * @since 2017-11-09
 */
@RestController
@RequestMapping("/api/ticket/ticket_acceptance_items")
public class TicketAcceptanceItemEndpoint {

    @Resource
    TicketAcceptanceItemService ticketAcceptanceItemService;

    @Resource
    QueryTicketAcceptanceItemService queryTicketAcceptanceItemService;

    /// For debug purpose
    @GetMapping("/empty")
    public Tip getEmptyTicketAcceptanceItem() {
        return SuccessTip.create(new TicketAcceptanceItem());
    }

    @PostMapping
    @Permission(TicketPermission.TICKET_SAVE)
    @BusinessLog(name = "ticketAcceptanceItem", value="create ticketAcceptanceItem")
    public Tip createTicketAcceptanceItem(@RequestBody TicketAcceptanceItem entity) {
        return SuccessTip.create(ticketAcceptanceItemService.createMaster(entity));
    }

    @Permission(TicketPermission.TICKET_VIEW)
    @GetMapping("/{id}")
    public Tip getTicketAcceptanceItem(@PathVariable Long id) {
        return SuccessTip.create(ticketAcceptanceItemService.retrieveMaster(id));
    }

    @Permission(TicketPermission.TICKET_UPDATE)
    @PutMapping("/{id}")
    @BusinessLog(name = "ticketAcceptanceItem", value="update ticketAcceptanceItem")
    public Tip updateTicketAcceptanceItem(@PathVariable Long id, @RequestBody TicketAcceptanceItem entity) {
        return SuccessTip.create(ticketAcceptanceItemService.updateMaster(entity));
    }

    @Permission(TicketPermission.TICKET_ITEMS_DELETE)
    @DeleteMapping("/{id}")
    @BusinessLog(name = "ticketAcceptanceItem", value="delete ticketAcceptanceItem")
    public Tip deleteTicketAcceptanceItem(@PathVariable Long id) {
        return SuccessTip.create(ticketAcceptanceItemService.deleteMaster(id));
    }

    /*@GetMapping
    //此方法可能需要自行添加需要的参数,按需要使用
    public Tip queryTicketAcceptanceItems(Page<TicketAcceptanceItem> page,
                @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                        @RequestParam(name = "id", required = false) Long id,
                                                @RequestParam(name = "ticket_acceptanceId", required = false) Long ticket_acceptanceId,
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
        TicketAcceptanceItem ticketacceptanceitem = new TicketAcceptanceItem();
            ticketacceptanceitem .setId(id);
                ticketacceptanceitem .setTicket_acceptanceId(ticket_acceptanceId);
                ticketacceptanceitem .setEquipmentId(equipmentId);
                ticketacceptanceitem .setEquipmentNumber(equipmentNumber);
                ticketacceptanceitem .setEquipmentCode(equipmentCode);
                ticketacceptanceitem .setEquipmentName(equipmentName);
                ticketacceptanceitem .setEquipmentUnit(equipmentUnit);
                ticketacceptanceitem .setEquipmentSpec(equipmentSpec);
                ticketacceptanceitem .setWarehouseId(warehouseId);
                ticketacceptanceitem .setWarehouseName(warehouseName);
                ticketacceptanceitem .setWh_warehouse_areaId(wh_warehouse_areaId);
                ticketacceptanceitem .setWh_warehouse_areaName(wh_warehouse_areaName);
                ticketacceptanceitem .setWh_warehouse_slotId(wh_warehouse_slotId);
                ticketacceptanceitem .setWh_warehouse_slotName(wh_warehouse_slotName);

        page.setRecords(queryTicketAcceptanceItemService.findTicketAcceptanceItemPage(page, ticketacceptanceitem));

        return SuccessTip.create(page);
    }*/
}
