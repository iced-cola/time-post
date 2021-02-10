package com.timepost.service.impl;

import com.timepost.constant.ResultEnum;
import com.timepost.dao.UserDao;
import com.timepost.entity.ResponseEntity;
import com.timepost.entity.UserEntity;
import com.timepost.entity.dto.UserDto;
import com.timepost.service.UserService;
import com.timepost.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public ResponseEntity<String> createUser(UserEntity userEntity) {
        // 校验用户信息是否有效
        if (Objects.isNull(userEntity) || StringUtils.isEmpty(userEntity.getUserId())
                || StringUtils.isEmpty(userEntity.getPassword())) {
            log.error("【创建用户】创建用户失败，用户信息不全。");
            return ResultUtil.error(ResultEnum.PARAM_ERROR);
        }

        // 合法用户信息则入库
        userDao.insert(userEntity);
        return ResultUtil.success();
    }

    @Override
    public ResponseEntity<String> login(UserEntity userEntity) {
        return null;
    }

    @Override
    public ResponseEntity<Object> changePassword(UserDto userDto) {
        // 参数校验
        UserEntity user = userDao.selectByUserId(userDto.getUserId());
        if (Objects.isNull(user)) {
            return ResultUtil.error(ResultEnum.FAIL.getCode(), "该用户不存在");
        }
        if (StringUtils.isEmpty(userDto.getOldPassword())) {
            return ResultUtil.error(ResultEnum.FAIL.getCode(), "原密码不能为空");
        }
        if (StringUtils.isEmpty(userDto.getNewPassword())) {
            return ResultUtil.error(ResultEnum.FAIL.getCode(), "新密码不能为空");
        }
        if (Objects.equals(userDto.getOldPassword(), user.getPassword())) {
            return ResultUtil.error(ResultEnum.FAIL.getCode(), "原密码不正确");
        }

        // 更新密码
        userDao.updateUserPassword(userDto.getUserId(), userDto.getNewPassword());
        return ResultUtil.success();
    }

    @Override
    public ResponseEntity<Object> deleteUser(String userId) {
        UserEntity userEntity = userDao.selectByUserId(userId);
        if (Objects.isNull(userEntity)) {
            return ResultUtil.error(ResultEnum.FAIL.getCode(), "没有找到该用户");
        }

        userDao.deleteByUserId(userId);

        return ResultUtil.success();
    }
}
