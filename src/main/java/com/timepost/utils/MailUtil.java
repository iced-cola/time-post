package com.timepost.utils;

import com.sun.mail.util.MailSSLSocketFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.util.List;
import java.util.Properties;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  02-07-2021 22:35:47
 * @description :  邮件发送工具类
 * @since :  v1.0.0
 */
@Service
@Slf4j
public class MailUtil {

    @Value(value = "${spring.mail.username}")
    private String mailAddress;

    // 邮箱授权码
    @Value(value = "${spring.mail.password}")
    private String mailToken;

    /**
     * 邮件协议
     */
    private static final String MAIL_PROTOCOL = "SMTP";

    /**
     * 邮件服务器
     */
    private static final String MAIL_HOST = "smtp.qq.com";

    /**
     * 邮件发送端口
     */
    private static final String MAIL_PORT = "587";

    /**
     * 发送不带附件的邮件
     *
     * @param receiver    收件人
     * @param ccReceivers 抄送人集合
     * @param subject     邮件主题
     * @param content     邮件正文
     */
    public void sendMail(String receiver,
                         List<String> ccReceivers,
                         String subject,
                         String content) {
        try {
            Properties properties = System.getProperties();// 获取系统属性
            properties.setProperty("mail.transport.protocol", MAIL_PROTOCOL);
            properties.setProperty("mail.host", MAIL_HOST);
            properties.setProperty("mail.port", MAIL_PORT);
            // 指定验证为true
            properties.setProperty("mail.smtp.auth", "true");

            //设置SSL加密
            MailSSLSocketFactory factory = new MailSSLSocketFactory();
            factory.setTrustAllHosts(true);
            properties.put("mail.smtp.ssl.enable", "true");
            properties.put("mail.smtp.ssl.socketFactory", factory);

            Session session = Session.getDefaultInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(mailAddress, mailToken);
                }
            });
            session.setDebug(true);

            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress(mailAddress));
            mimeMessage.setRecipients(Message.RecipientType.TO, String.valueOf(new InternetAddress(receiver)));
            mimeMessage.setSubject(subject);
            mimeMessage.setContent(content, "text/html;charset=UTF-8");
            Transport.send(mimeMessage, mimeMessage.getAllRecipients());
        } catch (Exception e) {
            log.error("【邮件发送】邮件发送失败，邮件信息如下");
            log.error("收件人：{}, 抄送人：{}，邮件主题：{}，邮件内容：{}", receiver, ccReceivers, subject, content);
            log.error("异常信息如下：");
            e.printStackTrace();
        }
    }

    /**
     * 发送带附件的邮件
     *
     * @param receiver    收件人
     * @param ccReceivers 抄送人集合
     * @param subject     邮件主题
     * @param content     邮件正文
     * @param file        附件
     */
    public void sendMailWithAttach(String receiver,
                                   List<String> ccReceivers,
                                   String subject,
                                   String content,
                                   File file) {
        try {
            Properties properties = System.getProperties();// 获取系统属性
            properties.setProperty("mail.transport.protocol", MAIL_PROTOCOL);
            properties.setProperty("mail.host", MAIL_HOST);
            properties.setProperty("mail.port", MAIL_PORT);
            // 指定验证为true
            properties.setProperty("mail.smtp.auth", "true");

            //设置SSL加密
            MailSSLSocketFactory factory = new MailSSLSocketFactory();
            factory.setTrustAllHosts(true);
            properties.put("mail.smtp.ssl.enable", "true");
            properties.put("mail.smtp.ssl.socketFactory", factory);

            Session session = Session.getDefaultInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(mailAddress, mailToken);
                }
            });
            session.setDebug(true);

            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress(mailAddress));
            mimeMessage.setRecipients(Message.RecipientType.TO, String.valueOf(new InternetAddress(receiver)));
            mimeMessage.setSubject(subject);
            mimeMessage.setContent(content, "text/html;charset=UTF-8");
            mimeMessage.setContent(new MimeMultipart(new FileDataSource(file)));
            Transport.send(mimeMessage, mimeMessage.getAllRecipients());
        } catch (
                Exception e) {
            log.error("【邮件发送】邮件发送失败，邮件信息如下");
            log.error("收件人：{}, 抄送人：{}，邮件主题：{}，邮件内容：{}", receiver, ccReceivers, subject, content);
            log.error("异常信息：");
            e.printStackTrace();
        }
    }
}
