package com.dhr.springcloud.service.impl;

import com.dhr.springcloud.service.DeptService;
import com.dhr.springcloud.entity.Dept;
import com.dhr.springcloud.mapper.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: 皮卡丘的三只耳朵
 * @Date: 2020/2/23 22:01
 * @Description:
 */
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptDao;

    @Override
    public Boolean addDept(Dept dept) {
        System.err.println(dept);
        return deptDao.addDept(dept);
    }

    @Override
    public Dept queryById(Long id) {
        return deptDao.queryById(id);
    }

    @Override
    public List<Dept> queryAll() {
        return deptDao.queryAll();
    }
}