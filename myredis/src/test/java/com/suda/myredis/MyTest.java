package com.suda.myredis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class MyTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test() {
        System.out.println(redisTemplate);
        redisTemplate.opsForValue().set("test", "myTest");
        System.out.println(redisTemplate.opsForValue().get("test"));
        System.out.println(redisTemplate.opsForValue().get("user:1:name"));
//        redisTemplate.opsForValue();
        System.out.println("test");
    }
}
