package com.jfeat.cms.ticket.services.crud.filter;

import com.jfeat.am.common.crud.CRUDFilter;
import com.jfeat.cms.ticket.services.persistence.model.TicketExecutionItem;


/**
 * Created by Code Generator on 2017-11-09
 */
public class TicketExecutionItemFilter implements CRUDFilter<TicketExecutionItem> {

    private String[] ignoreFields = new String[]{};
    private String[] updateIgnoreFields = new String[]{};

    @Override
    public void filter(TicketExecutionItem entity, boolean insertOrUpdate) {

        //if insertOrUpdate is true,means for insert, do this
        if (insertOrUpdate){

            //then insertOrUpdate is false,means for update,do this
        }else {

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
