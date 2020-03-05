package com.dhr.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Auther: 皮卡丘的三只耳朵
 * @Date: 2020/2/24 12:01
 * @Description:
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.dhr.springcloud"})
public class DeptConsumerFeign_80 {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerFeign_80.class, args);
    }
}