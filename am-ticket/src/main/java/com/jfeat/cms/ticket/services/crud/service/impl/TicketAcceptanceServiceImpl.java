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
import com.jfeat.cms.ticket.constant.ProgressionStatus;
import com.jfeat.cms.ticket.constant.TicketBusinessExceptionCodeEnum;
import com.jfeat.cms.ticket.services.crud.filter.TicketAcceptanceFilter;
import com.jfeat.cms.ticket.services.crud.service.TicketAcceptanceService;
import com.jfeat.cms.ticket.services.domain.dao.QueryTicketPlanDao;
import com.jfeat.cms.ticket.services.domain.model.TicketAcceptanceModel;
import com.jfeat.cms.ticket.services.persistence.dao.TicketAcceptanceItemMapper;
import com.jfeat.cms.ticket.services.persistence.dao.TicketAcceptanceMapper;
import com.jfeat.cms.ticket.services.persistence.dao.TicketExecutionMapper;
import com.jfeat.cms.ticket.services.persistence.model.TicketAcceptance;
import com.jfeat.cms.ticket.services.persistence.model.TicketAcceptanceItem;
import com.jfeat.cms.ticket.services.persistence.model.TicketExecution;
import com.jfeat.cms.ticket.services.persistence.model.TicketExecutionItem;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * implementation
 * </p>
 *
 * @author Code Generator
 * @since 2017-11-07
 */
@Service
public class TicketAcceptanceServiceImpl extends CRUDServiceOverModelImpl<TicketAcceptance, TicketAcceptanceModel> implements TicketAcceptanceService {


    @Resource
    TicketAcceptanceMapper ticketAcceptanceMapper;
    @Resource
    TicketAcceptanceItemMapper ticketAcceptanceItemMapper;
    @Resource
    TicketExecutionMapper ticketExecutionMapper;
    @Resource
    UserMapper userMapper;
    @Resource
    PoolService poolService;
    @Resource
    TicketAttachmentItemMapper ticketAttachmentItemMapper;

    private static final String ticketAcceptanceItemKeyName = "items";
    private static final String ticketAttachmentItemKeyName = "ticketAttachmentItems";

    // 从表中关联主表的字段名
    private static final String ticketAcceptanceItemFieldName = TicketAcceptanceItem.TICKET_ID;
    private static final String ticketAttachmentItemFieldName = TicketAttachmentItem.TICKET_ID;

    @Override
    protected BaseMapper<TicketAcceptance> getMasterMapper() {
        return ticketAcceptanceMapper;
    }

    @Override
    protected String[] slaveFieldNames() {
        return new String[]{ticketAcceptanceItemKeyName, ticketAttachmentItemKeyName};
    }

    @Override
    protected String[] childFieldNames() {
        return new String[0];
    }

    @Override
    protected FIELD onSlaveFieldItem(String field) {
        if (field.compareTo(ticketAcceptanceItemKeyName) == 0) {
            FIELD _field = new FIELD();

            _field.setItemKeyName(field);
            _field.setItemFieldName(ticketAcceptanceItemFieldName);
            _field.setItemClassName(TicketExecutionItem.class);
            _field.setItemMapper(ticketAcceptanceItemMapper);

            return _field;
        } else if (field.compareTo(ticketAttachmentItemKeyName) == 0) {
            FIELD _field = new FIELD();
            _field.setItemKeyName(field);
            _field.setItemFieldName(ticketAttachmentItemFieldName);
            _field.setItemClassName(TicketAttachmentItem.class);
            _field.setItemMapper(ticketAttachmentItemMapper);
            return _field;
        }
        throw new BusinessException(BizExceptionEnum.OUT_OF_RANGE);
    }

    @Override
    protected FIELD onChildFieldItem(String s) {
        return null;
    }

    @Override
    protected Class<TicketAcceptance> masterClassName() {
        return TicketAcceptance.class;
    }

    @Override
    protected Class<TicketAcceptanceModel> modelClassName() {
        return TicketAcceptanceModel.class;
    }

    @Override
    public Integer addSlaveItem(Long masterId, TicketAcceptanceItem item) {
        item.setTicketId(masterId);
        return ticketAcceptanceItemMapper.insert(item);
    }

    public Long createByExecution(Long applicantId, Long executionId) {
        //validate
        TicketExecution ticketExecution = ticketExecutionMapper.selectById(executionId);
        if (ticketExecution == null) {
            throw new BusinessException(TicketBusinessExceptionCodeEnum.RECORD_NOT_FOUND.getCode(),
                    TicketBusinessExceptionCodeEnum.RECORD_NOT_FOUND.getMessage());
        }
        if (!ProgressionStatus.EXECUTED.equals(ticketExecution.getStatus())) {
            throw new BusinessException(TicketBusinessExceptionCodeEnum.EXECUTION_STATUS_ERROR.getCode(),
                    TicketBusinessExceptionCodeEnum.EXECUTION_STATUS_ERROR.getMessage());
        }
        Integer notClosedTicketAcceptances = ticketAcceptanceMapper.selectCount(
                new EntityWrapper<TicketAcceptance>().eq(TicketAcceptance.EXECUTOR_ID, ticketExecution.getId())
                        .and()
                        .ne(TicketAcceptance.STATUS, ProgressionStatus.CLOSED));
        if (notClosedTicketAcceptances > 0) {
            throw new BusinessException(TicketBusinessExceptionCodeEnum.CREATE_ACCEPTANCE_MORE_THAN_ONE_TIME_ERROR.getCode(),
                    TicketBusinessExceptionCodeEnum.CREATE_ACCEPTANCE_MORE_THAN_ONE_TIME_ERROR.getMessage());
        }

        TicketAcceptance ticketAcceptance = new TicketAcceptance();
        BeanKit.copyProperties(ticketExecution, ticketAcceptance);
        ticketAcceptance.setId(null); //id is not needed to be copied
        ticketAcceptance.setName("AcceptanceOf" + ticketExecution.getName());
        ticketAcceptance.setApplicantId(applicantId);
        ticketAcceptance.setApplicant(userMapper.selectById(applicantId).getName()); //applicant is not the strategy creator
        ticketAcceptance.setNumber(poolService.getSerialNumber("TAC"));
        ticketAcceptance.setExecutionId(executionId);

        ticketAcceptance.setExecutionName(ticketExecution.getName());
        ticketAcceptance.setExecutionNumber(ticketExecution.getNumber());
        ticketAcceptance.setPlanDepartmentId(ticketExecution.getPlanDepartmentId());
        ticketAcceptance.setPlanDepartmentName(ticketExecution.getPlanDepartmentName());
        ticketAcceptance.setExecuteDepartmentId(ticketExecution.getExecuteDepartmentId());
        ticketAcceptance.setExecuteDepartmentName(ticketExecution.getExecuteDepartmentName());
        ticketAcceptance.setLifecycle(ticketExecution.getLifecycle());
        ticketAcceptance.setStrategyId(ticketExecution.getStrategyId());
        ticketAcceptance.setStrategyName(ticketExecution.getStrategyName());
        ticketAcceptance.setTypeId(ticketExecution.getTypeId());
        ticketAcceptance.setTypeName(ticketExecution.getTypeName());
        ticketAcceptance.setPractices(ticketExecution.getPractices());
        ticketAcceptance.setPracticesStep(ticketExecution.getPracticesStep());
        ticketAcceptance.setContent(ticketExecution.getContent());
        ticketAcceptance.setExecuteTime(ticketExecution.getExecuteTime());

        createMaster(ticketAcceptance, new TicketAcceptanceFilter());
        return ticketAcceptance.getId();
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


