package com.dao;

import com.domain.Spittle;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2016/11/23.
 */
public class AlertServiceImpl implements  AlertService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendSpittleAlert(Spittle spittle) {
        rabbitTemplate.convertAndSend("spittle.alert.exchange",
                "spittle.alerts",spittle);
    }
}
