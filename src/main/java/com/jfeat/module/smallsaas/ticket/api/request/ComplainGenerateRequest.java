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
@NoArgsConstructor
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
