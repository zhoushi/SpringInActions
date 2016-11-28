### 大型分布式网站结构设计与实践

* 对象的序列化
```
将对象转换为二进制的过程称为对象的序列化
将二进制流恢复为对象的过程称为对象的反序列化

Protocal Buffers对象序列化工具
```

* 基于TCP协议实现RPC

```

```

* 基于HTTP协议的RPC
```

```

* RESTful和RPC
```
RPC风格的URL：直接在HTTP请求的参数中标明需要远程调用的服务接口名称、服务需要的参数即可
RESTful风格：通过HTTP请求对应的POST、GET、PUT、DELETE方法，来完成对应的CRUD操作
```