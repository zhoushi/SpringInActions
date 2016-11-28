package com.producer;


import com.alibaba.fastjson.JSON;
import com.domain.Demo;
import com.service.impl.DemoServiceImpl;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Ignore
public class ProducerMain {

  public static void main(String[] args) throws Exception {
    
    ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

    //得到teplate bean
    AmqpTemplate template = (AmqpTemplate) context.getBean("rabbitTemplate");


    DemoServiceImpl demoService = (DemoServiceImpl) context.getBean("demoServiceImpl");
    
    for (int age=18; age < 20; age++) {
      System.out.println("Sending message #" + age);

//      Spittle spittle = new Spittle((long) i, null, "Hello world (" + i + ")", new Date());
      Demo demo = demoService.queryId(age);
      String sendMessage = JSON.toJSONString(demo);
      //上传消息
      template.convertAndSend(sendMessage);
      Thread.sleep(5000);
    }
    
    System.out.println("Done!");
    
  }

}
