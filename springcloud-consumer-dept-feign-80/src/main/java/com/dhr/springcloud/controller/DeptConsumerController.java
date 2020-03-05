package com.dhr.springcloud.controller;

import com.dhr.springcloud.entity.Dept;
import com.dhr.springcloud.service.DeptClientService;
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
    private DeptClientService deptClientService;

    @RequestMapping("/consumer/dept/add")
    public Boolean add(Dept dept) {
        return deptClientService.addDept(dept);
    }

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return deptClientService.queryDept(id);
    }

    @RequestMapping("/consumer/dept/findAll")
    public List<Dept> findAll() {
        return deptClientService.findAll();
    }
}