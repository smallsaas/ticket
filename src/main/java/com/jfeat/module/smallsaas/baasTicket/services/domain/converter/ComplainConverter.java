package com.jfeat.module.smallsaas.baasTicket.services.domain.converter;

import com.jfeat.module.smallsaas.baasTicket.api.request.ComplainGenerateRequest;
import com.jfeat.module.smallsaas.baasTicket.services.domain.command.Complain.ComplainGenerateCommand;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ComplainConverter {
    ComplainConverter COMPLAIN = Mappers.getMapper(ComplainConverter.class);

    ComplainGenerateCommand toCommand(ComplainGenerateRequest request);
}
