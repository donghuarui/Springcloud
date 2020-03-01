package com.dhr.springcloud.service;

import com.dhr.springcloud.entity.Dept;

import java.util.List;

/**
 * @Auther: 皮卡丘的三只耳朵
 * @Date: 2020/2/23 22:00
 * @Description:
 */
public interface DeptService {
    Boolean addDept(Dept dept);

    Dept queryById(Long id);

    List<Dept> queryAll();
}
