package com.spring.Serialization;

import java.io.*;

/**
 * Created by Administrator on 2016/11/28.
 */

/**
 * 通过jdk序列化对象
 */
public class JDKSerialization {
    public static void main(String...args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        //对象输出流
        ObjectOutputStream out = new ObjectOutputStream(os);
        //将对象写入到字节数组输出，进行序列化
        User user = new User("zhou",18);
        out.writeObject(user);
        //字节数组
        byte[] userBytes = os.toByteArray();

        //字节数组输入流
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(userBytes);

        //进行反序列化
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);

        User user1 = (User) objectInputStream.readObject();

        //
        System.out.println(user1.toString());
        //序列化过后，不是原对象
        boolean b = user == user1 ? true : false;
        System.out.println(b);

    }
}
