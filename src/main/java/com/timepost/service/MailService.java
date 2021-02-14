package com.timepost.service;

import com.timepost.entity.MailEntity;
import com.timepost.entity.ResponseEntity;
import com.timepost.entity.SendLogEntity;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  02-05-2021 23:04:05
 * @description :  邮件业务接口
 * @since :  v1.0
 */
public interface MailService {

    /**
     * 创建待发送邮件
     *
     * @param mailEntity 邮件信息
     * @return 处理结果
     */
    ResponseEntity<Object> create(MailEntity mailEntity);

    /**
     * 修改待发送邮件信息
     *
     * @param mailEntity 邮件信息
     * @return 处理结果
     */
    ResponseEntity<Object> update(MailEntity mailEntity);

    /**
     * 删除待发送邮件
     *
     * @param id 邮件id
     * @return 处理结果
     */
    ResponseEntity<Object> delete(String id);

    /**
     * 取消发送待发送邮件
     *
     * @param mailEntity 邮件信息
     * @return 处理结果
     */
    ResponseEntity<Object> cancel(MailEntity mailEntity);

    /**
     * 查找某个用户的邮件
     *
     * @param userId 用户id
     * @return 该用户的邮件列表（含已发送|已取消发送邮件）
     */
    ResponseEntity<Object> listMyEmail(String userId);

    /**
     * 记录邮件发送结果
     *
     * @param logEntity 发送日志
     * @return 日志记录
     */
    ResponseEntity<Object> createLog(SendLogEntity logEntity);

}
