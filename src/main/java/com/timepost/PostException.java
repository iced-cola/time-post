package com.timepost;

import com.timepost.constant.ResultEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  02-06-2021 09:50:38
 * @description :  异常类
 * @since :  v1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PostException extends Exception {

    private int code;

    private String message;

    public PostException(int code, String message) {
        super(message);
        this.code = code;
    }

    public PostException(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
    }

}
