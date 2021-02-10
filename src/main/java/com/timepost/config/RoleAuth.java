package com.timepost.config;

import java.lang.annotation.*;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  02-09-2021 21:22:05
 * @description :  接口访问权限
 * @since :  v1.0
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface RoleAuth {

    String[] value();

}
