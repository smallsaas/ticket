package com.jfeat.cms.ticket.constant;

/**
 * Created by Silent-Y on 2017/10/27.
 */
public class ProgressionStatus {

    /**
     * DRAFT，VERIFYING，VERIFIED，CLOSED是流程的状态。流程的状态最终是VERIFIED。
     * EXECUTED，FINISHED不属于流程的状态，VERIFIED状态下进行“执行”操作转换为EXECUTED状态，
     * EXECUTED状态下进行"确认"操作转换为FINISHED状态
     */

    //    草稿
    public static final String DRAFT = "DRAFT";
    //    审核中
    public static final String VERIFYING = "VERIFYING";
    //    审核通过
    public static final String VERIFIED = "VERIFIED";
    //    关闭
    public static final String CLOSED = "CLOSED";
    //    已执行
    public static final String EXECUTED = "EXECUTED";
    //    完成
    public static final String FINISHED = "FINISHED";

}
