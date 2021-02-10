package com.timepost.entity.dto;

import lombok.Data;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  02-10-2021 17:51:57
 * @description :  用户参数类
 * @since :  v1.0
 */
@Data
public class UserDto {

    private String userId;

    private String oldPassword;

    private String newPassword;

}
