package com.jfeat.module.smallsaas.baasTicket.api.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ComplainGenerateRequest {
    private Long relationOrderId;
    private String title;
    private String content;
    private String credentialLink;
    private Long complainantId;
}
