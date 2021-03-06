package com.dhr.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Auther: 皮卡丘的三只耳朵
 * @Date: 2020/2/23 22:08
 * @Description:
 */
@SpringBootApplication
@EnableEurekaClient //在服务启动后自动注册到Eureka中
@EnableDiscoveryClient  //获取服务的一些信息,服务发现
public class DeptProvider_8001 {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider_8001.class, args);
    }

}