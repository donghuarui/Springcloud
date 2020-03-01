package com.dhr.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Auther: 皮卡丘的三只耳朵
 * @Date: 2020/2/24 20:46
 * @Description: 启动之后 访问 http://localhost:7003/
 */
@SpringBootApplication
@EnableEurekaServer //服务端启动类，可以让别人来注册自己
public class EurekaServer_7003 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer_7003.class, args);
    }
}