package com.timepost.dao;

import com.timepost.entity.MailEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

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

    /**
     * 根据用户id获取邮件列表
     *
     * @param userId 用户id
     * @return 该用户邮件集合
     */
    List<MailEntity> selectByUserId(String userId);

    /**
     * 更新邮件信息
     *
     * @param mailEntity 邮件信息
     * @return 更新结果
     */
    int update(MailEntity mailEntity);

    /**
     * 根据id删除邮件
     *
     * @param id 邮件id
     * @return 删除结果
     */
    int delete(@Param("id") String id);

}

