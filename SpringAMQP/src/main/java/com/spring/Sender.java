package com.spring;

import com.spring.bean.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/24.
 */
public class Sender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    List<User> userList = new ArrayList<>();

    User user = new User("zhou",18);

    //定时任务,每一秒发送一次
    @Scheduled(fixedDelay = 1000L)
    public void send(){
        //发送一个数据对象
        this.rabbitTemplate.convertAndSend("foo","hello",user);
    }
}
