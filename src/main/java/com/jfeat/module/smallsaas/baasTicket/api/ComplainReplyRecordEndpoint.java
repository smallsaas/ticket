
package com.jfeat.module.smallsaas.baasTicket.api;


import com.jfeat.crud.plus.META;
import com.jfeat.am.core.jwt.JWTKit;
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
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.dao.DuplicateKeyException;
import com.jfeat.module.smallsaas.baasTicket.services.domain.dao.QueryComplainReplyRecordDao;
import com.jfeat.crud.base.tips.SuccessTip;
import com.jfeat.crud.base.request.Ids;
import com.jfeat.crud.base.tips.Tip;
import com.jfeat.crud.base.annotation.BusinessLog;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import com.jfeat.crud.plus.CRUDObject;
import com.jfeat.crud.plus.DefaultFilterResult;
import com.jfeat.module.smallsaas.baasTicket.api.permission.*;
import com.jfeat.am.common.annotation.Permission;

import java.math.BigDecimal;

import com.jfeat.module.smallsaas.baasTicket.services.domain.service.*;
import com.jfeat.module.smallsaas.baasTicket.services.domain.model.ComplainReplyRecordRecord;
import com.jfeat.module.smallsaas.baasTicket.services.gen.persistence.model.ComplainReplyRecord;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONArray;

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
@RequestMapping("/api/u//complainReplyRecord/complainReplyRecords")
public class ComplainReplyRecordEndpoint {

    @Resource
    ComplainReplyRecordService complainReplyRecordService;

    @Resource
    QueryComplainReplyRecordDao queryComplainReplyRecordDao;


    @BusinessLog(name = "ComplainReplyRecord", value = "create ComplainReplyRecord")
    @Permission(ComplainReplyRecordPermission.COMPLAINREPLYRECORD_NEW)
    @PostMapping
    @ApiOperation(value = "新建 ComplainReplyRecord", response = ComplainReplyRecord.class)
    public Tip createComplainReplyRecord(@RequestBody ComplainReplyRecord entity) {
        Integer affected = 0;
        try {
            affected = complainReplyRecordService.createMaster(entity);
        } catch (DuplicateKeyException e) {
            throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
    }

    @Permission(ComplainReplyRecordPermission.COMPLAINREPLYRECORD_VIEW)
    @GetMapping("/{id}")
    @ApiOperation(value = "查看 ComplainReplyRecord", response = ComplainReplyRecord.class)
    public Tip getComplainReplyRecord(@PathVariable Long id) {
        return SuccessTip.create(complainReplyRecordService.queryMasterModel(queryComplainReplyRecordDao, id));
    }

    @BusinessLog(name = "ComplainReplyRecord", value = "update ComplainReplyRecord")
    @Permission(ComplainReplyRecordPermission.COMPLAINREPLYRECORD_EDIT)
    @PutMapping("/{id}")
    @ApiOperation(value = "修改 ComplainReplyRecord", response = ComplainReplyRecord.class)
    public Tip updateComplainReplyRecord(@PathVariable Long id, @RequestBody ComplainReplyRecord entity) {
        entity.setId(id);
        return SuccessTip.create(complainReplyRecordService.updateMaster(entity));
    }

    @BusinessLog(name = "ComplainReplyRecord", value = "delete ComplainReplyRecord")
    @Permission(ComplainReplyRecordPermission.COMPLAINREPLYRECORD_DELETE)
    @DeleteMapping("/{id}")
    @ApiOperation("删除 ComplainReplyRecord")
    public Tip deleteComplainReplyRecord(@PathVariable Long id) {
        return SuccessTip.create(complainReplyRecordService.deleteMaster(id));
    }

    @Permission(ComplainReplyRecordPermission.COMPLAINREPLYRECORD_VIEW)
    @ApiOperation(value = "ComplainReplyRecord 列表信息", response = ComplainReplyRecordRecord.class)
    @GetMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", dataType = "Integer"),
            @ApiImplicitParam(name = "search", dataType = "String"),
            @ApiImplicitParam(name = "id", dataType = "Long"),
            @ApiImplicitParam(name = "complainRecordId", dataType = "Long"),
            @ApiImplicitParam(name = "replyerId", dataType = "Long"),
            @ApiImplicitParam(name = "content", dataType = "String"),
            @ApiImplicitParam(name = "isManagerReply", dataType = "Integer"),
            @ApiImplicitParam(name = "replyTime", dataType = "Date"),
            @ApiImplicitParam(name = "createTime", dataType = "Date"),
            @ApiImplicitParam(name = "orderBy", dataType = "String"),
            @ApiImplicitParam(name = "sort", dataType = "String")
    })
    public Tip queryComplainReplyRecordPage(Page<ComplainReplyRecordRecord> page,
                                            @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                            @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                            // for tag feature query
                                            @RequestParam(name = "tag", required = false) String tag,
                                            // end tag
                                            @RequestParam(name = "search", required = false) String search,

                                            @RequestParam(name = "complainRecordId", required = false) Long complainRecordId,

                                            @RequestParam(name = "replyerId", required = false) Long replyerId,

                                            @RequestParam(name = "content", required = false) String content,

                                            @RequestParam(name = "isManagerReply", required = false) Integer isManagerReply,

                                            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
                                            @RequestParam(name = "replyTime", required = false) Date replyTime,

                                            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
                                            @RequestParam(name = "createTime", required = false) Date createTime,
                                            @RequestParam(name = "orderBy", required = false) String orderBy,
                                            @RequestParam(name = "sort", required = false) String sort) {

        if (orderBy != null && orderBy.length() > 0) {
            if (sort != null && sort.length() > 0) {
                String pattern = "(ASC|DESC|asc|desc)";
                if (!sort.matches(pattern)) {
                    throw new BusinessException(BusinessCode.BadRequest.getCode(), "sort must be ASC or DESC");//此处异常类型根据实际情况而定
                }
            } else {
                sort = "ASC";
            }
            orderBy = "`" + orderBy + "`" + " " + sort;
        }
        page.setCurrent(pageNum);
        page.setSize(pageSize);

        ComplainReplyRecordRecord record = new ComplainReplyRecordRecord();
        record.setComplainRecordId(complainRecordId);
        record.setReplyerId(replyerId);
        record.setContent(content);
        record.setIsManagerReply(isManagerReply);
        record.setReplyTime(replyTime);
        record.setCreateTime(createTime);


        List<ComplainReplyRecordRecord> complainReplyRecordPage = queryComplainReplyRecordDao.findComplainReplyRecordPage(page, record, tag, search, orderBy, null, null);


        page.setRecords(complainReplyRecordPage);

        return SuccessTip.create(page);
    }
}

