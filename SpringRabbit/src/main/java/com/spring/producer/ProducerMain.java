package com.spring.producer;


import com.spring.domain.Spittle;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.util.Date;

@Ignore
public class ProducerMain {

  public static void main(String[] args) throws Exception {
    
    ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
    AmqpTemplate template = (AmqpTemplate) context.getBean("rabbitTemplate");
    
    for (int i=0; i < 20; i++) {
      System.out.println("Sending message #" + i);

      Spittle spittle = new Spittle((long) i, null, "Hello world (" + i + ")", new Date());
      //上传消息
      template.convertAndSend(spittle);
      Thread.sleep(5000);
    }
    
    System.out.println("Done!");
    
  }

}
