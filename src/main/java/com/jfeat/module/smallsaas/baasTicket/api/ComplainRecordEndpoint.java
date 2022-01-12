
package com.jfeat.module.smallsaas.baasTicket.api;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.am.common.annotation.Permission;
import com.jfeat.crud.base.annotation.BusinessLog;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import com.jfeat.crud.base.tips.SuccessTip;
import com.jfeat.crud.base.tips.Tip;
import com.jfeat.module.smallsaas.baasTicket.api.permission.ComplainRecordPermission;
import com.jfeat.module.smallsaas.baasTicket.api.request.ComplainGenerateRequest;
import com.jfeat.module.smallsaas.baasTicket.services.domain.dao.QueryComplainRecordDao;
import com.jfeat.module.smallsaas.baasTicket.services.domain.model.ComplainRecordRecord;
import com.jfeat.module.smallsaas.baasTicket.services.domain.service.ComplainRecordService;
import com.jfeat.module.smallsaas.baasTicket.services.gen.persistence.model.ComplainRecord.ComplainRecord;
import com.jfeat.module.smallsaas.baasTicket.services.gen.persistence.model.ComplainRecord.ComplainRecordStatus;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import static com.jfeat.module.smallsaas.baasTicket.services.domain.converter.ComplainConverter.COMPLAIN;

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
    @GetMapping("/{id}")
    @ApiOperation(value = "查看 ComplainRecord", response = ComplainRecord.class)
    public Tip getComplainRecord(@PathVariable Long id) {
        return SuccessTip.create(complainRecordService.queryMasterModel(queryComplainRecordDao, id));
    }

    @BusinessLog(name = "ComplainRecord", value = "update ComplainRecord")
    @Permission(ComplainRecordPermission.COMPLAINRECORD_EDIT)
    @PutMapping("/{id}")
    @ApiOperation(value = "修改 ComplainRecord", response = ComplainRecord.class)
    public Tip updateComplainRecord(@PathVariable Long id, @RequestBody ComplainRecord entity) {
        entity.setId(id);
        return SuccessTip.create(complainRecordService.updateMaster(entity));
    }

    @BusinessLog(name = "ComplainRecord", value = "delete ComplainRecord")
    @Permission(ComplainRecordPermission.COMPLAINRECORD_DELETE)
    @DeleteMapping("/{id}")
    @ApiOperation("删除 ComplainRecord")
    public Tip deleteComplainRecord(@PathVariable Long id) {
        return SuccessTip.create(complainRecordService.deleteMaster(id));
    }

    @Permission(ComplainRecordPermission.COMPLAINRECORD_VIEW)
    @ApiOperation(value = "ComplainRecord 列表信息", response = ComplainRecordRecord.class)
    @GetMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", dataType = "Integer"),
            @ApiImplicitParam(name = "search", dataType = "String"),
            @ApiImplicitParam(name = "id", dataType = "Long"),
            @ApiImplicitParam(name = "complainantId", dataType = "Long"),
            @ApiImplicitParam(name = "relationOrderId", dataType = "Long"),
            @ApiImplicitParam(name = "title", dataType = "String"),
            @ApiImplicitParam(name = "content", dataType = "String"),
            @ApiImplicitParam(name = "credentialLink", dataType = "String"),
            @ApiImplicitParam(name = "status", dataType = "String"),
            @ApiImplicitParam(name = "orderBy", dataType = "String"),
            @ApiImplicitParam(name = "sort", dataType = "String")
    })
    public Tip queryComplainRecordPage(Page<ComplainRecordRecord> page,
                                       @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                       @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                       // for tag feature query
                                       @RequestParam(name = "tag", required = false) String tag,
                                       // end tag
                                       @RequestParam(name = "search", required = false) String search,

                                       @RequestParam(name = "complainantId", required = false) Long complainantId,

                                       @RequestParam(name = "relationOrderId", required = false) Long relationOrderId,

                                       @RequestParam(name = "title", required = false) String title,

                                       @RequestParam(name = "content", required = false) String content,

                                       @RequestParam(name = "credentialLink", required = false) String credentialLink,

                                       @RequestParam(name = "status", required = false) String status,
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

        ComplainRecordRecord record = new ComplainRecordRecord();
        record.setComplainantId(complainantId);
        record.setRelationOrderId(relationOrderId);
        record.setTitle(title);
        record.setContent(content);
        record.setCredentialLink(credentialLink);
        record.setStatus(ComplainRecordStatus.valueOf(status));


        List<ComplainRecordRecord> complainRecordPage = queryComplainRecordDao.findComplainRecordPage(page, record, tag, search, orderBy, null, null);


        page.setRecords(complainRecordPage);

        return SuccessTip.create(page);
    }
}

