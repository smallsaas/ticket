
package com.jfeat.module.smallsaas.baasTicket.api;


import com.jfeat.am.core.jwt.JWTKit;
import com.jfeat.module.smallsaas.baasTicket.api.request.ComplainGenerateRequest;
import com.jfeat.module.smallsaas.baasTicket.services.gen.persistence.model.ComplainRecord.ComplainRecordStatus;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.jfeat.module.smallsaas.baasTicket.services.domain.dao.QueryComplainRecordDao;
import com.jfeat.crud.base.tips.SuccessTip;
import com.jfeat.crud.base.tips.Tip;
import com.jfeat.crud.base.annotation.BusinessLog;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import com.jfeat.module.smallsaas.baasTicket.api.permission.*;
import com.jfeat.am.common.annotation.Permission;

import com.jfeat.module.smallsaas.baasTicket.services.domain.service.*;
import com.jfeat.module.smallsaas.baasTicket.services.domain.model.ComplainRecordRecord;
import com.jfeat.module.smallsaas.baasTicket.services.gen.persistence.model.ComplainRecord.ComplainRecord;

import org.springframework.web.bind.annotation.RestController;
import static com.jfeat.module.smallsaas.baasTicket.services.domain.converter.ComplainConverter.COMPLAIN;


import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * api
 * </p>
 *
 * @author Code generator
 * @since 2022-01-11
 */
@RestController
@Api("ComplainRecord")
@RequestMapping("/api/u/complain")
public class ComplainRecordEndpoint {

    @Resource
    ComplainRecordService complainRecordService;

    @Resource
    QueryComplainRecordDao queryComplainRecordDao;


    @BusinessLog(name = "ComplainRecord", value = "create ComplainRecord")
    @Permission(ComplainRecordPermission.COMPLAINRECORD_NEW)
    @PostMapping
    @ApiOperation(value = "新建 ComplainRecord", response = ComplainRecord.class)
    public Tip createComplainRecord(@RequestBody ComplainGenerateRequest request) {
        complainRecordService.createComplain(COMPLAIN.toCommand(request));
        return SuccessTip.create();
    }

    @Permission(ComplainRecordPermission.COMPLAINRECORD_VIEW)
    @GetMapping("/{complainantId}")
    @ApiOperation(value = "申诉人ID查询申诉记录", response = ComplainRecord.class)
    public Tip getComplainRecord(@PathVariable Long complainantId,
                                 @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                 @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize) {

        var complainRecord= new ComplainRecordRecord();
        complainRecord.setComplainantId(complainantId);

        var page = new Page<ComplainRecordRecord>();
        page.setSize(pageSize).setCurrent(pageNum);

        page.setRecords(queryComplainRecordDao.findComplainRecordPage(page,complainRecord,null,null,null,null,null));
        return SuccessTip.create(page);
    }

}

