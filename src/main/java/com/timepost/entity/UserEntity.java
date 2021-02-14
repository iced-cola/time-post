package com.timepost.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  02-05-2021 22:46:19
 * @description :  用户实体类
 * @since :  v1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends BaseEntity implements Serializable {

    /**
     * 主键id
     */
    private String id;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 用户角色
     */
    private String role;

    /**
     * 用户名
     */
    private String username;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 邮箱地址
     */
    private String mailAddress;

    /**
     * 个性签名
     */
    private String signature;

    /**
     * 最后登录日期
     */
    private Date lastLogin;

}
