package com.spring.dao;

import com.spring.domain.Demo;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2016/11/24.
 */
public interface DemoDao {

    Demo queryId(@Param("age") int age);
}
