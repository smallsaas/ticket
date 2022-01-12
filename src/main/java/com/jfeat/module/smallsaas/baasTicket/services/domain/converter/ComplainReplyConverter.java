package com.jfeat.module.smallsaas.baasTicket.services.domain.converter;

import com.jfeat.module.smallsaas.baasTicket.api.request.ComplainReplyGenerateRequest;
import com.jfeat.module.smallsaas.baasTicket.services.domain.command.Complainrecord.ComplainReplyGenerateCommand;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ComplainReplyConverter {
    ComplainReplyConverter COMPLAINRECORD = Mappers.getMapper(ComplainReplyConverter.class);

    ComplainReplyGenerateCommand toCommand(ComplainReplyGenerateRequest request);
}
