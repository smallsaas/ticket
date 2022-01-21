package com.jfeat.module.smallsaas.ticket.api;

import com.jfeat.crud.base.annotation.BusinessLog;
import com.jfeat.crud.base.tips.SuccessTip;
import com.jfeat.crud.base.tips.Tip;
import com.jfeat.module.smallsaas.ticket.api.request.ComplainGenerateRequest;
import com.jfeat.module.smallsaas.ticket.api.request.CreateFeedBackRequest;
import com.jfeat.module.smallsaas.ticket.services.domain.service.ComplainRecordService;
import com.jfeat.module.smallsaas.ticket.services.gen.persistence.model.complainrecord.ComplainRecord;
import com.jfeat.module.smallsaas.ticket.services.gen.persistence.model.complainrecord.ComplainRequestType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static com.jfeat.module.smallsaas.ticket.services.domain.converter.ComplainConverter.COMPLAIN;

@RestController
@Api("反馈API")
@RequestMapping("/api/u/feedback")
public class FeedbackEndpoint {
    @Resource
    private ComplainRecordService complainRecordService;

    @BusinessLog(name = "ComplainRecord", value = "create ComplainRecord")
    @PostMapping
    @ApiOperation(value = "创建反馈记录", response = ComplainRecord.class)
    public Tip createFeedbackRecord(@RequestBody CreateFeedBackRequest request) {
        complainRecordService.createComplain(COMPLAIN.toCommand(request, ComplainRequestType.FEEDBACK.name()));
        return SuccessTip.create();
    }
}
