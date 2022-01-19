package com.jfeat.module.smallsaas.ticket.services.domain.model;

import com.jfeat.module.smallsaas.ticket.services.gen.persistence.model.complainrecord.ComplainRecord;
import com.jfeat.module.smallsaas.ticket.services.gen.persistence.model.ComplainReplyRecord;
import lombok.Data;

import java.util.List;

@Data
public class ComplainRecordRecord extends ComplainRecord {
   List<ComplainReplyRecord> replyRecordList;
}
