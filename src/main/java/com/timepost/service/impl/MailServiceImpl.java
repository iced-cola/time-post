package com.timepost.service.impl;

import com.timepost.dao.MailDao;
import com.timepost.dao.UserDao;
import com.timepost.entity.MailEntity;
import com.timepost.entity.ResponseEntity;
import com.timepost.service.MailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  02-10-2021 20:25:11
 * @description :  邮件业务逻辑
 * @since :  v1.0
 */
@Service
public class MailServiceImpl implements MailService {

    @Resource
    private UserDao userDao;

    @Resource
    private MailDao mailDao;

    @Override
    public ResponseEntity<Object> create(MailEntity mailEntity) {
        return null;
    }

    @Override
    public ResponseEntity<Object> update(MailEntity mailEntity) {
        return null;
    }

    @Override
    public ResponseEntity<Object> delete(MailEntity mailEntity) {
        return null;
    }

    @Override
    public ResponseEntity<Object> cancel(MailEntity mailEntity) {
        return null;
    }

    @Override
    public ResponseEntity<Object> listMyEmail(String userId) {
        return null;
    }
}
