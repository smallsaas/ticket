package com.jfeat.cms.ticket.services.crud.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.jfeat.am.common.crud.FIELD;
import com.jfeat.am.common.crud.impl.CRUDServiceOverModelImpl;
import com.jfeat.am.common.exception.BizExceptionEnum;
import com.jfeat.am.common.exception.BusinessCode;
import com.jfeat.am.common.exception.BusinessException;
import com.jfeat.am.common.persistence.dao.UserMapper;
import com.jfeat.am.core.support.BeanKit;
import com.jfeat.am.module.NumberGenerator.services.crud.service.PoolService;
import com.jfeat.am.module.base.services.persistence.mapper.TicketAttachmentItemMapper;
import com.jfeat.am.module.base.services.persistence.model.TicketAttachmentItem;
import com.jfeat.am.module.fault.services.crud.service.TicketService;
import com.jfeat.am.module.fault.services.persistence.dao.TicketMapper;
import com.jfeat.cms.ticket.constant.ProgressionStatus;
import com.jfeat.cms.ticket.constant.TicketBusinessExceptionCodeEnum;
import com.jfeat.cms.ticket.services.crud.filter.TicketExecutionFilter;
import com.jfeat.cms.ticket.services.crud.service.TicketExecutionService;
import com.jfeat.cms.ticket.services.domain.dao.QueryTicketPlanDao;
import com.jfeat.cms.ticket.services.domain.model.TicketExecutionModel;
import com.jfeat.cms.ticket.services.persistence.dao.TicketExecutionItemMapper;
import com.jfeat.cms.ticket.services.persistence.dao.TicketExecutionMapper;
import com.jfeat.cms.ticket.services.persistence.dao.TicketExecutionReplaceItemMapper;
import com.jfeat.cms.ticket.services.persistence.dao.TicketPlanMapper;
import com.jfeat.cms.ticket.services.persistence.model.TicketExecution;
import com.jfeat.cms.ticket.services.persistence.model.TicketExecutionItem;
import com.jfeat.cms.ticket.services.persistence.model.TicketExecutionReplaceItem;
import com.jfeat.cms.ticket.services.persistence.model.TicketPlan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * <p>
 * implementation
 * </p>
 *
 * @author Code Generator
 * @since 2017-11-07
 */
