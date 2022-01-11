package com.jfeat.module.smallsaas.baas-ticket.services.domain.service.impl;
import com.jfeat.module.smallsaas.baas-ticket.services.domain.service.ComplainRecordService;
import com.jfeat.module.smallsaas.baas-ticket.services.gen.crud.service.impl.CRUDComplainRecordServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2017-10-16
 */

@Service("complainRecordService")
public class ComplainRecordServiceImpl extends CRUDComplainRecordServiceImpl implements ComplainRecordService {

    @Override
    protected String entityName() {
        return "ComplainRecord";
    }


                            }
