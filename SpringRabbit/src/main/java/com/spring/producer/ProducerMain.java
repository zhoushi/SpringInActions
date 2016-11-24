package com.spring.producer;


import com.spring.domain.Demo;
import com.spring.domain.Spittle;
import com.spring.service.DemoService;
import com.spring.service.impl.DemoServiceImpl;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.util.Date;

@Ignore
public class ProducerMain {

  public static void main(String[] args) throws Exception {
    
    ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    AmqpTemplate template = (AmqpTemplate) context.getBean("rabbitTemplate");


    DemoServiceImpl demoService = (DemoServiceImpl) context.getBean("demoServiceImpl");
    
    for (int age=18; age < 20; age++) {
      System.out.println("Sending message #" + age);

//      Spittle spittle = new Spittle((long) i, null, "Hello world (" + i + ")", new Date());
      Demo demo = demoService.queryId(age);
      //上传消息
      template.convertAndSend(demo);
      Thread.sleep(5000);
    }
    
    System.out.println("Done!");
    
  }

}
