package com.timepost.local;

import java.util.UUID;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  02-05-2021 23:34:19
 * @description :  本地测试类
 * @since :  v1.0
 */
public class LocalTest {

    public static void main(String[] args) {
        System.out.println(generateUUID());
    }

    private static String generateUUID() {
        String uuid = UUID.randomUUID().toString();
        return uuid.replace("-", "");
    }

}
