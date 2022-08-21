package com.ivan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author hylu.ivan
 * @date 2022/8/21 下午8:03
 * @description
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class RpcApplication {

    public static void main(String[] args) {

        SpringApplication.run(RpcApplication.class, args);
    }

}
