package com.spring.service.impl;

import com.spring.dao.DemoDao;
import com.spring.domain.Demo;
import com.spring.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/11/24.
 */
@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    DemoDao demoDao;
    public Demo queryId(int age) {
        return demoDao.queryId(age);
    }
}
