package com.dhr.springcloud.mapper;

import com.dhr.springcloud.entity.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: 皮卡丘的三只耳朵
 * @Date: 2020/2/23 21:49
 * @Description:
 */
@Mapper
@Repository
public interface DeptMapper {
    Boolean addDept(Dept dept);

    Dept queryById(Long id);

    List<Dept> queryAll();
}