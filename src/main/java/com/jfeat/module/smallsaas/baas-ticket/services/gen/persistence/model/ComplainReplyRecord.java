package com.jfeat.module.smallsaas.baas-ticket.services.gen.persistence.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Code generator
 * @since 2022-01-11
 */
@TableName("nft_complain_reply_record")
public class ComplainReplyRecord extends Model<ComplainReplyRecord> {

    private static final long serialVersionUID=1L;

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
      private Long replyerId;

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

    
    public Long getId() {
        return id;
    }

      public ComplainReplyRecord setId(Long id) {
          this.id = id;
          return this;
      }
    
    public Long getComplainRecordId() {
        return complainRecordId;
    }

      public ComplainReplyRecord setComplainRecordId(Long complainRecordId) {
          this.complainRecordId = complainRecordId;
          return this;
      }
    
    public Long getReplyerId() {
        return replyerId;
    }

      public ComplainReplyRecord setReplyerId(Long replyerId) {
          this.replyerId = replyerId;
          return this;
      }
    
    public String getContent() {
        return content;
    }

      public ComplainReplyRecord setContent(String content) {
          this.content = content;
          return this;
      }
    
    public Integer getIsManagerReply() {
        return isManagerReply;
    }

      public ComplainReplyRecord setIsManagerReply(Integer isManagerReply) {
          this.isManagerReply = isManagerReply;
          return this;
      }
    
    public Date getReplyTime() {
        return replyTime;
    }

      public ComplainReplyRecord setReplyTime(Date replyTime) {
          this.replyTime = replyTime;
          return this;
      }
    
    public Date getCreateTime() {
        return createTime;
    }

      public ComplainReplyRecord setCreateTime(Date createTime) {
          this.createTime = createTime;
          return this;
      }

      public static final String ID = "id";

      public static final String COMPLAIN_RECORD_ID = "complain_record_id";

      public static final String REPLYER_ID = "replyer_id";

      public static final String CONTENT = "content";

      public static final String IS_MANAGER_REPLY = "is_manager_reply";

      public static final String REPLY_TIME = "reply_time";

      public static final String CREATE_TIME = "create_time";

      @Override
    protected Serializable pkVal() {
          return this.id;
      }

    @Override
    public String toString() {
        return "ComplainReplyRecord{" +
              "id=" + id +
                  ", complainRecordId=" + complainRecordId +
                  ", replyerId=" + replyerId +
                  ", content=" + content +
                  ", isManagerReply=" + isManagerReply +
                  ", replyTime=" + replyTime +
                  ", createTime=" + createTime +
              "}";
    }
}
