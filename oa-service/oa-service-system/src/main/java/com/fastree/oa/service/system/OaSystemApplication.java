package com.fastree.oa.service.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
//@EnableFeignClients(basePackages = {"com.fastree.oa.system.service.feign"})
@MapperScan(basePackages = {"com.fastree.oa.service.system.mapper"})
@SpringBootApplication
public class OaSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(OaSystemApplication.class, args);
    }
}
