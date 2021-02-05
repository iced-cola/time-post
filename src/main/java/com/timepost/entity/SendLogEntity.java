package com.timepost.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  02-05-2021 22:46:49
 * @description :  邮件发送日志实体类
 * @since :  v1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SendLogEntity extends BaseEntity {

    /**
     * 主键id
     */
    private String id;

    /**
     * 邮件id
     */
    private String mailId;

    /**
     * 发送结果
     */
    private String sendResult;

}
