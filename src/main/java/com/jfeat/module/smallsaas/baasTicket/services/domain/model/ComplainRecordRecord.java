package com.jfeat.module.smallsaas.baasTicket.services.domain.model;

import com.jfeat.module.smallsaas.baasTicket.services.gen.persistence.model.ComplainRecord.ComplainRecord;
import com.jfeat.module.smallsaas.baasTicket.services.gen.persistence.model.ComplainReplyRecord;

import java.util.List;

public class ComplainRecordRecord extends ComplainRecord {
   List<ComplainReplyRecord> replyRecordList;
}
