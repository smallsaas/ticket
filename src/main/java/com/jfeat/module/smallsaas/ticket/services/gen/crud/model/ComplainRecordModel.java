package com.jfeat.module.smallsaas.ticket.services.gen.crud.model;
// this is serviceModel.java.vm


import com.jfeat.module.nft.oms.services.gen.persistence.model.Player;
import com.jfeat.module.smallsaas.ticket.services.gen.persistence.model.complainrecord.ComplainRecord;

import java.util.List;

/**
 * Created by Code generator on 2022-01-11
 * * slaves.size() : 0
 * * modelpack : $modelpack
 */
public class ComplainRecordModel extends ComplainRecord {
    private List<Player> items;

    public List<Player> getItems() {
        return items;
    }

    public void setItems(List<Player> items) {
        this.items = items;
    }
}
