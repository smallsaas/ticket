package com.jfeat.am.module.ticket.services.persistence.model;

import java.io.Serializable;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author Code Generator
 * @since 2017-11-07
 */
@TableName("tk_ticket_strategy")
public class TicketStrategy extends Model<TicketStrategy> {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 策略名称
     */
    private String name;
    /**
     * 执行部门ID
     */
    @TableField("execute_department_id")
    private Long executeDepartmentId;
    /**
     * 执行部门
     */
    @TableField("execute_department_name")
    private String executeDepartmentName;
    /**
     * 工单类型
     */
    @TableField("type_id")
    private Long typeId;
    /**
     * 类型名称
     */
    @TableField("type_name")
    private String typeName;
    /**
     * 作业方式
     */
    private String practices;
    /**
     * 检修方式及步骤
     */
    @TableField("practices_step")
    private String practicesStep;
    /**
     * 备注
     */
    private String content;

    @TableField("is_cyclicity")
    private Integer isCyclicity;


    public Long getId() {
        return id;
    }

    public TicketStrategy setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public TicketStrategy setName(String name) {
        this.name = name;
        return this;
    }

    public Long getExecuteDepartmentId() {
        return executeDepartmentId;
    }

    public TicketStrategy setExecuteDepartmentId(Long executeDepartmentId) {
        this.executeDepartmentId = executeDepartmentId;
        return this;
    }

    public String getExecuteDepartmentName() {
        return executeDepartmentName;
    }

    public TicketStrategy setExecuteDepartmentName(String executeDepartmentName) {
        this.executeDepartmentName = executeDepartmentName;
        return this;
    }

    public Long getTypeId() {
        return typeId;
    }

    public TicketStrategy setTypeId(Long typeId) {
        this.typeId = typeId;
        return this;
    }

    public String getTypeName() {
        return typeName;
    }

    public TicketStrategy setTypeName(String typeName) {
        this.typeName = typeName;
        return this;
    }

    public String getPractices() {
        return practices;
    }

    public TicketStrategy setPractices(String practices) {
        this.practices = practices;
        return this;
    }

    public String getPracticesStep() {
        return practicesStep;
    }

    public TicketStrategy setPracticesStep(String practicesStep) {
        this.practicesStep = practicesStep;
        return this;
    }

    public String getContent() {
        return content;
    }

    public TicketStrategy setContent(String content) {
        this.content = content;
        return this;
    }

    public Integer getIsCyclicity() {
        return isCyclicity;
    }

    public void setIsCyclicity(Integer isCyclicity) {
        this.isCyclicity = isCyclicity;
    }

    public static final String ID = "id";

    public static final String NUMBER = "number";

    public static final String NAME = "name";

    public static final String EXECUTE_DEPARTMENT_ID = "execute_department_id";

    public static final String EXECUTE_DEPARTMENT_NAME = "execute_department_name";

    public static final String TYPE_ID = "type_id";

    public static final String TYPE_NAME = "type_name";

    public static final String PRACTICES = "practices";

    public static final String PRACTICES_STEP = "practices_step";

    public static final String CONTENT = "content";

    public static final String IS_CYCLICITY = "is_cyclicity";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TicketStrategy{" +
                "id=" + id +
                ", name=" + name +
                ", executeDepartmentId=" + executeDepartmentId +
                ", executeDepartmentName=" + executeDepartmentName +
                ", typeId=" + typeId +
                ", typeName=" + typeName +
                ", practices=" + practices +
                ", practicesStep=" + practicesStep +
                ", content=" + content +
                ", isCyclicity=" + isCyclicity +
                "}";
    }
}
