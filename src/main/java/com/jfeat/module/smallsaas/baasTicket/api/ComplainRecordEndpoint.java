package com.jfeat.module.smallsaas.baasTicket.api;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.crud.base.annotation.BusinessLog;
import com.jfeat.crud.base.tips.SuccessTip;
import com.jfeat.crud.base.tips.Tip;
import com.jfeat.module.smallsaas.baasTicket.api.request.ComplainGenerateRequest;
import com.jfeat.module.smallsaas.baasTicket.services.domain.dao.QueryComplainRecordDao;
import com.jfeat.module.smallsaas.baasTicket.services.domain.model.ComplainRecordRecord;
import com.jfeat.module.smallsaas.baasTicket.services.domain.service.ComplainRecordService;
import com.jfeat.module.smallsaas.baasTicket.services.gen.persistence.model.ComplainRecord.ComplainRecord;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import static com.jfeat.module.smallsaas.baasTicket.services.domain.converter.ComplainConverter.COMPLAIN;

@RestController
@Api("ComplainRecord")
@RequestMapping("/api/u/complain")
public class ComplainRecordEndpoint {

    @Resource
    ComplainRecordService complainRecordService;

    @Resource
    QueryComplainRecordDao queryComplainRecordDao;


    @BusinessLog(name = "ComplainRecord", value = "create ComplainRecord")
    @PostMapping
    @ApiOperation(value = "新建 ComplainRecord", response = ComplainRecord.class)
    public Tip createComplainRecord(@RequestBody ComplainGenerateRequest request) {
        complainRecordService.createComplain(COMPLAIN.toCommand(request));
        return SuccessTip.create();
    }

    @GetMapping
    @ApiOperation(value = "查询申诉记录", response = ComplainRecord.class)
    public Tip getComplainRecord(@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                 @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                 @RequestParam(name = "requestType", required = false, defaultValue = "") String requestType) {

        var page = new Page<ComplainRecordRecord>();
        page.setSize(pageSize).setCurrent(pageNum);

        page.setRecords(queryComplainRecordDao.queryComplainRecordPage(page, requestType));
        return SuccessTip.create(page);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "查询申诉记录", response = ComplainRecord.class)
    public Tip getComplainRecordById(@PathVariable Long id) {
        return SuccessTip.create(queryComplainRecordDao.queryMasterModel(id));
    }

    @GetMapping("/{complainantId}")
    @ApiOperation(value = "根据申诉人ID查询申诉记录", response = ComplainRecordRecord.class)
    public Tip getComplainRecordByComplainantId(@PathVariable Long complainantId,
                                 @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                 @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                 @RequestParam(name = "requestType", required = false, defaultValue = "") String requestType) {

        var page = new Page<ComplainRecordRecord>();
        page.setSize(pageSize).setCurrent(pageNum);
        page.setRecords(queryComplainRecordDao.queryComplainRecordPageByComplainantId(page,complainantId, requestType));
        return SuccessTip.create(page);
    }

}

