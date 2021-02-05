package com.timepost.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  02-05-2021 22:47:31
 * @description :  实体类基类
 * @since :  v1.0
 */
@Data
public class BaseEntity {

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新者
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateTime;

}
