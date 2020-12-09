package com.fastree.oa.service.system;

import jdk.net.Sockets;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.net.ServerSocket;

@SpringBootTest
public class OASystemApplicationTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test01() {


    }
}
