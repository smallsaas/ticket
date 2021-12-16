package com.jfeat.am.module.ticket.services.domain.model;

import com.jfeat.am.module.base.services.persistence.model.TicketAttachmentItem;
import com.jfeat.am.module.ticket.services.persistence.model.TicketAcceptance;
import com.jfeat.am.module.ticket.services.persistence.model.TicketAcceptanceItem;

import java.util.List;

/**
 * Created by Code Generator on 2017-11-09
 */
public class TicketAcceptanceModel extends TicketAcceptance {

    public static final String ITEMS_FIELD_NAME = "items";
    public static final String ATTACHMENT_ITEMS_FIELD_NAME = "ticketAttachmentItems";

    private List<TicketAcceptanceItem> items;
    private List<TicketAttachmentItem> ticketAttachmentItems;

    public static String getItemsFieldName() {
        return ITEMS_FIELD_NAME;
    }

    public List<TicketAcceptanceItem> getItems() {
        return items;
    }

    public void setItems(List<TicketAcceptanceItem> items) {
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
