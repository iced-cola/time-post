package com.timepost.utils;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailUtilTest {

    @Resource
    private MailUtil mailUtil;

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void sendMailTest() {
        mailUtil.sendMail("zhulongkun20@163.com", null,
                "时光邮局转送邮件", "测试邮件！");
    }

    @Test
    public void sendMailWithAttachTest() {
        File file = new File("/Users/youyou-2608/Desktop/TestFile.pptx");
        mailUtil.sendMailWithAttach("zhulongkun20@163.com", null, "带附件的邮件测试",
                "测试用邮件内容", file);
    }

    @Test
    public void RedisTest() {
        redisTemplate.opsForValue().set("key", "value");
        String value = redisTemplate.opsForValue().get("key");
        Assert.notNull(value, "test passed");
    }
}
