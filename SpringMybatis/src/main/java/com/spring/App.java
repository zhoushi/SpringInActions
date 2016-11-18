package com.spring;

import com.spring.domain.Spitter;
import com.spring.service.ISpitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        ISpitterService S;
        S = (ISpitterService) context.getBean("spitterService");

        List<Spitter> list = S.findAllSpitters();
        System.out.println(list.toString());
    }

}
