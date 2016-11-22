package com.spring.provider;

/**
 * Created by Administrator on 2016/11/22.
 */
public class DemoServiceImpl implements DemoService {

    public String sayHello(String name) {
        return "Hello Dubbo,Hello";
    }
}
