package com.jfeat.cms.ticket.services.persistence.model;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

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
@TableName("tk_ticket_acceptance")
public class TicketAcceptance extends Model<TicketAcceptance> {

    private static final long serialVersionUID = 1L;

    private Long id;
    /**
     * 执行工单ID
     */
    @TableField("execution_id")
    private Long executionId;
    /**
     * 执行工单名
     */
    private String executionName;
    /**
     * 执行工单号
     */
    private String executionNumber;
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

    @TableField("inspector_id")
    private Long inspectorId;
    /**
     * )验收人
     */
    @TableField("inspector_name")
    private String inspectorName;
    @TableField("check_department_id")
    private Long checkDepartmentId;
    /**
     * )验收部门名称
     */
    @TableField("check_department_name")
    private String checkDepartmentName;
    /**
     * 验收时间
     */
    @TableField("check_time")
    private Date checkTime;
    /**
     * )验收结果
     */
    private String result;
    /**
     * 备注
     */
    private String note;


    public Long getId() {
        return id;
    }

    public TicketAcceptance setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getExecutionId() {
        return executionId;
    }

    public void setExecutionId(Long executionId) {
        this.executionId = executionId;
    }

    public String getExecutionName() {
        return executionName;
    }

    public void setExecutionName(String executionName) {
        this.executionName = executionName;
    }

    public String getExecutionNumber() {
        return executionNumber;
    }

    public void setExecutionNumber(String executionNumber) {
        this.executionNumber = executionNumber;
    }

    public Long getApplicantId() {
        return applicantId;
    }

    public TicketAcceptance setApplicantId(Long applicantId) {
        this.applicantId = applicantId;
        return this;
    }

    public String getApplicant() {
        return applicant;
    }

    public TicketAcceptance setApplicant(String applicant) {
        this.applicant = applicant;
        return this;
    }

    public String getNumber() {
        return number;
    }

