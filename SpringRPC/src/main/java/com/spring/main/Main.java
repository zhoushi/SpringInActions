package com.spring.main;

import com.spring.domain.Spitter;
import com.spring.service.SpitterService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2016/11/28.
 */
public class Main {

    public static void main(String...args){
        test1();
    }

    public static void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        SpitterService spitterService = (SpitterService)context.getBean("spitterService");

        Spitter s = new Spitter();
        //让他出现错误,看事务是否回滚
        s.setFullName("周世贤");
        s.setUsername("chownvon");
        s.setEmail("2332123@qq.com");
        s.setPassword("123456");

        spitterService.saveSpitter(s);
    }
}
