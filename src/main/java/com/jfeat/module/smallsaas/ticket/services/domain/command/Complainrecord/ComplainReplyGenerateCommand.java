package com.jfeat.module.smallsaas.ticket.services.domain.command.Complainrecord;

import lombok.Data;

import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;

@Data
public class ComplainReplyGenerateCommand {
    private Long complainRecordId;
    private Long replierId;
    private String content;
    private Integer isManagerReply;

    public ComplainReplyGenerateCommand(Long complainRecordId, Long replierId, String content, Integer isManagerReply) {
        checkArgument(Objects.nonNull(complainRecordId), "申诉单ID为空");
        checkArgument(Objects.nonNull(replierId), "回复人为空");
        checkArgument(Objects.nonNull(content), "申诉内容");

        this.complainRecordId = complainRecordId;
        this.replierId = replierId;
        this.content = content;
        this.isManagerReply = Objects.isNull(isManagerReply) ? 0 : isManagerReply;
    }
}
