package com.timepost.service;

import com.timepost.PostException;
import com.timepost.entity.ResponseEntity;
import com.timepost.entity.UserEntity;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  02-05-2021 23:03:50
 * @description :  用户业务类
 * @since :  v1.0
 */
public interface UserService {

    /**
     * 创建用户
     *
     * @param userEntity 用户实体
     * @return 创建成功 or 创建失败
     */
    ResponseEntity<String> createUser(UserEntity userEntity) throws PostException;

    /**
     * 登录处理
     *
     * @param userEntity 用户信息
     * @return 登录成功 or 登录失败
     */
    ResponseEntity<String> login(UserEntity userEntity);

    /**
     * 修改密码
     *
     * @param userEntity 用户信息
     * @return 修改成功 or 修改失败
     */
    ResponseEntity<Object> changePassword(UserEntity userEntity);

    /**
     * 删除用户
     *
     * @param userId 用户id
     * @return 删除成功 or 删除失败
     */
    ResponseEntity<Object> deleteUser(String userId);

}
