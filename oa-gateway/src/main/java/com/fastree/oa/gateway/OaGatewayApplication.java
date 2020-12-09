package com.fastree.oa.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OaGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(OaGatewayApplication.class, args);
    }
}
