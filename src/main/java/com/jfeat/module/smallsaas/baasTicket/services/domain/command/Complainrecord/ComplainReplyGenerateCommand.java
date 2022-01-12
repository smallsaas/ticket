package com.jfeat.module.smallsaas.baasTicket.services.domain.command.Complainrecord;

import lombok.Data;

import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;

@Data
public class ComplainReplyGenerateCommand {
    private Long complainRecordId;
    private Long replyerId;
    private String content;

    public ComplainReplyGenerateCommand(Long complainRecordId, Long replyerId, String content) {
        this.complainRecordId = complainRecordId;
        this.replyerId = replyerId;
        this.content = content;

        checkArgument(Objects.nonNull(complainRecordId), "申诉单ID为空");
        checkArgument(Objects.nonNull(replyerId), "回复人为空");
        checkArgument(Objects.nonNull(content), "申诉内容");
    }
}
