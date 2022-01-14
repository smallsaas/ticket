package com.jfeat.module.smallsaas.baasTicket.services.gen.persistence.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@TableName("nft_complain_reply_record")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ComplainReplyRecord extends Model<ComplainReplyRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * 记录ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 申诉单ID
     */
    private Long complainRecordId;

    /**
     * 回复人ID
     */
    private Long replierId;

    /**
     * 回复内容
     */
    private String content;

    /**
     * 是否管理员回复
     */
    private Integer isManagerReply;

    /**
     * 回复时间
     */
    private Date replyTime;

    /**
     * 记录创建时间
     */
    private Date createTime;
}