    public TicketAcceptance setNumber(String number) {
        this.number = number;
        return this;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public TicketAcceptance setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public TicketAcceptance setStatus(String status) {
        this.status = status;
        return this;
    }

    public Long getExecutorId() {
        return executorId;
    }

    public TicketAcceptance setExecutorId(Long executorId) {
        this.executorId = executorId;
        return this;
    }

    public String getExecutor() {
        return executor;
    }

    public TicketAcceptance setExecutor(String executor) {
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

    public TicketAcceptance setProcessInstanceId(Long processInstanceId) {
        this.processInstanceId = processInstanceId;
        return this;
    }

    public Long getStrategyId() {
        return strategyId;
    }

    public TicketAcceptance setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
        return this;
    }

    public String getStrategyName() {
        return strategyName;
    }

    public TicketAcceptance setStrategyName(String strategyName) {
        this.strategyName = strategyName;
        return this;
    }

    public String getLifecycle() {
        return lifecycle;
    }

    public TicketAcceptance setLifecycle(String lifecycle) {
        this.lifecycle = lifecycle;
        return this;
    }

    public String getName() {
        return name;
    }

    public TicketAcceptance setName(String name) {
        this.name = name;
        return this;
    }

    public Long getPlanDepartmentId() {
        return planDepartmentId;
    }

    public TicketAcceptance setPlanDepartmentId(Long planDepartmentId) {
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

    public TicketAcceptance setExecuteDepartmentId(Long executeDepartmentId) {
        this.executeDepartmentId = executeDepartmentId;
        return this;
    }

    public String getExecuteDepartmentName() {
        return executeDepartmentName;
    }

    public TicketAcceptance setExecuteDepartmentName(String executeDepartmentName) {
        this.executeDepartmentName = executeDepartmentName;
        return this;
    }

    public Long getFaultTicketId() {
        return faultTicketId;
    }

    public TicketAcceptance setFaultTicketId(Long faultTicketId) {
        this.faultTicketId = faultTicketId;
        return this;
    }

    public String getFaultTicketNumber() {
        return faultTicketNumber;
    }

    public void setFaultTicketNumber(String faultTicketNumber) {
        this.faultTicketNumber = faultTicketNumber;
    }

    public String getFaultName() {
        return faultName;
    }

    public TicketAcceptance setFaultName(String faultName) {
        this.faultName = faultName;
        return this;
    }

    public Long getTypeId() {
        return typeId;
    }

    public TicketAcceptance setTypeId(Long typeId) {
        this.typeId = typeId;
        return this;
    }

    public String getTypeName() {
        return typeName;
    }

    public TicketAcceptance setTypeName(String typeName) {
        this.typeName = typeName;
        return this;
    }

    public String getPractices() {
        return practices;
    }

    public TicketAcceptance setPractices(String practices) {
        this.practices = practices;
        return this;
    }

    public String getPracticesStep() {
        return practicesStep;
    }

    public TicketAcceptance setPracticesStep(String practicesStep) {
        this.practicesStep = practicesStep;
        return this;
    }

    public String getContent() {
        return content;
    }

    public TicketAcceptance setContent(String content) {
        this.content = content;
        return this;
    }

    public Long getInspectorId() {
        return inspectorId;
    }

    public TicketAcceptance setInspectorId(Long inspectorId) {
        this.inspectorId = inspectorId;
        return this;
    }

    public String getInspectorName() {
        return inspectorName;
    }

    public TicketAcceptance setInspectorName(String inspectorName) {
        this.inspectorName = inspectorName;
        return this;
    }

    public Long getCheckDepartmentId() {
        return checkDepartmentId;
    }

    public TicketAcceptance setCheckDepartmentId(Long checkDepartmentId) {
        this.checkDepartmentId = checkDepartmentId;
        return this;
    }

    public String getCheckDepartmentName() {
        return checkDepartmentName;
    }

    public TicketAcceptance setCheckDepartmentName(String checkDepartmentName) {
        this.checkDepartmentName = checkDepartmentName;
        return this;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public TicketAcceptance setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
        return this;
    }

    public String getResult() {
        return result;
    }

    public TicketAcceptance setResult(String result) {
        this.result = result;
        return this;
    }

    public String getNote() {
        return note;
    }

    public TicketAcceptance setNote(String note) {
        this.note = note;
        return this;
    }

    public static final String ID = "id";

    public static final String APPLICANT_ID = "applicant_id";

    public static final String APPLICANT = "applicant";

    public static final String EXECUTION_ID = "execution_id";

    public static final String EXECUTION_NAME = "execution_name";

    public static final String EXECUTION_NUMBER = "execution_number";

    public static final String NUMBER = "number";

    public static final String APPLY_TIME = "apply_time";

    public static final String STATUS = "status";

    public static final String EXECUTOR_ID = "executor_id";

    public static final String EXECUTOR = "executor";

    public static final String EXECUTE_TIME = "execute_time";

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

    public static final String FAULT_NAME = "fault_name";

    public static final String TYPE_ID = "type_id";

    public static final String TYPE_NAME = "type_name";

    public static final String PRACTICES = "practices";

    public static final String PRACTICES_STEP = "practices_step";

    public static final String CONTENT = "content";

    public static final String INSPECTOR_ID = "inspector_id";

    public static final String INSPECTOR_NAME = "inspector_name";

    public static final String CHECK_DEPARTMENT_ID = "check_department_id";

    public static final String CHECK_DEPARTMENT_NAME = "check_department_name";

    public static final String CHECK_TIME = "check_time";

    public static final String RESULT = "result";

    public static final String NOTE = "note";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TicketAcceptance{" +
                "id=" + id +
                ", executionId=" + executionId +
                ", executionName=" + executionName +
                ", executionNumber=" + executionNumber +
                ", applicantId=" + applicantId +
                ", applicant=" + applicant +

                ", number=" + number +
                ", applyTime=" + applyTime +
                ", status=" + status +
                ", executorId=" + executorId +
                ", executor=" + executor +
                ", executeTime=" + executeTime +
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
                ", inspectorId=" + inspectorId +
                ", inspectorName=" + inspectorName +
                ", checkDepartmentId=" + checkDepartmentId +
                ", checkDepartmentName=" + checkDepartmentName +
                ", checkTime=" + checkTime +
                ", result=" + result +
                ", note=" + note +
                "}";
    }
}
