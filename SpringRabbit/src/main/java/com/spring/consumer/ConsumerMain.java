package com.spring.consumer;

import com.spring.dao.SpittleAlertHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class ConsumerMain {

  public static void main(String[] args) throws IOException {
    ApplicationContext context = new ClassPathXmlApplicationContext("amqp-consumer.xml");

    SpittleAlertHandler spittleAlertHandler;
    System.in.read();
  }

}
