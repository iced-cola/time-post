package com.timepost.service.impl;

import com.timepost.constant.ResultEnum;
import com.timepost.dao.MailDao;
import com.timepost.dao.SendLogDao;
import com.timepost.dao.UserDao;
import com.timepost.entity.MailEntity;
import com.timepost.entity.ResponseEntity;
import com.timepost.entity.SendLogEntity;
import com.timepost.service.MailService;
import com.timepost.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  02-10-2021 20:25:11
 * @description :  邮件业务逻辑
 * @since :  v1.0
 */
@Service
@Slf4j
public class MailServiceImpl implements MailService {

    @Resource
    private SendLogDao logDao;

    @Resource
    private UserDao userDao;

    @Resource
    private MailDao mailDao;

    @Override
    public ResponseEntity<Object> create(MailEntity mailEntity) {
        // 参数校验
        if (Objects.isNull(mailEntity)) {
            log.error("【创建邮件】邮件不能为空");
            return ResultUtil.error(ResultEnum.PARAM_ERROR);
        }

        mailDao.insert(mailEntity);
        return ResultUtil.success();
    }

    @Override
    public ResponseEntity<Object> update(MailEntity mailEntity) {
        if (Objects.isNull(mailEntity)) {
            return ResultUtil.error(ResultEnum.PARAM_ERROR);
        }
        mailDao.update(mailEntity);
        return ResultUtil.success();
    }

    @Override
    public ResponseEntity<Object> delete(String id) {
        mailDao.delete(id);
        return ResultUtil.success();
    }

    @Override
    public ResponseEntity<Object> cancel(MailEntity mailEntity) {
        mailEntity.setSendDate(null);
        mailDao.update(mailEntity);
        return ResultUtil.success();
    }

    @Override
    public ResponseEntity<Object> listMyEmail(String userId) {
        List<MailEntity> mailEntityList = mailDao.selectByUserId(userId);
        if (CollectionUtils.isEmpty(mailEntityList)) {
            return ResultUtil.success(ResultEnum.SUCCESS.getCode(), "没有相关数据");
        }
        return ResultUtil.success(ResultEnum.SUCCESS, mailEntityList);
    }

    @Override
    public ResponseEntity<Object> createLog(SendLogEntity logEntity) {
        logDao.insert(logEntity);
        return ResultUtil.success();
    }
}
