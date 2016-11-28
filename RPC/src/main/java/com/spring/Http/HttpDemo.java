package com.spring.Http;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by Administrator on 2016/11/28.
 */
public class HttpDemo {

    public static void main(String...args){

        String url = "http://www.baidu.com";
        //组装请求
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);

        //接收响应
        try {
            HttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();

            byte[] bytes = EntityUtils.toByteArray(entity);
            //将数组转换成字符串
            String result = new String(bytes,"utf8");
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
