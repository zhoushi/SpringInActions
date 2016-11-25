package com.service.impl;

import com.dao.DemoDao;
import com.domain.Demo;
import com.service.DemoService;
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