@Service
public class TicketExecutionServiceImpl extends CRUDServiceOverModelImpl<TicketExecution, TicketExecutionModel>
        implements TicketExecutionService {


    @Resource
    TicketExecutionMapper ticketExecutionMapper;
    @Resource
    TicketExecutionItemMapper ticketExecutionItemMapper;
    @Resource
    TicketPlanMapper ticketPlanMapper;
    @Resource
    UserMapper userMapper;
    @Resource
    TicketService ticketService;
    @Resource
    PoolService poolService;
    @Resource
    TicketAttachmentItemMapper ticketAttachmentItemMapper;
    @Resource
    TicketExecutionReplaceItemMapper ticketExecutionReplaceItemMapper;
    //@Resource
    //TicketMapper ticketMapper;

    private static final String ticketExecutionItemKeyName = "items";
    private static final String ticketAttachmentItemKeyName = "ticketAttachmentItems";
    private static final String ticketExecutionReplaceItemKeyName = "replaceItems";

    // 从表中关联主表的字段名
    private static final String ticketExecutionItemFieldName = TicketExecutionItem.TICKET_ID;
    private static final String ticketAttachmentItemFieldName = TicketAttachmentItem.TICKET_ID;
    private static final String ticketExecutionReplaceItemFieldName = TicketExecutionReplaceItem.TICKET_ID;

    private final static Logger logger = LoggerFactory.getLogger(TicketExecutionServiceImpl.class);


    @Override
    protected BaseMapper<TicketExecution> getMasterMapper() {
        return ticketExecutionMapper;
    }

    @Override
    protected String[] slaveFieldNames() {
        return new String[]{ticketExecutionItemKeyName, ticketAttachmentItemKeyName, ticketExecutionReplaceItemKeyName};
    }

    @Override
    protected String[] childFieldNames() {
        return new String[0];
    }

    @Override
    protected FIELD onSlaveFieldItem(String field) {
        if (field.compareTo(ticketExecutionItemKeyName) == 0) {
            FIELD _field = new FIELD();

            _field.setItemKeyName(field);
            _field.setItemFieldName(ticketExecutionItemFieldName);
            _field.setItemClassName(TicketExecutionItem.class);
            _field.setItemMapper(ticketExecutionItemMapper);

            return _field;
        } else if (field.compareTo(ticketAttachmentItemKeyName) == 0) {
            FIELD _field = new FIELD();
            _field.setItemKeyName(field);
            _field.setItemFieldName(ticketAttachmentItemFieldName);
            _field.setItemClassName(TicketAttachmentItem.class);
            _field.setItemMapper(ticketAttachmentItemMapper);
            return _field;
        } else if (field.compareTo(ticketExecutionReplaceItemKeyName) == 0) {
            FIELD _field = new FIELD();
            _field.setItemKeyName(field);
            _field.setItemFieldName(ticketExecutionReplaceItemFieldName);
            _field.setItemClassName(TicketExecutionReplaceItem.class);
            _field.setItemMapper(ticketExecutionReplaceItemMapper);
            return _field;
        }
        throw new BusinessException(BizExceptionEnum.OUT_OF_RANGE);
    }

    @Override
    protected FIELD onChildFieldItem(String s) {
        return null;
    }

    @Override
    protected Class<TicketExecution> masterClassName() {
        return TicketExecution.class;
    }

    @Override
    protected Class<TicketExecutionModel> modelClassName() {
        return TicketExecutionModel.class;
    }

    private void validateExecute(Long userId, TicketExecution order) {
        logger.debug("TicketExecution={}", order);
        if (order == null) {
            throw new BusinessException(TicketBusinessExceptionCodeEnum.RECORD_NOT_FOUND.getCode(),
                    TicketBusinessExceptionCodeEnum.RECORD_NOT_FOUND.getMessage());
        }
        if (order.getExecutorId() == null || !order.getExecutorId().equals(userId)) {
            throw new BusinessException(TicketBusinessExceptionCodeEnum.NOT_EXECUTE_USER.getCode(),
                    TicketBusinessExceptionCodeEnum.NOT_EXECUTE_USER.getMessage());
        }
        if (!order.getStatus().equals(ProgressionStatus.VERIFIED)) {
            throw new BusinessException(TicketBusinessExceptionCodeEnum.STATUS_ERROR.getCode(),
                    TicketBusinessExceptionCodeEnum.STATUS_ERROR.getMessage());
        }
    }

    public Integer executeOrder(Long userId, Long id) {
        logger.debug("executing TicketExecution, userId = {}, id = {}", userId, id);
        TicketExecution order = ticketExecutionMapper.selectById(id);
        validateExecute(userId, order);

        Integer affected = 0;

        if (order.getTicketPlanUsed() == 1) { //执行单关联了计划单
            TicketPlan ticketPlanOrder = ticketPlanMapper.selectById(order.getPlanId());
            if (ticketPlanOrder != null) {
                if (ticketPlanOrder.getFaultName() != null) {
                    affected += ticketService.executeOrder(userId, ticketPlanOrder.getFaultTicketId());
                }
                ticketPlanOrder.setStatus(ProgressionStatus.EXECUTED);
                affected += ticketPlanMapper.updateAllColumnById(ticketPlanOrder);
            }
        } else { //执行单关联了故障单
            affected += ticketService.executeOrder(userId, order.getFaultTicketId());
        }

        //update the status of the order

        order.setStatus(ProgressionStatus.EXECUTED);
        order.setExecuteTime(new Date());
        affected += ticketExecutionMapper.updateById(order);

        return affected;
    }

    public Long createByPlan(Long applicantId, Long planId) {
        //validate
        TicketPlan ticketPlan = ticketPlanMapper.selectById(planId);
        if (ticketPlan == null) {
            throw new BusinessException(TicketBusinessExceptionCodeEnum.RECORD_NOT_FOUND.getCode(),
                    TicketBusinessExceptionCodeEnum.RECORD_NOT_FOUND.getMessage());
        }
        if (!ProgressionStatus.VERIFIED.equals(ticketPlan.getStatus())) {
            throw new BusinessException(TicketBusinessExceptionCodeEnum.PLAN_STATUS_ERROR.getCode(),
                    TicketBusinessExceptionCodeEnum.PLAN_STATUS_ERROR.getMessage());
        }

        TicketExecution ticketExecution = new TicketExecution();
        BeanKit.copyProperties(ticketPlan, ticketExecution);
        ticketExecution.setId(null); //id is not needed to be copied
        ticketExecution.setName("ExecutionOf" + ticketPlan.getName());
        ticketExecution.setApplicantId(applicantId);
        ticketExecution.setApplicant(userMapper.selectById(applicantId).getName()); //applicant is not the strategy creator
        ticketExecution.setNumber(poolService.getSerialNumber("TEX"));
        ticketExecution.setPlanId(ticketPlan.getId());
        ticketExecution.setPlanName(ticketPlan.getName());

        ticketExecution.setPlanNumber(ticketPlan.getNumber());
        ticketExecution.setLifecycle(ticketPlan.getLifecycle());
        ticketExecution.setStrategyId(ticketPlan.getStrategyId());
        ticketExecution.setStrategyName(ticketPlan.getStrategyName());
        ticketExecution.setPlanDepartmentId(ticketPlan.getPlanDepartmentId());
        ticketExecution.setPlanDepartmentName(ticketPlan.getPlanDepartmentName());
        ticketExecution.setExecuteDepartmentId(ticketPlan.getExecuteDepartmentId());
        ticketExecution.setExecuteDepartmentName(ticketPlan.getExecuteDepartmentName());
        ticketExecution.setTypeId(ticketPlan.getTypeId());
        ticketExecution.setTypeName(ticketPlan.getTypeName());
        ticketExecution.setPractices(ticketPlan.getPractices());
        ticketExecution.setPracticesStep(ticketPlan.getPracticesStep());

        createMaster(ticketExecution, new TicketExecutionFilter());
        return ticketExecution.getId();
    }

    @Resource
    QueryTicketPlanDao queryTicketPlanDao;

    @Override
    public Integer deleteMaster(long id){
        //3. 检查审核是否有依赖 history, instance
        if(queryTicketPlanDao.checkProcessInstanceAssociated(id)>0){
            throw new BusinessException(BusinessCode.DeleteAssociatedOne.getCode(), "存在流程审核依赖，不允许删除");
        }
        if(queryTicketPlanDao.checkProcessHistoryAssociated(id)>0){
            throw new BusinessException(BusinessCode.DeleteAssociatedOne.getCode(), "存在流程审核历史依赖，不允许删除");
        }

        return super.deleteMaster(id);
    }
}


