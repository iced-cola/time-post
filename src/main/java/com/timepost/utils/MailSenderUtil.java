package com.timepost.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  02-07-2021 22:35:47
 * @description :  邮件发送工具类
 * @since :  v1.0.0
 */
@Service
public class MailSenderUtil {

    @Value(value = "${mail.interval}")
    private Integer mailInterval;

    @Value(value = "${mail.sender}")
    private String mailSender;

    @Value(value = "${mail.password}")
    private String mailPassword;

    /**
     * 发送不带附件的邮件
     *
     * @param receivers   收件人集合
     * @param ccReceivers 抄送人集合
     * @param subject     邮件主题
     * @param content     邮件正文
     * @return 发送结果
     */
    public static Map<Integer, String> sendMail(List<String> receivers,
                                                List<String> ccReceivers,
                                                String subject,
                                                String content) {
        String host = "smtp.xxxxx.gov.cn";
        Properties properties = System.getProperties();// 获取系统属性
        properties.setProperty("mail.transport.protocol", "IMAP");
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.port", "25");
        // 指定验证为true
        properties.setProperty("mail.smtp.auth", "true");

        // TODO 完成邮件发送功能的开发
        return null;
    }

    /**
     * 发送带附件的邮件
     *
     * @param receivers   收件人集合
     * @param ccReceivers 抄送人集合
     * @param subject     邮件主题
     * @param content     邮件正文
     * @param file        附件
     * @return 发送结果
     */
    public static Map<Integer, String> sendMailWithAttach(List<String> receivers,
                                                          List<String> ccReceivers,
                                                          String subject,
                                                          String content,
                                                          File file) {
        // TODO 完成邮件发送功能的开发
        return null;
    }

}
