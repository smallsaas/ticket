
package com.jfeat.module.smallsaas.baasTicket.api;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.am.common.annotation.Permission;
import com.jfeat.crud.base.annotation.BusinessLog;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import com.jfeat.crud.base.tips.SuccessTip;
import com.jfeat.crud.base.tips.Tip;
import com.jfeat.module.smallsaas.baasTicket.api.permission.ComplainReplyRecordPermission;
import com.jfeat.module.smallsaas.baasTicket.api.request.ComplainReplyGenerateRequest;
import com.jfeat.module.smallsaas.baasTicket.services.domain.dao.QueryComplainReplyRecordDao;
import com.jfeat.module.smallsaas.baasTicket.services.domain.model.ComplainReplyRecordRecord;
import com.jfeat.module.smallsaas.baasTicket.services.domain.service.ComplainReplyRecordService;
import com.jfeat.module.smallsaas.baasTicket.services.gen.persistence.model.ComplainReplyRecord;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

import static com.jfeat.module.smallsaas.baasTicket.services.domain.converter.ComplainReplyConverter.COMPLAINRECORD;

/**
 * <p>
 * api
 * </p>
 *
 * @author Code generator
 * @since 2022-01-11
 */
@RestController
@Api("ComplainReplyRecord")
@RequestMapping("//api/u/complain/reply")
public class ComplainReplyRecordEndpoint {

    @Resource
    ComplainReplyRecordService complainReplyRecordService;

    @BusinessLog(name = "回复", value = "reply")
    @Permission(ComplainReplyRecordPermission.COMPLAINREPLYRECORD_NEW)
    @PostMapping
    @ApiOperation(value = "回复")
    public Tip createComplainReply(@RequestBody ComplainReplyGenerateRequest request) {
        complainReplyRecordService.createComplainReply(COMPLAINRECORD.toCommand(request));
        return SuccessTip.create();
    }

}

