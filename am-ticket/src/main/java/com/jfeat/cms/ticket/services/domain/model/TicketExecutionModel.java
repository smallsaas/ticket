package com.jfeat.cms.ticket.services.domain.model;

import com.jfeat.am.module.base.services.persistence.model.TicketAttachmentItem;
import com.jfeat.cms.ticket.services.persistence.model.TicketExecution;
import com.jfeat.cms.ticket.services.persistence.model.TicketExecutionItem;
import com.jfeat.cms.ticket.services.persistence.model.TicketExecutionReplaceItem;

import java.util.List;

/**
 * Created by Code Generator on 2017-11-09
 */
public class TicketExecutionModel extends TicketExecution {

    public static final String ITEMS_FIELD_NAME = "items";
    public static final String ATTACHMENT_ITEMS_FIELD_NAME = "ticketAttachmentItems";
    public static final String REPLACE_ITEMS_FIELD_NAME = "replaceItems";



    private List<TicketExecutionItem> items;
    private List<TicketAttachmentItem> ticketAttachmentItems;
    private List<TicketExecutionReplaceItem> replaceItems;




    public static String getItemsFieldName() {
        return ITEMS_FIELD_NAME;
    }

    public List<TicketExecutionItem> getItems() {
        return items;
    }

    public void setItems(List<TicketExecutionItem> items) {
        this.items = items;
    }

    public static String getAttachmentItemsFieldName() {
        return ATTACHMENT_ITEMS_FIELD_NAME;
    }

    public List<TicketAttachmentItem> getTicketAttachmentItems() {
        return ticketAttachmentItems;
    }

    public void setTicketAttachmentItems(List<TicketAttachmentItem> ticketAttachmentItems) {
        this.ticketAttachmentItems = ticketAttachmentItems;
    }

    public static String getReplaceItemsFieldName() {
        return REPLACE_ITEMS_FIELD_NAME;
    }

    public List<TicketExecutionReplaceItem> getReplaceItems() {
        return replaceItems;
    }

    public void setReplaceItems(List<TicketExecutionReplaceItem> replaceItems) {
        this.replaceItems = replaceItems;
    }
}
