package com.Redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Created by Administrator on 2016/11/25.
 */
@Configuration
public class RedisConfig {
    /**
     * 注入redis连接工厂bean，让spring管理
     * @return
     * 默认情况下会向localhost上的6379端口创建连接
     */
    @Bean
    public RedisConnectionFactory redisCF(){
        JedisConnectionFactory cf = new JedisConnectionFactory();
        cf.setHostName("127.0.0.1");
        cf.setPort(6379);
        return cf;
    }

    /**
     * 注入RedisTemplate Bean
     * RedisTemplate可以极大地简化Redis数据访问，能够让我们持久化各种类型的key和value
     * StringRedisTemplate扩展了RedisTemplate只关注String类型
     * @param cf
     * @return
     */
    @Bean
    public RedisTemplate<String,Product> redisTemplate(RedisConnectionFactory cf){
        RedisTemplate<String,Product> redis = new RedisTemplate<>();
        redis.setConnectionFactory(cf);
        redis.setKeySerializer(new StringRedisSerializer());
        redis.setValueSerializer(new Jackson2JsonRedisSerializer<Product>(Product.class));
        return redis;
    }

    @Bean
    public RedisTemplate<String,String> redisTemplate1(RedisConnectionFactory connectionFactory){
        RedisTemplate<String,String> redis = new RedisTemplate<String, String>();
        redis.setConnectionFactory(connectionFactory);
        redis.setKeySerializer(new StringRedisSerializer());
        redis.setValueSerializer(new StringRedisSerializer());
        return redis;
    }
}
