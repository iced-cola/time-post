package com.timepost.service.impl;

import com.timepost.PostException;
import com.timepost.constant.ResultEnum;
import com.timepost.entity.ResponseEntity;
import com.timepost.entity.UserEntity;
import com.timepost.service.UserService;
import com.timepost.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Override
    public ResponseEntity<String> createUser(UserEntity userEntity) throws PostException {
        // 校验用户信息是否有效
        if (Objects.isNull(userEntity) || StringUtils.isEmpty(userEntity.getUserId())
                || StringUtils.isEmpty(userEntity.getPassword())) {
            log.error("【创建用户】创建用户失败，用户信息不全。");
            throw new PostException(ResultEnum.PARAM_ERROR);
        }

        return ResultUtil.success();
    }

    @Override
    public ResponseEntity<String> login(UserEntity userEntity) {
        return null;
    }

    @Override
    public ResponseEntity<Object> changePassword(UserEntity userEntity) {
        return null;
    }

    @Override
    public ResponseEntity<Object> deleteUser(String userId) {
        return null;
    }
}
