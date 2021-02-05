package com.timepost.dao;

import com.timepost.entity.MailEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  02-05-2021 22:43:15
 * @description :  邮件信息表访问类
 * @since :  v1.0
 */
@Mapper
public interface MailDao {

    /**
     * 新增邮件
     *
     * @param mailEntity 邮件实体
     * @return 受影响行数
     */
    int insert(MailEntity mailEntity);

    /**
     * 根据预定发送时间获取邮件
     *
     * @param date 预定发送时间
     * @return 邮件集合
     */
    MailEntity selectBySendDate(@Param("date") Date date);

}

