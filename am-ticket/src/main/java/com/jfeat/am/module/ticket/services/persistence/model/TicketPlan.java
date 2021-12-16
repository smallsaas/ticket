package com.jfeat.am.module.ticket.services.persistence.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * <p>
 * </p>
 *
 * @author Code Generator
 * @since 2017-11-07
 */
@TableName("tk_ticket_plan")
public class TicketPlan extends Model<TicketPlan> {

    private static final long serialVersionUID = 1L;

    private Long id;
    /**
     * 申请人ID
     */
    @TableField("applicant_id")
    private Long applicantId;
    /**
     * 申请人
     */
    private String applicant;
    /**
     * 单号
     */
    private String number;
    /**
     * 申请时间
     */
    @TableField("apply_time")
    private Date applyTime;
    /**
     * 单据状态
     */
    private String status;
    /**
     * 执行人ID
     */
    @TableField("executor_id")
    private Long executorId;
    /**
     * 执行人
     */
    private String executor;
    /**
     * 计划开始时间
     */
    @TableField("plan_start_time")
    private Date planStartTime;
    /**
     * 计划结束时间
     */
    @TableField("plan_end_time")
    private Date planEndTime;
    /**
     * 流程实例ID
     */
    @TableField("process_instance_id")
    private Long processInstanceId;
    /**
     * 策略ID
     */
    @TableField("strategy_id")
    private Long strategyId;
    /**
     * 策略名称
     */
    @TableField("strategy_name")
    private String strategyName;
    /**
     * 执行周期
     */
    private String lifecycle;
    /**
     * 工单名称
     */
    private String name;
    /**
     * 计划部门ID
     */
    @TableField("plan_department_id")
    private Long planDepartmentId;
    /**
     * )计划部门名称
     */
    @TableField("plan_department_name")
    private String planDepartmentName;
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
     * 故障单ID
     */
    @TableField("fault_ticket_id")
    private Long faultTicketId;
    /**
     * 故障单编号
     */
    @TableField("fault_ticket_number")
    private String faultTicketNumber;
    /**
     * 故障名称
     */
    @TableField("fault_name")
    private String faultName;
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
     * 检修内容
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


    public Long getId() {
        return id;
    }

    public TicketPlan setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getApplicantId() {
        return applicantId;
    }

    public TicketPlan setApplicantId(Long applicantId) {
        this.applicantId = applicantId;
        return this;
    }

    public String getApplicant() {
        return applicant;
    }

    public TicketPlan setApplicant(String applicant) {
        this.applicant = applicant;
        return this;
    }

    public String getNumber() {
        return number;
    }

    public TicketPlan setNumber(String number) {
        this.number = number;
        return this;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public TicketPlan setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public TicketPlan setStatus(String status) {
        this.status = status;
        return this;
    }

    public Long getExecutorId() {
        return executorId;
    }

    public TicketPlan setExecutorId(Long executorId) {
        this.executorId = executorId;
        return this;
    }

    public String getExecutor() {
        return executor;
    }

    public TicketPlan setExecutor(String executor) {
        this.executor = executor;
        return this;
    }

    public Date getPlanStartTime() {
        return planStartTime;
    }

    public void setPlanStartTime(Date planStartTime) {
        this.planStartTime = planStartTime;
    }

    public Date getPlanEndTime() {
        return planEndTime;
    }

    public void setPlanEndTime(Date planEndTime) {
        this.planEndTime = planEndTime;
    }

    public Long getProcessInstanceId() {
        return processInstanceId;
    }

    public TicketPlan setProcessInstanceId(Long processInstanceId) {
        this.processInstanceId = processInstanceId;
        return this;
    }

    public Long getStrategyId() {
        return strategyId;
    }

    public TicketPlan setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
        return this;
    }

    public String getStrategyName() {
        return strategyName;
    }

    public TicketPlan setStrategyName(String strategyName) {
        this.strategyName = strategyName;
        return this;
    }

    public String getLifecycle() {
        return lifecycle;
    }

    public TicketPlan setLifecycle(String lifecycle) {
        this.lifecycle = lifecycle;
        return this;
    }

    public String getName() {
        return name;
    }

    public TicketPlan setName(String name) {
        this.name = name;
        return this;
    }

    public Long getPlanDepartmentId() {
        return planDepartmentId;
    }

    public TicketPlan setPlanDepartmentId(Long planDepartmentId) {
        this.planDepartmentId = planDepartmentId;
        return this;
    }

    public String getPlanDepartmentName() {
        return planDepartmentName;
    }

