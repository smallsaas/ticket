package com.jfeat.module.smallsaas.ticket.services.domain.converter;

import com.jfeat.module.smallsaas.ticket.api.request.ComplainGenerateRequest;
import com.jfeat.module.smallsaas.ticket.services.domain.command.Complain.ComplainGenerateCommand;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ComplainConverter {
    ComplainConverter COMPLAIN = Mappers.getMapper(ComplainConverter.class);

    ComplainGenerateCommand toCommand(ComplainGenerateRequest request);
}
