package com.spring.Serialization;

/**
 * Created by Administrator on 2016/11/28.
 */

import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * 通过hessian进行系列化
 */
public class Hessian {


    public static void main(String...args) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();

        //Hessian的序列化输出
        HessianOutput ho = new HessianOutput(os);

        User user = new User("shi",19);

        //写入对象
        ho.writeObject(user);

        //拿出数组
        byte[] bytes = os.toByteArray();

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        HessianInput hessianInput = new HessianInput(byteArrayInputStream);

        User user1 = (User) hessianInput.readObject();

        System.out.println(user1.toString());
    }
}
