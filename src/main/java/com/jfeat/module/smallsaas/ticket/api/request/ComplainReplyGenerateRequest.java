package com.jfeat.module.smallsaas.ticket.api.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ComplainReplyGenerateRequest {
    private Long complainRecordId;
    private Long replierId;
    private Integer isManagerReply;
    private String content;
}
