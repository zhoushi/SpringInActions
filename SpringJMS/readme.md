### spring消息

* spring-jms 

```
点对点消息模型:每一条消息都有一个发送者和一个接受者
发布-订阅消息模型:消息会发送给一个主题。与队列类似，多个接收者都可以监听一个主题，消息不再是只投递给一个接收者，而是主题
的所有订阅都会接收到此消息的副本

java消息服务是一个java标准，定义了使用消息代理的通用API
```