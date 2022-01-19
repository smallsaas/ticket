
package com.jfeat.module.smallsaas.ticket.api;


import com.jfeat.crud.base.annotation.BusinessLog;
import com.jfeat.crud.base.tips.SuccessTip;
import com.jfeat.crud.base.tips.Tip;
import com.jfeat.module.smallsaas.ticket.api.request.ComplainReplyGenerateRequest;
import com.jfeat.module.smallsaas.ticket.services.domain.service.ComplainReplyRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static com.jfeat.module.smallsaas.ticket.services.domain.converter.ComplainReplyConverter.COMPLAINRECORD;

@RestController
@Api("ComplainReplyRecord")
@RequestMapping("/api/u/complain/reply")
public class ComplainReplyRecordEndpoint {

    @Resource
    ComplainReplyRecordService complainReplyRecordService;

    @PostMapping
    @BusinessLog(name = "申诉回复", value = "reply")
    @ApiOperation(value = "申诉回复")
    public Tip createComplainReply(@RequestBody ComplainReplyGenerateRequest request) {
        complainReplyRecordService.reply(COMPLAINRECORD.toCommand(request));
        return SuccessTip.create();
    }
}

