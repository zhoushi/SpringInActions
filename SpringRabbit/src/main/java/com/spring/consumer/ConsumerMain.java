package com.spring.consumer;

import com.spring.dao.DemoAlertHandler;
import com.spring.dao.SpittleAlertHandler;
import com.spring.domain.Demo;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class ConsumerMain {

  public static void main(String[] args) throws IOException {
    /**
     * 常规的得到消息
     */
//    //得到bean工厂
//    ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//    //得到bean
//    RabbitTemplate  template = (RabbitTemplate) context.getBean("rabbitTemplate2");
//    //收到信息
//    Message message =template.receive();
//    System.out.println(message.toString());
//    //信息转换
//    Demo demo = (Demo) template.receiveAndConvert("spittle.alerts");
//    System.out.println(demo.toString());

//    System.out.println(message.toString());
//    SpittleAlertHandler spittleAlertHandler;
    /**
     * 消息驱动
     */
    ApplicationContext context = new ClassPathXmlApplicationContext("amqp-shared.xml");
    DemoAlertHandler demoAlertHandler;
    System.in.read();
  }

}
