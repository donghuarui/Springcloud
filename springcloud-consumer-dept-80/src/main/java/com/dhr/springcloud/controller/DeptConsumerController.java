package com.dhr.springcloud.controller;

import com.dhr.springcloud.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Auther: 皮卡丘的三只耳朵
 * @Date: 2020/2/24 11:29
 * @Description:
 */
@RestController
public class DeptConsumerController {

    @Autowired
    private RestTemplate restTemplate;//提供多种便捷访问远程http服务的方法，简单的restful服务模板

    //Ribbon 我们这里的地址，应该是一个变量，通过服务名来访问
    //    private static final String REST_URL_PREFIX = "http://localhost:8001";
    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT";

    @RequestMapping("/consumer/dept/add")
    public Boolean add(Dept dept) {
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
    }

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
    }

    @RequestMapping("/consumer/dept/findAll")
    public List<Dept> findAll() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/findAll", List.class);
    }
}