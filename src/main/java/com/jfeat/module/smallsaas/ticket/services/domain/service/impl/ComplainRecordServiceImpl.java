package com.jfeat.module.smallsaas.ticket.services.domain.service.impl;

import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import com.jfeat.module.smallsaas.ticket.services.domain.command.complain.ComplainGenerateCommand;
import com.jfeat.module.smallsaas.ticket.services.domain.dao.QueryComplainRecordDao;
import com.jfeat.module.smallsaas.ticket.services.domain.service.ComplainRecordService;
import com.jfeat.module.smallsaas.ticket.services.gen.crud.service.impl.CRUDComplainRecordServiceImpl;
import com.jfeat.module.smallsaas.ticket.services.gen.persistence.model.complainrecord.ComplainRecord;
import com.jfeat.module.smallsaas.ticket.services.gen.persistence.model.complainrecord.ComplainRecordStatus;
import com.jfeat.module.smallsaas.ticket.services.gen.persistence.model.complainrecord.ComplainRequestType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;
/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author admin
 * @since 2017-10-16
 */

@Service("complainRecordService")
public class ComplainRecordServiceImpl extends CRUDComplainRecordServiceImpl implements ComplainRecordService {

    @Resource
    private QueryComplainRecordDao queryComplainRecordDao;

    @Override
    protected String entityName() {
        return "ComplainRecord";
    }


    @Override
    public void createComplain(ComplainGenerateCommand command) {

        if(command.getRequestType().equals(ComplainRequestType.ORDER_DISPUTES)){
            updateOrderStatus(command.getRelationOrderId(),"COMPLAINING");
        }

        this.createMaster(ComplainRecord.builder()
                .complainantId(command.getComplainantId())
                .relationOrderId(command.getRelationOrderId())
                .title(command.getTitle())
                .requestType(command.getRequestType())
                .content(command.getContent())
                .credentialLink(command.getCredentialLink())
                .complainantRole(command.getComplainantRole())
                .status(ComplainRecordStatus.PENDING_REPLY).build());
    }

    @Override
    public void complainEnd(Long complainId,Long complainantId) {
        var complain= Optional.ofNullable(this.getMasterMapper().selectById(complainId))
                .orElseThrow(() -> {
                            return new BusinessException(BusinessCode.BadRequest, String.format("当前申诉单号[ID:%s]查询不到对应的申诉单信息", complainId));
                        });
        if (complainantId.equals(complain.getComplainantId())){
            complain.setStatus(ComplainRecordStatus.COMPLETED);
            this.updateMaster(complain);
            updateOrderStatus(complain.getRelationOrderId(),"PAID");
        }else{
             new BusinessException(BusinessCode.BadRequest, String.format("您不是申诉单号[ID:%s]的申诉人无法改变申诉单状态", complainId));
        }
    }

    private void updateOrderStatus(Long orderId,String orderStatus) {
        if (OrderExist(orderId))
            queryComplainRecordDao.changOrderStatus(orderId,orderStatus);
        else
            new BusinessException(BusinessCode.BadRequest,String.format("相关订单[id:%s]不存在",orderId));
    }

    private boolean OrderExist(Long complainId){
        return queryComplainRecordDao.OrderExist(complainId)==1;
    }
}
