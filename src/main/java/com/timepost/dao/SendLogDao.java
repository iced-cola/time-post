package com.timepost.dao;

import com.timepost.entity.SendLogEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  02-05-2021 22:43:40
 * @description :  发送日志表访问类
 * @since :  v1.0
 */
@Mapper
public interface SendLogDao {

    /**
     * 新增发送记录
     *
     * @param sendLogEntity entity
     * @return result
     */
    int insert(SendLogEntity sendLogEntity);

}
