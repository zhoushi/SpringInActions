### redis与spring整合

```
q: spring整合过程

a: 实现JedisConnectionFactory bean 再使用RedisTemplate，使用模板方法进行存储数据

q: 在存取数据时，数据存不上redis数据库上去

a: 在用spring-data-redis上时要用序列化接口不然数据无法存储到redis数据库上去

q: 通过系列化存储，原对象与取出的对象不在同一个内存地址

a: 对象序列化过程，会将对象的所有属性全部序列化，所以根据这个特点是用对象序列化结合反序列化可以完成对象的
【深度复制】深度复制会把底层的对象也复制出新的对象
```