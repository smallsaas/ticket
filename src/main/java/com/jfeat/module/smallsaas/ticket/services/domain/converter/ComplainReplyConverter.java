package com.jfeat.module.smallsaas.ticket.services.domain.converter;

import com.jfeat.module.smallsaas.ticket.api.request.ComplainReplyGenerateRequest;
import com.jfeat.module.smallsaas.ticket.services.domain.command.Complainrecord.ComplainReplyGenerateCommand;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ComplainReplyConverter {
    ComplainReplyConverter COMPLAINRECORD = Mappers.getMapper(ComplainReplyConverter.class);

    ComplainReplyGenerateCommand toCommand(ComplainReplyGenerateRequest request);
}