    public void setPlanDepartmentName(String planDepartmentName) {
        this.planDepartmentName = planDepartmentName;
    }

    public Long getExecuteDepartmentId() {
        return executeDepartmentId;
    }

    public TicketPlan setExecuteDepartmentId(Long executeDepartmentId) {
        this.executeDepartmentId = executeDepartmentId;
        return this;
    }

    public String getExecuteDepartmentName() {
        return executeDepartmentName;
    }

    public TicketPlan setExecuteDepartmentName(String executeDepartmentName) {
        this.executeDepartmentName = executeDepartmentName;
        return this;
    }

    public Long getFaultTicketId() {
        return faultTicketId;
    }

    public TicketPlan setFaultTicketId(Long faultTicketId) {
        this.faultTicketId = faultTicketId;
        return this;
    }

    public String getFaultTicketNumber() {
        return faultTicketNumber;
    }

    public TicketPlan setFaultTicketNumber(String faultTicketNumber) {
        this.faultTicketNumber = faultTicketNumber;
        return this;
    }

    public String getFaultName() {
        return faultName;
    }

    public TicketPlan setFaultName(String faultName) {
        this.faultName = faultName;
        return this;
    }

    public Long getTypeId() {
        return typeId;
    }

    public TicketPlan setTypeId(Long typeId) {
        this.typeId = typeId;
        return this;
    }

    public String getTypeName() {
        return typeName;
    }

    public TicketPlan setTypeName(String typeName) {
        this.typeName = typeName;
        return this;
    }

    public String getPractices() {
        return practices;
    }

    public TicketPlan setPractices(String practices) {
        this.practices = practices;
        return this;
    }

    public String getPracticesStep() {
        return practicesStep;
    }

    public TicketPlan setPracticesStep(String practicesStep) {
        this.practicesStep = practicesStep;
        return this;
    }

    public String getContent() {
        return content;
    }

    public TicketPlan setContent(String content) {
        this.content = content;
        return this;
    }

    public static final String ID = "id";

    public static final String APPLICANT_ID = "applicant_id";

    public static final String APPLICANT = "applicant";

    public static final String NUMBER = "number";

    public static final String APPLY_TIME = "apply_time";

    public static final String STATUS = "status";

    public static final String EXECUTOR_ID = "executor_id";

    public static final String EXECUTOR = "executor";

    public static final String PLAN_START_TIME = "plan_start_time";

    public static final String PLAN_END_TIME = "plan_end_time";

    public static final String PROCESS_INSTANCE_ID = "process_instance_id";

    public static final String STRATEGY_ID = "strategy_id";

    public static final String STRATEGY_NAME = "strategy_name";

    public static final String LIFECYCLE = "lifecycle";

    public static final String NAME = "name";

    public static final String PLAN_DEPARTMENT_ID = "plan_department_id";

    public static final String PLAN_DEPARTMENT_NAME = "plan_department_name";

    public static final String EXECUTE_DEPARTMENT_ID = "execute_department_id";

    public static final String EXECUTE_DEPARTMENT_NAME = "execute_department_name";

    public static final String FAULT_TICKET_ID = "fault_ticket_id";

    public static final String FAULT_TICKET_NUMBER = "fault_ticket_number";

    public static final String FAULT_NAME = "fault_name";

    public static final String TYPE_ID = "type_id";

    public static final String TYPE_NAME = "type_name";

    public static final String PRACTICES = "practices";

    public static final String PRACTICES_STEP = "practices_step";

    public static final String CONTENT = "content";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TicketPlan{" +
                "id=" + id +
                ", applicantId=" + applicantId +
                ", applicant=" + applicant +
                ", number=" + number +
                ", applyTime=" + applyTime +
                ", status=" + status +
                ", executorId=" + executorId +
                ", executor=" + executor +
                ", planStartTime=" + planStartTime +
                ", planEndTime=" + planEndTime +
                ", processInstanceId=" + processInstanceId +
                ", strategyId=" + strategyId +
                ", strategyName=" + strategyName +
                ", lifecycle=" + lifecycle +
                ", name=" + name +
                ", planDepartmentId=" + planDepartmentId +
                ", planDepartmentName=" + planDepartmentName +
                ", executeDepartmentId=" + executeDepartmentId +
                ", executeDepartmentName=" + executeDepartmentName +
                ", faultTicketId=" + faultTicketId +
                ", faultTicketNumber=" + faultTicketNumber +
                ", faultName=" + faultName +
                ", typeId=" + typeId +
                ", typeName=" + typeName +
                ", practices=" + practices +
                ", practicesStep=" + practicesStep +
                ", content=" + content +
                "}";
    }
}
