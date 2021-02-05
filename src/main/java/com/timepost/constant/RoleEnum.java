package com.timepost.constant;

import lombok.Getter;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  02-05-2021 23:38:10
 * @description :  系统角色
 * @since :  v1.0
 */
@Getter
public enum RoleEnum {

    ADMIN("ROLE_ADMIN", "系统管理员"),

    USER("ROLE_USER", "普通用户");

    /**
     * 角色编码
     */
    private final String role;

    /**
     * 角色描述
     */
    private final String desc;

    RoleEnum(String role, String desc) {
        this.role = role;
        this.desc = desc;
    }

}
