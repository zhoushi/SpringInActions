package com.spring.Test;

import com.spring.Redis.Product;
import com.spring.Redis.RedisConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by Administrator on 2016/11/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RedisConfig.class)
public class RedisTest {
    /**
     * 得到注入的bean
     */
    @Autowired
    private RedisConnectionFactory cf;

    @Autowired
    private RedisTemplate<String,Product> redisTemplate;

    @Autowired
    private RedisTemplate<String,String> redisTemplate1;

    @Test
    public void workingWithSimpleValues(){
        Product product = new Product();
        product.setSku("9781617291203");
        product.setName("Spring in Action");
        product.setPrice(39.99f);

        //保存Product
        redisTemplate.opsForValue().set(product.getSku(), product);
        //得到Product 对象
        Product product1 = redisTemplate.opsForValue().get("9781617291203");
        System.out.println(product1!=product?true:false);
    }

    @Test
    public void workingWithSimpleValuesList(){
        Product product1 = new Product();
        product1.setSku("9781617291201");
        product1.setName("Spring in Action1");
        product1.setPrice(39.97f);

        Product product2 = new Product();
        product2.setSku("9781617291202");
        product2.setName("Spring in Action2");
        product2.setPrice(39.98f);

        Product product3 = new Product();
        product3.setSku("9781617291203");
        product3.setName("Spring in Action3");
        product3.setPrice(39.96f);

        //存放集合 rightPush会在列表尾部添加一个元素,而leftPush则会在列表的头部添加一个值
        redisTemplate.opsForList().rightPush("cart",product1);
        redisTemplate.opsForList().rightPush("cart",product2);
        redisTemplate.opsForList().rightPush("cart",product3);


    }

    @Test
    public void StringAndString(){
        Jedis jedis=new Jedis("127.0.0.1",6379);
        jedis.set("123","123");
        System.out.println(jedis.get("123"));

       // redisTemplate1.opsForValue().set("12","bb");
//        JedisPool jedisPool= (JedisPool) cf.getConnection();
//        String s = redisTemplate1.opsForValue().get("bb");
//        System.out.println(s);
    }
}
