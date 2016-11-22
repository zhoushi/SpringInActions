package com.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:dubbo-provider.xml");

        context.start();
        try
        {
            //利用输入流的阻塞来模拟
            System.in.read();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
