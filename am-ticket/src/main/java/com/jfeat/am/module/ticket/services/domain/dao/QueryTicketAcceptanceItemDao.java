package com.jfeat.am.module.ticket.services.domain.dao;

import com.jfeat.am.module.ticket.services.persistence.model.TicketAcceptanceItem;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * Created by Code Generator on 2017-11-09
 */
public interface QueryTicketAcceptanceItemDao extends BaseMapper<TicketAcceptanceItem> {
    List<TicketAcceptanceItem> findTicketAcceptanceItemPage(Page<TicketAcceptanceItem> page,TicketAcceptanceItem ticketacceptanceitem);
}