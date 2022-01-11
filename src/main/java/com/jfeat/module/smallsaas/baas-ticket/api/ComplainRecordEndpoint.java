
package com.jfeat.module.smallsaas.baas-ticket.api;


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
import com.jfeat.module.smallsaas.baas-ticket.services.domain.dao.QueryComplainRecordDao;
import com.jfeat.crud.base.tips.SuccessTip;
import com.jfeat.crud.base.request.Ids;
import com.jfeat.crud.base.tips.Tip;
import com.jfeat.crud.base.annotation.BusinessLog;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import com.jfeat.crud.plus.CRUDObject;
import com.jfeat.crud.plus.DefaultFilterResult;
import com.jfeat.module.smallsaas.baas-ticket.api.permission.*;
import com.jfeat.am.common.annotation.Permission;
import java.math.BigDecimal;

import com.jfeat.module.smallsaas.baas-ticket.services.domain.service.*;
import com.jfeat.module.smallsaas.baas-ticket.services.domain.model.ComplainRecordRecord;
import com.jfeat.module.smallsaas.baas-ticket.services.gen.persistence.model.ComplainRecord;

    import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import com.alibaba.fastjson.JSONArray;
/**
 * <p>
 *  api
 * </p>
 *
 * @author Code generator
 * @since 2022-01-11
 */
    @RestController
    @Api("ComplainRecord")
            @RequestMapping("/api/crud/baas-ticket/complainRecord/complainRecords")
    public class ComplainRecordEndpoint {

    @Resource
    ComplainRecordService complainRecordService;

    @Resource
    QueryComplainRecordDao queryComplainRecordDao;



    @BusinessLog(name = "ComplainRecord", value = "create ComplainRecord")
    @Permission(ComplainRecordPermission.COMPLAINRECORD_NEW)
    @PostMapping
    @ApiOperation(value = "新建 ComplainRecord",response = ComplainRecord.class)
    public Tip createComplainRecord(@RequestBody ComplainRecord entity){
        Integer affected=0;
        try{
                affected= complainRecordService.createMaster(entity);
            }catch(DuplicateKeyException e){
             throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
}

    @Permission(ComplainRecordPermission.COMPLAINRECORD_VIEW)
    @GetMapping("/{id}")
    @ApiOperation(value = "查看 ComplainRecord",response = ComplainRecord.class)
    public Tip getComplainRecord(@PathVariable Long id){
                        return SuccessTip.create(complainRecordService.queryMasterModel(queryComplainRecordDao, id));
            }

    @BusinessLog(name = "ComplainRecord", value = "update ComplainRecord")
    @Permission(ComplainRecordPermission.COMPLAINRECORD_EDIT)
    @PutMapping("/{id}")
    @ApiOperation(value = "修改 ComplainRecord",response = ComplainRecord.class)
    public Tip updateComplainRecord(@PathVariable Long id,@RequestBody ComplainRecord entity){
        entity.setId(id);
                return SuccessTip.create(complainRecordService.updateMaster(entity));
            }

    @BusinessLog(name = "ComplainRecord", value = "delete ComplainRecord")
    @Permission(ComplainRecordPermission.COMPLAINRECORD_DELETE)
    @DeleteMapping("/{id}")
    @ApiOperation("删除 ComplainRecord")
    public Tip deleteComplainRecord(@PathVariable Long id){
            return SuccessTip.create(complainRecordService.deleteMaster(id));
        }

    @Permission(ComplainRecordPermission.COMPLAINRECORD_VIEW)
    @ApiOperation(value = "ComplainRecord 列表信息",response = ComplainRecordRecord.class)
    @GetMapping
    @ApiImplicitParams({
        @ApiImplicitParam(name= "pageNum", dataType = "Integer"),
        @ApiImplicitParam(name= "pageSize", dataType = "Integer"),
        @ApiImplicitParam(name= "search", dataType = "String"),
                                                                                        @ApiImplicitParam(name = "id", dataType = "Long"),
                                                                                                    @ApiImplicitParam(name = "complainantId", dataType = "Long"),
                                                                                                            @ApiImplicitParam(name = "relationOrderId", dataType = "Long"),
                                                                                    @ApiImplicitParam(name = "title", dataType = "String"),
                                                                                    @ApiImplicitParam(name = "content", dataType = "String"),
                                                                                            @ApiImplicitParam(name = "credentialLink", dataType = "String"),
                                                                                    @ApiImplicitParam(name = "status", dataType = "String") ,
                @ApiImplicitParam(name = "orderBy", dataType = "String"),
                @ApiImplicitParam(name = "sort", dataType = "String")
            })
    public Tip queryComplainRecordPage(Page<ComplainRecordRecord> page,
    @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
    @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
    // for tag feature query
    @RequestParam(name = "tag" , required = false)String tag,
    // end tag
    @RequestParam(name = "search", required = false) String search,
                                                                                                                                        
                                                                                                                                            @RequestParam(name = "complainantId", required = false) Long complainantId,
                    
                                                                                                                                                    @RequestParam(name = "relationOrderId", required = false) Long relationOrderId,
                    
                                                                                                                            @RequestParam(name = "title", required = false) String title,
                    
                                                                                                                            @RequestParam(name = "content", required = false) String content,
                    
                                                                                                                                    @RequestParam(name = "credentialLink", required = false) String credentialLink,
                    
                                                                                                                            @RequestParam(name = "status", required = false) String status,
        @RequestParam(name = "orderBy", required = false) String orderBy,
        @RequestParam(name = "sort", required = false)  String sort) {
                    
            if(orderBy!=null&&orderBy.length()>0){
        if(sort!=null&&sort.length()>0){
        String pattern = "(ASC|DESC|asc|desc)";
        if(!sort.matches(pattern)){
        throw new BusinessException(BusinessCode.BadRequest.getCode(), "sort must be ASC or DESC");//此处异常类型根据实际情况而定
        }
        }else{
        sort = "ASC";
        }
        orderBy = "`"+orderBy+"`" +" "+sort;
        }
        page.setCurrent(pageNum);
        page.setSize(pageSize);

    ComplainRecordRecord record = new ComplainRecordRecord();
                                                                                                                                                                                                record.setComplainantId(complainantId);
                                                                                                                                record.setRelationOrderId(relationOrderId);
                                                                                                                record.setTitle(title);
                                                                                                                record.setContent(content);
                                                                                                                        record.setCredentialLink(credentialLink);
                                                                                                                record.setStatus(status);
                        
                                

    List<ComplainRecordRecord> complainRecordPage = queryComplainRecordDao.findComplainRecordPage(page, record, tag, search, orderBy, null, null);

        
        page.setRecords(complainRecordPage);

        return SuccessTip.create(page);
    }
}

