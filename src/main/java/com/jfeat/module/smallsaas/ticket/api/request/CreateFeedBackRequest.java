package com.jfeat.module.smallsaas.ticket.api.request;

import lombok.Data;

@Data
public class CreateFeedBackRequest {
    private String title;
    private String content;
    private String credentialLink;
    private Long complainantId;
}
