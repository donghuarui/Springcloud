package com.dhr.springcloud.controller;

import com.dhr.springcloud.entity.Dept;
import com.dhr.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
        return deptService.addDept(dept);
    }

    @GetMapping("/get/{id}")
    @HystrixCommand(fallbackMethod = "hystrix_get")
    public Dept get(@PathVariable("id") Long id) {
        Dept dept = deptService.queryById(id);
        if (dept == null) {
            throw new RuntimeException("id=>" + id + "不存在该用户,或信息无法找到");
        }
        return dept;
    }

    /**
     * 备选方法
     *
     * @param id
     * @return
     */
    public Dept hystrix_get(@PathVariable("id") Long id) {
        return new Dept().setDeptno(id).setDname("该用户不存在").setDb_source("no data source");
    }

    @GetMapping("/findAll")
    @HystrixCommand(fallbackMethod = "hystrix_findAll")
    public List<Dept> findAll() {
        if ("2" == null) {
            throw new RuntimeException("id=>" + "不存在该用户,或信息无法找到");
        }
        return deptService.queryAll();
    }


    /**
     * 备选方法
     *
     * @param
     * @return
     */
    public List<Dept> hystrix_findAll() {
        List<Dept> depts = new ArrayList<>();
        Dept dept = new Dept().setDeptno((long) 1).setDname("该用户不存在").setDb_source("no data source");
        depts.add(dept);
        return depts;
    }

    /**
     * 注册进来的微服务，获取一些信息
     *
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