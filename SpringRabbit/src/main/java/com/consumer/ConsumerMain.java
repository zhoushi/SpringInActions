package com.consumer;

import com.alibaba.fastjson.JSON;
import com.dao.SpittleAlertHandler;
import com.domain.Demo;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class ConsumerMain {

  public static void main(String[] args) throws IOException {
    /**
     * 常规的得到消息
     */
    //得到bean工厂
    ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    //得到bean
    RabbitTemplate  template = (RabbitTemplate) context.getBean("rabbitTemplate2");
    //收到信息
    Message message =template.receive();
    System.out.println(message.toString());
//    MessageProperties demo = message.getMessageProperties();
    String newMessage = new String(message.getBody());

    Demo demo = (Demo) JSON.parseObject(newMessage,Demo.class);


    System.out.println(demo.toString());
//    Demo demo1 = (Demo) template.getMessageConverter();
    MessageConverter messageConverter = template.getMessageConverter();
    System.out.println(message.toString());
//    System.out.println(demo1.toString());
      ;
    //信息转换
//      message.getBodyContentAsString();
//      for (int  i=0;i<demo.length;i++){
//          System.out.println(demo[i]);
//      }

//    System.out.println(demo.toString());

    System.out.println(message.toString());
    SpittleAlertHandler spittleAlertHandler;
    /**
     * 消息驱动
     */
//    ApplicationContext context = new ClassPathXmlApplicationContext("amqp-shared.xml");
//    DemoAlertHandler demoAlertHandler;
//    System.in.read();
  }

}
