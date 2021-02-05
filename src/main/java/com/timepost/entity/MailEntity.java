package com.timepost.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  02-05-2021 22:46:32
 * @description :  邮件实体类
 * @since :  v1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailEntity extends BaseEntity {

    /**
     * 主键id
     */
    private String id;

    /**
     * 所属用户id
     */
    private String userId;

    /**
     * 收件人邮箱
     */
    private String receiver;

    /**
     * 邮件标题
     */
    private String subject;

    /**
     * 邮件内容
     */
    private String content;

    /**
     * 预定发送日期
     */
    private Date sendDate;

    /**
     * 是否公开
     */
    private String isPublic;

}
