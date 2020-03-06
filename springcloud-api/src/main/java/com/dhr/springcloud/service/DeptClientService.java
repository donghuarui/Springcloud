package com.dhr.springcloud.service;

import com.dhr.springcloud.entity.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT", fallbackFactory = DeptClientServiceCallback.class)
public interface DeptClientService {
    @PostMapping("/dept/add")
    Boolean addDept(Dept dept);

    @GetMapping("/dept/get/{id}")
    Dept queryDept(@PathVariable("id") Long id);

    @GetMapping("/dept/findAll")
    List<Dept> findAll();
}
