package com.spring.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/11/25.
 */
@Component("myBean")
public class MyBean {

//    @Scheduled(cron = "0 0/10 * * * ?")
    public void printMessage(){
        System.out.println("i am mybean");
    }
}
