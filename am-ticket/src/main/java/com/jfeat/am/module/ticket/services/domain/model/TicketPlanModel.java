package com.jfeat.am.module.ticket.services.domain.model;
import com.jfeat.am.module.base.services.persistence.model.TicketAttachmentItem;
import com.jfeat.am.module.ticket.services.persistence.model.TicketPlan;
import com.jfeat.am.module.ticket.services.persistence.model.TicketPlanItem;

import java.util.List;

/**
 * Created by Code Generator on 2017-11-09
 */
public class TicketPlanModel extends TicketPlan{

    public static final String ITEMS_FIELD_NAME = "items";
    public static final String ATTACHMENT_ITEMS_FIELD_NAME = "ticketAttachmentItems";

    private List<TicketPlanItem> items;
    private List<TicketAttachmentItem> ticketAttachmentItems;

    public static String getItemsFieldName() {
        return ITEMS_FIELD_NAME;
    }

    public List<TicketPlanItem> getItems() {
        return items;
    }

    public void setItems(List<TicketPlanItem> items) {
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
}
