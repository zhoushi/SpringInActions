package com.spring.RPC;

/**
 * Created by Administrator on 2016/11/28.
 */

/**
 * 服务实现
 */
public class SayHelloServiceImpl implements SayHelloService {
    public String sayHello(String s) {
        if (s.equals("hello")){
            return "hello";
        }else {
            return "bye,bye";

        }
    }
}
