package com.jfeat.cms.ticket.services.crud.filter;

import com.alibaba.fastjson.JSONObject;
import com.jfeat.am.common.crud.CRUDFilter;
import com.jfeat.am.common.crud.CRUDFilterResult;
import com.jfeat.cms.ticket.constant.ProgressionStatus;
import com.jfeat.cms.ticket.services.persistence.model.TicketAcceptance;

import java.util.Date;


/**
 * Created by Code Generator on 2017-11-09
 */
public class TicketAcceptanceFilter implements CRUDFilterResult<TicketAcceptance> {

    private String[] ignoreFields = new String[]{};
    private String[] updateIgnoreFields = new String[]{};

    @Override
    public JSONObject result() {
        return new JSONObject();
    }

    @Override
    public void filter(TicketAcceptance entity, boolean insertOrUpdate) {

        if (insertOrUpdate){
            entity.setStatus(ProgressionStatus.DRAFT);
            entity.setApplyTime(new Date());
        }else {
            if (entity.getId() == null || (!(entity.getId() > 0))) {
                throw new RuntimeException("no primary id provided.");
            }
        }

    }

    @Override
    public String[] ignore(boolean retrieveOrUpdate) {
        //if retrieveOrUpdate is true,means for retrieve ,do this
        if (retrieveOrUpdate){
            return ignoreFields;
            //then retrieveOrUpdate  if false ,means for update,do this
        }else {
            return updateIgnoreFields;
        }
    }
}
