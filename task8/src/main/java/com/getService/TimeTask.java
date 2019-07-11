package com.getService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class TimeTask {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    private ServiceFactory serviceFactory;

    public void setState() {
        try {
            serviceFactory.getEmptyService1().test();
        } catch (Exception e) {
            //如果redis没有记录service1挂了的信息，就写入
            if (redisTemplate.opsForValue().get("service1") == null) {
                redisTemplate.opsForValue().set("service1", "false");
            }
        }
        try {
            serviceFactory.getEmptyService2().test();
        } catch (Exception e) {
            //如果redis没有记录service2挂了的信息，就写入
            if (redisTemplate.opsForValue().get("service2") == null) {
                redisTemplate.opsForValue().set("service2", "false");
            }
        }
    }
}
