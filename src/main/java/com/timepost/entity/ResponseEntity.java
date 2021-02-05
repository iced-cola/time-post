package com.timepost.entity;

import com.timepost.constant.ResultEnum;
import lombok.Data;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  02-05-2021 23:13:58
 * @description :  返回数据类
 * @since :  v1.0
 */
@Data
public class ResponseEntity<T> {

    private Integer code;

    private String message;

    private T data;

    public ResponseEntity(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseEntity(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResponseEntity(ResultEnum resultEnum, T data) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
        this.data = data;
    }

    public ResponseEntity(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
    }
}
