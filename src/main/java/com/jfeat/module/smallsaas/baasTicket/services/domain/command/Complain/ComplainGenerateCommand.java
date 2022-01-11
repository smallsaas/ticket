package com.jfeat.module.smallsaas.baasTicket.services.domain.command.Complain;

import lombok.Data;

import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;

@Data
public class ComplainGenerateCommand {
    private Long complainantId;
    private Long relationOrderId;
    private String title;
    private String content;
    private String credentialLink;

    public ComplainGenerateCommand(Long complainantId,Long relationOrderId, String title, String content, String credentialLink) {
        this.relationOrderId = relationOrderId;
        this.complainantId = complainantId;
        this.content = content;
        this.credentialLink = credentialLink;
        this.title = title;
        checkArgument(Objects.nonNull(relationOrderId), "订单号为空");
        checkArgument(Objects.nonNull(complainantId), "申述人为空");
        checkArgument(Objects.nonNull(title), "标题");
        checkArgument(Objects.nonNull(content), "申诉内容");
    }
}
