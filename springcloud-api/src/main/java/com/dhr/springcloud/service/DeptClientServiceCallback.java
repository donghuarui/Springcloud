package com.dhr.springcloud.service;

import com.dhr.springcloud.entity.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeptClientServiceCallback implements FallbackFactory {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public Boolean addDept(Dept dept) {
                return null;
            }

            @Override
            public Dept queryDept(Long id) {
                return new Dept().setDeptno(id).setDname("服务降级").setDb_source("no data source");
            }

            @Override
            public List<Dept> findAll() {
                return null;
            }
        };
    }
}
