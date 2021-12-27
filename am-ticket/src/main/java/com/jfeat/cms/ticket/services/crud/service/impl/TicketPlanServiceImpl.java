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
import com.jfeat.cms.ticket.constant.TicketBusinessExceptionCodeEnum;
import com.jfeat.cms.ticket.services.crud.filter.TicketPlanFilter;
import com.jfeat.cms.ticket.services.crud.service.TicketPlanService;
import com.jfeat.cms.ticket.services.domain.dao.QueryTicketPlanDao;
import com.jfeat.cms.ticket.services.domain.model.TicketPlanModel;
import com.jfeat.am.module.ticket.services.persistence.dao.*;
import com.jfeat.am.module.ticket.services.persistence.model.*;
import com.jfeat.cms.ticket.services.persistence.dao.TicketExecutionMapper;
import com.jfeat.cms.ticket.services.persistence.dao.TicketPlanItemMapper;
import com.jfeat.cms.ticket.services.persistence.dao.TicketPlanMapper;
import com.jfeat.cms.ticket.services.persistence.dao.TicketStrategyMapper;
import com.jfeat.cms.ticket.services.persistence.model.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * implementation
 * </p>
 *
 * @author Code Generator
 * @since 2017-11-07
 */
@Service
public class TicketPlanServiceImpl extends CRUDServiceOverModelImpl<TicketPlan, TicketPlanModel> implements TicketPlanService {


    @Resource
    TicketPlanMapper ticketPlanMapper;
    @Resource
    TicketPlanItemMapper ticketPlanItemMapper;
    @Resource
    TicketStrategyMapper ticketStrategyMapper;
    @Resource
    UserMapper userMapper;
    @Resource
    PoolService poolService;
    @Resource
    TicketAttachmentItemMapper ticketAttachmentItemMapper;

    // 检查工单计划的删除依赖
    @Resource
    TicketExecutionMapper ticketExecutionMapper;


    private static final String ticketPlanItemKeyName = "items";
    private static final String ticketAttachmentItemKeyName = "ticketAttachmentItems";
    // 从表中关联主表的字段名
    private static final String ticketPlanItemItemFieldName = TicketPlanItem.TICKET_ID;
    private static final String ticketAttachmentItemFieldName = TicketAttachmentItem.TICKET_ID;

    @Override
    protected BaseMapper<TicketPlan> getMasterMapper() {
        return ticketPlanMapper;
    }

    @Override
    protected String[] slaveFieldNames() {
        return new String[]{ticketPlanItemKeyName, ticketAttachmentItemKeyName};
    }

    @Override
    protected String[] childFieldNames() {
        return new String[0];
    }

    @Override
    protected FIELD onSlaveFieldItem(String field) {
        if (field.compareTo(ticketPlanItemKeyName) == 0) {
            FIELD _field = new FIELD();

            _field.setItemKeyName(field);
            _field.setItemFieldName(ticketPlanItemItemFieldName);
            _field.setItemClassName(TicketExecutionItem.class);
            _field.setItemMapper(ticketPlanItemMapper);

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
    protected Class<TicketPlan> masterClassName() {
        return TicketPlan.class;
    }

    @Override
    protected Class<TicketPlanModel> modelClassName() {
        return TicketPlanModel.class;
    }

    public Long createByStrategy(Long applicantId, Long strategyId) {
        //validate
        TicketStrategy ticketStrategy = ticketStrategyMapper.selectById(strategyId);
        if (ticketStrategy == null) {
            throw new BusinessException(TicketBusinessExceptionCodeEnum.RECORD_NOT_FOUND.getCode(),
                    TicketBusinessExceptionCodeEnum.RECORD_NOT_FOUND.getMessage());
        }

        TicketPlan ticketPlan = new TicketPlan();

        ticketPlan.setId(null); //id is not needed to be copied
        ticketPlan.setApplicantId(applicantId);
        ticketPlan.setApplicant(userMapper.selectById(applicantId).getName()); //applicant is not the strategy creator
        ticketPlan.setNumber(poolService.getSerialNumber("TPL"));

        ticketPlan.setStrategyId(strategyId);
        ticketPlan.setStrategyName(ticketStrategy.getName());
        ticketPlan.setName("PlanOf" + ticketStrategy.getName());

        ticketPlan.setExecuteDepartmentId(ticketStrategy.getExecuteDepartmentId());
        ticketPlan.setExecuteDepartmentName(ticketStrategy.getExecuteDepartmentName());
        ticketPlan.setPracticesStep(ticketStrategy.getPracticesStep());
        ticketPlan.setPractices(ticketStrategy.getPractices());
        ticketPlan.setTypeId(ticketStrategy.getTypeId());
        ticketPlan.setTypeName(ticketStrategy.getTypeName());
        ticketPlan.setContent(ticketStrategy.getContent());

        createMaster(ticketPlan, new TicketPlanFilter());
        return ticketPlan.getId();
    }


    @Resource
    QueryTicketPlanDao queryTicketPlanDao;

    @Override
    public Integer deleteMaster(long id){
        //1. 判断 是否有子项， 有子项不允许删除
        //TicketPlanItem one = new TicketPlanItem();
        //one.setTicketId(id);
        // comment: 无需判读子项,子项为必填项
        //List<TicketPlanItem> items = ticketPlanItemMapper.selectList(new EntityWrapper<TicketPlanItem>().eq(TicketPlanItem.TICKET_ID, id));
        //if(items!=null && items.size()>0){
        //    throw new BusinessException(BusinessCode.DeleteAssociatedOne.getCode(), "工单计划子项非空，不允许删除");
        //}

        //2. 是否有依赖，已知  工单执行 有工单计划依赖
        List<TicketExecution> executions = ticketExecutionMapper.selectList(new EntityWrapper<TicketExecution>().eq(TicketExecution.PLAN_ID, id));
        if(executions!=null && executions.size()>0){
            TicketExecution te = executions.get(0);
            throw new BusinessException(BusinessCode.DeleteAssociatedOne.getCode(), "工单执行依赖了此计划，不允许删除。工单执行编号="+te.getPlanNumber());
        }

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


