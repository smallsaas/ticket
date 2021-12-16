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
@TableName("tk_ticket_execution")
public class TicketExecution extends Model<TicketExecution> {

    private static final long serialVersionUID = 1L;

    private Long id;

    @TableField("ticket_plan_used")
    private Integer ticketPlanUsed;
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
     * 执行时间
     */
    @TableField("execute_time")
    private Date executeTime;
    /**
     * 流程实例ID
     */
    @TableField("process_instance_id")
    private Long processInstanceId;
    /**
     * 计划ID
     */
    @TableField("plan_id")
    private Long planId;
    /**
     * 计划单名称
     */
    @TableField("plan_name")
    private String planName;
    /**
     * 计划单号
     */
    @TableField("plan_number")
    private String planNumber;

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

    /**
     * 执行结果
     */
    private String result;
    /**
     * 检修过程
     */
    private String procedure;


    public Long getId() {
        return id;
    }

    public TicketExecution setId(Long id) {
        this.id = id;
        return this;
    }

    public Integer getTicketPlanUsed() {
        return ticketPlanUsed;
    }

    public void setTicketPlanUsed(Integer ticketPlanUsed) {
        this.ticketPlanUsed = ticketPlanUsed;
    }

    public Long getApplicantId() {
        return applicantId;
    }

    public TicketExecution setApplicantId(Long applicantId) {
        this.applicantId = applicantId;
        return this;
    }

    public String getApplicant() {
        return applicant;
    }

    public TicketExecution setApplicant(String applicant) {
        this.applicant = applicant;
        return this;
    }

    public String getNumber() {
        return number;
    }

    public TicketExecution setNumber(String number) {
        this.number = number;
        return this;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public TicketExecution setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public TicketExecution setStatus(String status) {
        this.status = status;
        return this;
    }

    public Long getExecutorId() {
        return executorId;
    }

    public TicketExecution setExecutorId(Long executorId) {
        this.executorId = executorId;
        return this;
    }

    public String getExecutor() {
        return executor;
    }

    public TicketExecution setExecutor(String executor) {
        this.executor = executor;
        return this;
    }

    public Date getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(Date executeTime) {
        this.executeTime = executeTime;
    }

    public Long getProcessInstanceId() {
        return processInstanceId;
    }

    public TicketExecution setProcessInstanceId(Long processInstanceId) {
        this.processInstanceId = processInstanceId;
        return this;
    }

    public Long getStrategyId() {
        return strategyId;
    }

    public TicketExecution setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
        return this;
    }

    public String getStrategyName() {
        return strategyName;
    }

    public TicketExecution setStrategyName(String strategyName) {
        this.strategyName = strategyName;
        return this;
    }

    public String getLifecycle() {
        return lifecycle;
    }

    public TicketExecution setLifecycle(String lifecycle) {
        this.lifecycle = lifecycle;
        return this;
    }

    public String getName() {
        return name;
    }

    public TicketExecution setName(String name) {
        this.name = name;
        return this;
    }

    public Long getPlanDepartmentId() {
        return planDepartmentId;
    }

    public TicketExecution setPlanDepartmentId(Long planDepartmentId) {
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

    public TicketExecution setExecuteDepartmentId(Long executeDepartmentId) {
        this.executeDepartmentId = executeDepartmentId;
        return this;
    }

    public String getExecuteDepartmentName() {
        return executeDepartmentName;
    }

    public TicketExecution setExecuteDepartmentName(String executeDepartmentName) {
        this.executeDepartmentName = executeDepartmentName;
        return this;
    }

    public Long getFaultTicketId() {
        return faultTicketId;
    }

    public TicketExecution setFaultTicketId(Long faultTicketId) {
        this.faultTicketId = faultTicketId;
        return this;
    }

    public String getFaultTicketNumber() {
        return faultTicketNumber;
    }

    public TicketExecution setFaultTicketNumber(String faultTicketNumber) {
        this.faultTicketNumber = faultTicketNumber;
        return this;
    }

    public String getFaultName() {
        return faultName;
    }

    public TicketExecution setFaultName(String faultName) {
        this.faultName = faultName;
        return this;
    }

    public Long getTypeId() {
        return typeId;
    }

    public TicketExecution setTypeId(Long typeId) {
        this.typeId = typeId;
        return this;
    }

    public String getTypeName() {
        return typeName;
    }

    public TicketExecution setTypeName(String typeName) {
        this.typeName = typeName;
        return this;
    }

    public String getPractices() {
        return practices;
    }

    public TicketExecution setPractices(String practices) {
        this.practices = practices;
        return this;
    }

    public String getPracticesStep() {
        return practicesStep;
    }

    public TicketExecution setPracticesStep(String practicesStep) {
        this.practicesStep = practicesStep;
        return this;
    }

    public String getContent() {
        return content;
    }

    public TicketExecution setContent(String content) {
        this.content = content;
        return this;
    }

    public String getResult() {
        return result;
    }

    public TicketExecution setResult(String result) {
        this.result = result;
        return this;
    }

    public String getProcedure() {
        return procedure;
    }

    public TicketExecution setProcedure(String procedure) {
        this.procedure = procedure;
        return this;
    }

    public static final String ID = "id";

    public static final String TICKET_PLAN_USED = "ticket_plan_used";

    public static final String APPLICANT_ID = "applicant_id";

    public static final String APPLICANT = "applicant";

    public static final String NUMBER = "number";

    public static final String APPLY_TIME = "apply_time";

    public static final String STATUS = "status";

    public static final String EXECUTOR_ID = "executor_id";

    public static final String EXECUTOR = "executor";

    public static final String EXECUTE_TIME = "execute_time";

    public static final String PROCESS_INSTANCE_ID = "process_instance_id";

    public static final String PLAN_ID = "plan_id";

    public static final String PLAN_NAME = "plan_name";

    public static final String PLAN_NUMBER = "plan_number";

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

    public static final String RESULT = "result";

    public static final String PROCEDURE = "procedure";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getPlanNumber() {
        return planNumber;
    }

    public void setPlanNumber(String planNumber) {
        this.planNumber = planNumber;
    }

    @Override
    public String toString() {
        return "TicketExecution{" +
                "id=" + id +
                "ticketPlanUsed=" + ticketPlanUsed +
                ", applicantId=" + applicantId +
                ", applicant=" + applicant +
                ", number=" + number +
                ", applyTime=" + applyTime +
                ", status=" + status +
                ", executorId=" + executorId +
                ", executor=" + executor +
                ", executeTime=" + executeTime +
                ", processInstanceId=" + processInstanceId +
                ", planId=" + planId +
                ", planName=" + planName +
                ", planNumber=" + planNumber +
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
                ", result=" + result +
                ", procedure=" + procedure +
                "}";
    }
}
