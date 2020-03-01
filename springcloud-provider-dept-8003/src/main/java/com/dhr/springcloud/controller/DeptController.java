package com.dhr.springcloud.controller;

import com.dhr.springcloud.entity.Dept;
import com.dhr.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: 皮卡丘的三只耳朵
 * @Date: 2020/2/23 22:03
 * @Description: 提供 Restful 服务
 */
@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptService deptService;

    @Autowired
    private DiscoveryClient client;

    @PostMapping("/add")
    public boolean addDept(@RequestBody Dept dept) {
        System.err.println("23" + dept);
        return deptService.addDept(dept);
    }

    @GetMapping("/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return deptService.queryById(id);
    }


    @GetMapping("/findAll")
    public List<Dept> findAll() {
        return deptService.queryAll();
    }


    /**
     * 注册进来的微服务，获取一些信息
     * @return
     */
    @GetMapping("/discovery")
    public Object discovery() {
        //获取微服务列表的清单
        List<String> services = client.getServices();
        System.err.println("discover=>services:" + services);

        //得到一个具体的微服务信息，通过具体的微服务id,applicationName;
        List<ServiceInstance> instances = client.getInstances("springcloud-provider-dept");
        for (ServiceInstance instance : instances) {
            System.err.println(instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri() + "\t" + instance.getServiceId());
        }
        return this.client;
    }


}