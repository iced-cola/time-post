package com.timepost.controller;

import com.timepost.entity.MailEntity;
import com.timepost.entity.ResponseEntity;
import com.timepost.service.MailService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  02-14-2021 12:51:03
 * @description :  邮件接口
 * @since :  v1.0
 */
@RestController
@RequestMapping(value = "/mail")
public class MailController {

    @Resource
    private MailService mailService;

    @RequestMapping(value = "/list")
    public ResponseEntity<Object> list(@RequestParam String userId) {
        return mailService.listMyEmail(userId);
    }

    @RequestMapping(value = "/cancel")
    public ResponseEntity<Object> cancel(@RequestBody MailEntity mailEntity) {
        return mailService.cancel(mailEntity);
    }

    @RequestMapping(value = "/create")
    public ResponseEntity<Object> create(@RequestBody MailEntity mailEntity) {
        return mailService.create(mailEntity);
    }

    @RequestMapping(value = "/update")
    public ResponseEntity<Object> update(@RequestBody MailEntity mailEntity) {
        return mailService.update(mailEntity);
    }

    @RequestMapping(value = "/delete")
    public ResponseEntity<Object> delete(@RequestParam String id) {
        return mailService.delete(id);
    }
}
