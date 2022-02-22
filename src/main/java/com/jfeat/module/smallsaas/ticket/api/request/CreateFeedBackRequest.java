package com.jfeat.module.smallsaas.ticket.api.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateFeedBackRequest {
    private String title;
    private String content;
    private String credentialLink;
    private Long complainantId;
}
