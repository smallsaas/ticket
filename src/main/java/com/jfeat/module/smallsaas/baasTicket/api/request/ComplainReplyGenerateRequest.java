package com.jfeat.module.smallsaas.baasTicket.api.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ComplainReplyGenerateRequest {
    private Long complainRecordId;
    private Long replyerId;
    private String content;
}
