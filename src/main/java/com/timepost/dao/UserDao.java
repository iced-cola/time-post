package com.timepost.dao;

import com.timepost.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  02-05-2021 22:42:54
 * @description :  用户表访问类
 * @since :  v1.0
 */
@Mapper
public interface UserDao {

    int insert(UserEntity userEntity);

    UserEntity selectByUserId(@Param("userId") String userId);

    int updateUserPassword(@Param("userId") String userId,
                           @Param("newPassword") String newPassword);

    int deleteByUserId(@Param("userId") String userId);

}
