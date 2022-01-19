package com.jfeat.module.smallsaas.ticket.api.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Builder
@AllArgsConstructor
@Accessors(chain = true)
public class ComplainGenerateRequest {
    private Long relationOrderId;
    private String title;
    private String content;
    private String credentialLink;
    private Long complainantId;
    private String complainantRole;
    private String requestType;
}
