package com.jfeat.module.smallsaas.ticket.services.gen.persistence.model.complainrecord;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@TableName("nft_complain_record")
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ComplainRecord extends Model<ComplainRecord> {
    /**
     * 申诉单ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 申诉者ID
     */
    private Long complainantId;

    /**
     * 关联订单ID
     */
    private Long relationOrderId;

    private String complainantRole;
    /**
     * 申诉标题
     */
    private String title;

    /**
     * 申诉内容
     */
    private String content;

    /**
     * 凭证链接
     */
    private String credentialLink;

    /**
     * 状态 待回复 - PENDING_REPLY 已回复 - REPLIED 已完成 - COMPLETED
     */
    private ComplainRecordStatus status;

    /**
     * 记录创建时间
     */

    @JsonFormat(timezone = "GMT+8" , pattern = "yyyy:MM:dd HH:mm:ss")
    private LocalDateTime createTime;
    /**
     * 记录更新时间
     */
    @JsonFormat(timezone = "GMT+8" , pattern = "yyyy:MM:dd HH:mm:ss")
    private LocalDateTime updateTime;

    /**
     * 申诉类型 反馈 FEEDBACK 订单纠纷 ORDER_DISPUTES
     *
     */
    private ComplainRequestType requestType;

}
