package com.timepost.constant;

import lombok.Getter;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  02-05-2021 23:05:59
 * @description :  业务处理结果
 * @since :  v1.0
 */
@Getter
public enum ResultEnum {

    SUCCESS(0, "操作成功"),

    FAIL(-1, "操作失败");

    private final Integer code;

    private final String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
