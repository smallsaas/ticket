package com.jfeat.module.smallsaas.ticket.services.domain.command.complain;

import com.jfeat.module.smallsaas.ticket.services.gen.persistence.model.complainrecord.ComplainRequestType;
import lombok.Data;

import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;

@Data
public class ComplainGenerateCommand {
    private Long complainantId;
    private Long relationOrderId;
    private String title;
    private ComplainRequestType requestType;
    private String content;
    private String credentialLink;
    private String complainantRole;

    public ComplainGenerateCommand(Long complainantId, Long relationOrderId, String title, String content, String credentialLink) {
        this.relationOrderId = relationOrderId;
        this.complainantId = complainantId;
        this.content = content;
        this.credentialLink = credentialLink;
        this.title = title;
        this.requestType = ComplainRequestType.ORDER_DISPUTES;
        checkArgument(Objects.nonNull(relationOrderId), "投诉订单号为空");
        checkArgument(Objects.nonNull(complainantId), "申述人为空");
        checkArgument(Objects.nonNull(title), "标题不可为空");
        checkArgument(Objects.nonNull(content), "申诉内容不可为空");
    }
}
