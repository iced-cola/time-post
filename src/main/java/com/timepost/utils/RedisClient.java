package com.timepost.utils;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  02-14-2021 13:45:12
 * @description :  Redis操作类
 * @since :  v1.0
 */
@Component
public class RedisClient {

    @Resource
    private StringRedisTemplate redisTemplate;

    private static final long TOKEN_EXPIRES_SECOND = 1800;

    /**
     * redis设置值
     *
     * @param key   key
     * @param value value
     * @return true when success, or false when error
     */
    public boolean set(String key, String value) {
        boolean result = false;
        try {
            redisTemplate.opsForValue().set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 设置值，同时设置过期时间
     *
     * @param key   key
     * @param value value
     * @param time  过期时间
     * @return true when success, or false when fail
     */
    public boolean set(String key, String value, long time) {
        boolean result = false;
        try {
            redisTemplate.opsForValue().set(key, value);
            expire(key, time);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 设置key的过期时间
     *
     * @param key  key
     * @param time expiration time
     * @return true when success false when fail
     */
    public boolean expire(String key, long time) {
        boolean result = false;
        try {
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 获取redis中的值
     *
     * @param key key
     * @return value
     */
    public String get(String key) {
        String result = null;
        try {
            result = redisTemplate.opsForValue().get(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 根据key删除对应value
     *
     * @param key key
     * @return value
     */
    public boolean remove(String key) {
        boolean result = false;
        try {
            redisTemplate.delete(key);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
