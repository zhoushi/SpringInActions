package com.spring.RPC;

/**
 * Created by Administrator on 2016/11/28.
 */

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * 服务生产者
 */
public class Provider {

    public static void main(String...args) throws Exception {
        ServerSocket server = new ServerSocket(1234);
        //模拟将bean放入
        Map services = new HashMap();
        services.put("interface",new SayHelloServiceImpl());
        while (true){
            Socket socket = server.accept();

            //读取服务信息
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            String interfacename = input.readUTF();//接口名称
            String methodName = input.readUTF();//方法名称

            Class<?>[] parameterTypes = (Class<?>[])input.readObject();//参数类型
            Object[] arguments = (Object[])input.readObject();//参数对象
            //执行调用
            Class serviceinterfaceclass = Class.forName(interfacename);
            //得到接口的class
//            Class services =
            //得到服务化实现的bean实例
            Service servicess = (Service) services.get("interface");

            Method method = serviceinterfaceclass.getMethod(methodName,parameterTypes);

            Object result = method.invoke(servicess,arguments);

            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            output.writeObject(result);
//            Object service = serviceinterfaceclass.get

        }

    }


}
