#### RabbitMQ 消息队列

```
项目整合了spring+mybatis+RabbitMQ

RabbitMQ 的定义
生产者==》Exchange-->队列==》消费者

生产者将信息发布到一个Exchange:Exchange会绑定到一个或者多个队列上，它负责将信息路由
到队列上

q:上传的消息为一个对象 ， 在消费者接收信息时无法拿到对象

```