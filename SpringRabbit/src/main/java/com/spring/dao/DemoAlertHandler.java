package com.spring.dao;

import com.spring.domain.Demo;

/**
 * Created by Administrator on 2016/11/24.
 */
public class DemoAlertHandler {

    public void handleSpittleAlert(Demo demo){
        System.out.println(demo.toString());
    }
}
