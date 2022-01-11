package com.jfeat.module.smallsaas.baasTicket.services.gen.persistence.model.ComplainRecord;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author Code generator
 * @since 2022-01-11
 */
@TableName("nft_complain_record")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ComplainRecord extends Model<ComplainRecord> {

    private static final long serialVersionUID = 1L;

    public static final String ID = "id";

    public static final String COMPLAINANT_ID = "complainant_id";

    public static final String RELATION_ORDER_ID = "relation_order_id";

    public static final String TITLE = "title";

    public static final String CONTENT = "content";

    public static final String CREDENTIAL_LINK = "credential_link";

    public static final String STATUS = "status";

    public static final String CREATETIME = "createTime";

    public static final String UPDATETIME = "updateTime";

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

    private LocalDateTime createTime;
    /**
     * 记录更新时间
     */
    private LocalDateTime updateTime;


    public Long getId() {
        return id;
    }

    public ComplainRecord setId(Long id) {
        this.id = id;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public Long getComplainantId() {
        return complainantId;
    }

    public ComplainRecord setComplainantId(Long complainantId) {
        this.complainantId = complainantId;
        return this;
    }

    public Long getRelationOrderId() {
        return relationOrderId;
    }

    public ComplainRecord setRelationOrderId(Long relationOrderId) {
        this.relationOrderId = relationOrderId;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public ComplainRecord setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContent() {
        return content;
    }

    public ComplainRecord setContent(String content) {
        this.content = content;
        return this;
    }

    public String getCredentialLink() {
        return credentialLink;
    }

    public ComplainRecord setCredentialLink(String credentialLink) {
        this.credentialLink = credentialLink;
        return this;
    }

    public ComplainRecordStatus getStatus() {
        return status;
    }

    public ComplainRecord setStatus(ComplainRecordStatus status) {
        this.status = status;
        return this;
    }



    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "ComplainRecord{" +
                "id=" + id +
                ", complainantId=" + complainantId +
                ", relationOrderId=" + relationOrderId +
                ", title=" + title +
                ", content=" + content +
                ", credentialLink=" + credentialLink +
                ", status=" + status +
                "}";
    }
}
