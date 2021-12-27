package com.jfeat.cms.ticket.constant;

/**
 * Created by kang on 2017/10/20.
 */
public enum TicketBusinessExceptionCodeEnum {

    RECORD_NOT_FOUND(2000, "找不到此记录，请检查ID"),

    NOT_EXECUTE_USER(2001, "您不是执行人，不能执行"),

    STATUS_ERROR(2002, "单据状态异常"),//如不是处于”已审核“状态的单据，被非法地传递了”执行“操作。

    FAULT_TICKET_OF_TICKET_EXECUTION_NOT_FOUND(2003, "此工单关联了一张不存在的故障单"),

    PLAN_STATUS_ERROR(2004, "工单计划未通过审核，不能创建执行单"),

    EXECUTION_STATUS_ERROR(2005,"该执行工单尚未执行，不能创建验收单"),

    CREATE_ACCEPTANCE_MORE_THAN_ONE_TIME_ERROR(2006,"该执行工单已经有对应的验收单，不能重复创建验收单");

    private int friendlyCode;
    private String friendlyMsg;

    private TicketBusinessExceptionCodeEnum(int code, String message) {
        this.friendlyCode = code;
        this.friendlyMsg = message;
    }

    public int getCode() {
        return this.friendlyCode;
    }

    public void setCode(int code) {
        this.friendlyCode = code;
    }

    public String getMessage() {
        return this.friendlyMsg;
    }

    public void setMessage(String message) {
        this.friendlyMsg = message;
    }
}

