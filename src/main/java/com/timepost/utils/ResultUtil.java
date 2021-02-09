package com.timepost.utils;

import com.timepost.constant.ResultEnum;
import com.timepost.entity.ResponseEntity;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  02-05-2021 23:13:15
 * @description :  通用返回工具类
 * @since :  v1.0
 */
public class ResultUtil {

    public static <T> ResponseEntity<T> success(int code, String message, T data) {
        return new ResponseEntity<>(code, message, data);
    }

    public static <T> ResponseEntity<T> success(int code, String message) {
        return new ResponseEntity<>(code, message);
    }

    public static <T> ResponseEntity<T> success() {
        return new ResponseEntity<T>(ResultEnum.SUCCESS);
    }

    public static <T> ResponseEntity<T> success(ResultEnum resultEnum) {
        return new ResponseEntity<>(resultEnum);
    }

    public static <T> ResponseEntity<T> success(ResultEnum resultEnum, T data) {
        return new ResponseEntity<>(resultEnum, data);
    }

    public static <T> ResponseEntity<T> error(int code, String message) {
        return new ResponseEntity<>(code, message);
    }

    public static <T> ResponseEntity<T> error(ResultEnum resultEnum) {
        return new ResponseEntity<>(resultEnum);
    }

}
