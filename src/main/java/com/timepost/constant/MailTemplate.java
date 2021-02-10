package com.timepost.constant;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  02-09-2021 21:12:41
 * @description :  邮件模板类
 * @since :  v1.0
 */
public class MailTemplate {

    public static final String TIMER_MAIL_TEMPLATE = "${RECEIVER}你好！<br/><br/>"
            + "&nbsp;&nbsp;还记得${CREATE_DATE}你对未来的愿景吗？转眼已经过去了${DATE_DIFF}天，"
            + "那时留给自己的话，今日时光邮局为您送达。以下是原文：<br/><br/>"
            + "${CONTENT}<br/><br/>"
            + "邮件由时光邮局转送❤";

}
