package com.jfeat.cms.ticket.services.persistence.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * <p>
 *
 * </p>
 *
 * @author Code Generator
 * @since 2018-03-01
 */
@TableName("tk_ticket_execution_replace_item")
public class TicketExecutionReplaceItem extends Model<TicketExecutionReplaceItem> {

    private static final long serialVersionUID = 1L;

    private Long id;
    @TableField("ticket_id")
    private Long ticketId;
    @TableField("equipment_id")
    private Long equipmentId;
    /**
     * 模版编码
     */
    @TableField("equipment_number")
    private String equipmentNumber;
    /**
     * 设备编码
     */
    @TableField("equipment_code")
    private String equipmentCode;
    /**
     * 设备名称
     */
    @TableField("equipment_name")
    private String equipmentName;
    /**
     * 计量单位
     */
    @TableField("equipment_unit")
    private String equipmentUnit;
    /**
     * 规格型号
     */
    @TableField("equipment_spec")
    private String equipmentSpec;
    /**
     * 仓库ID
     */
    @TableField("warehouse_id")
    private Long warehouseId;
    /**
     * 仓库
     */
    @TableField("warehouse_name")
    private String warehouseName;
    /**
     * 库区ID
     */
    @TableField("wh_warehouse_area_id")
    private Long whWarehouseAreaId;
    /**
     * 库区
     */
    @TableField("wh_warehouse_area_name")
    private String whWarehouseAreaName;
    /**
     * 储位ID
     */
    @TableField("wh_warehouse_slot_id")
    private Long whWarehouseSlotId;
    /**
     * 储位
     */
    @TableField("wh_warehouse_slot_name")
    private String whWarehouseSlotName;


    @TableField("index_num")
    private Integer indexNum;

    public Integer getIndexNum() {
        return indexNum;
    }

    public void setIndexNum(Integer indexNum) {
        this.indexNum = indexNum;
    }

    public Long getId() {
        return id;
    }

    public TicketExecutionReplaceItem setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public TicketExecutionReplaceItem setTicketId(Long ticketId) {
        this.ticketId = ticketId;
        return this;
    }

    public Long getEquipmentId() {
        return equipmentId;
    }

    public TicketExecutionReplaceItem setEquipmentId(Long equipmentId) {
        this.equipmentId = equipmentId;
        return this;
    }

    public String getEquipmentNumber() {
        return equipmentNumber;
    }

    public TicketExecutionReplaceItem setEquipmentNumber(String equipmentNumber) {
        this.equipmentNumber = equipmentNumber;
        return this;
    }

    public String getEquipmentCode() {
        return equipmentCode;
    }

    public TicketExecutionReplaceItem setEquipmentCode(String equipmentCode) {
        this.equipmentCode = equipmentCode;
        return this;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public TicketExecutionReplaceItem setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
        return this;
    }

    public String getEquipmentUnit() {
        return equipmentUnit;
    }

    public TicketExecutionReplaceItem setEquipmentUnit(String equipmentUnit) {
        this.equipmentUnit = equipmentUnit;
        return this;
    }

    public String getEquipmentSpec() {
        return equipmentSpec;
    }

    public TicketExecutionReplaceItem setEquipmentSpec(String equipmentSpec) {
        this.equipmentSpec = equipmentSpec;
        return this;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public TicketExecutionReplaceItem setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
        return this;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public TicketExecutionReplaceItem setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
        return this;
    }

    public Long getWhWarehouseAreaId() {
        return whWarehouseAreaId;
    }

    public TicketExecutionReplaceItem setWhWarehouseAreaId(Long whWarehouseAreaId) {
        this.whWarehouseAreaId = whWarehouseAreaId;
        return this;
    }

    public String getWhWarehouseAreaName() {
        return whWarehouseAreaName;
    }

    public TicketExecutionReplaceItem setWhWarehouseAreaName(String whWarehouseAreaName) {
        this.whWarehouseAreaName = whWarehouseAreaName;
        return this;
    }

    public Long getWhWarehouseSlotId() {
        return whWarehouseSlotId;
    }

    public TicketExecutionReplaceItem setWhWarehouseSlotId(Long whWarehouseSlotId) {
        this.whWarehouseSlotId = whWarehouseSlotId;
        return this;
    }

    public String getWhWarehouseSlotName() {
        return whWarehouseSlotName;
    }

    public TicketExecutionReplaceItem setWhWarehouseSlotName(String whWarehouseSlotName) {
        this.whWarehouseSlotName = whWarehouseSlotName;
        return this;
    }

    public static final String ID = "id";

    public static final String TICKET_ID = "ticket_id";

    public static final String EQUIPMENT_ID = "equipment_id";

    public static final String EQUIPMENT_NUMBER = "equipment_number";

    public static final String EQUIPMENT_CODE = "equipment_code";

    public static final String EQUIPMENT_NAME = "equipment_name";

    public static final String EQUIPMENT_UNIT = "equipment_unit";

    public static final String EQUIPMENT_SPEC = "equipment_spec";

    public static final String WAREHOUSE_ID = "warehouse_id";

    public static final String WAREHOUSE_NAME = "warehouse_name";

    public static final String WH_WAREHOUSE_AREA_ID = "wh_warehouse_area_id";

    public static final String WH_WAREHOUSE_AREA_NAME = "wh_warehouse_area_name";

    public static final String WH_WAREHOUSE_SLOT_ID = "wh_warehouse_slot_id";

    public static final String WH_WAREHOUSE_SLOT_NAME = "wh_warehouse_slot_name";
    public static final String INDEX_NUM = "index_num";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TicketExecutionReplaceItem{" +
                "id=" + id +
                ", ticketId=" + ticketId +
                ", equipmentId=" + equipmentId +
                ", equipmentNumber=" + equipmentNumber +
                ", equipmentCode=" + equipmentCode +
                ", equipmentName=" + equipmentName +
                ", equipmentUnit=" + equipmentUnit +
                ", equipmentSpec=" + equipmentSpec +
                ", warehouseId=" + warehouseId +
                ", warehouseName=" + warehouseName +
                ", whWarehouseAreaId=" + whWarehouseAreaId +
                ", whWarehouseAreaName=" + whWarehouseAreaName +
                ", whWarehouseSlotId=" + whWarehouseSlotId +
                ", whWarehouseSlotName=" + whWarehouseSlotName +
                ", indexNum=" + indexNum +

                "}";
    }
}
