# 基于websocket的单播、组播、广播的实现

> [ws客户端工具](http://www.easyswoole.com/wstool.html)


## 场景一：集群环境下单播消息的演示

1. 提前准备nginx环境，redis环境，websocket集群服务（ws1-ws3三个实例）

2. 注册一个业务域为d1，所属组为g1的客户端c1，并连接服务ws1

```
ws://10.173.211.130:8081/ws?clientId=c1&bizCode=d1&token=456&group=g1
```

3. 注册一个业务域为d1，所属组为g2的客户端c2，并连接服务ws2

```
ws://10.173.211.130:8082/ws?clientId=c2&bizCode=d1&token=456&group=g2
```

4. 注册一个业务域为d1，所属组为g1的客户端c3，并连接服务ws2

```
ws://10.173.211.130:8082/ws?clientId=c3&bizCode=d1&token=456&group=g1
```

5. 通过c1客户端发送单播消息给c2

```json
{
    "msgId":" 10001",
    "targetClientId":"c2",
    "mode":100,
    "content":"你好，c2"
}
```

6. 预期：c2能接收到c1的消息，c3没有接收到消息


## 场景二：集群环境下组播消息的演示

1. 提前准备nginx环境，redis环境，websocket集群服务（ws1-ws3三个实例）

2. 注册一个业务域为d1，所属组为g1的客户端c1，并连接服务ws1

```
ws://10.173.211.130:8081/ws?bizCode=d1&clientId=c1&group=g1&token=456
```

3. 注册一个业务域为d1，所属组为g2的客户端c2，并连接服务ws2

```
ws://10.173.211.130:8082/ws?bizCode=d1&clientId=c2&group=g2&token=456
```

4. 注册一个业务域为d1，所属组为g1的客户端c3，并连接服务ws2

```
ws://10.173.211.130:8082/ws?bizCode=d1&clientId=c3&group=g1&token=456
```

5. 注册一个业务域为d1，所属组为g1，g2的客户端c4，并连接服务ws3

```
ws://10.173.211.130:8082/ws?bizCode=d1&clientId=c4&group=g1,g2&token=456
```

6. 通过c1客户端发送组播消息给组g1

```json
{
    "msgId":" 10002",
    "group":"g1",
    "mode":200,
    "content":"g1的朋友们，大家下午好！"
}
```

7. 预期：c3和c4能接收到c1的组播消息，c2没有接收到消息

## 场景三：集群环境下广播消息的演示

1. 提前准备nginx环境，redis环境，websocket集群服务（ws1-ws3三个实例）

2. 注册一个业务域为d1，所属组为g1的客户端c1，并连接服务ws1

```
ws://10.173.211.130:8081/ws?bizCode=d1&group=g1&clientId=c1&token=456
```

3. 注册一个业务域为d1，所属组为g2的客户端c2，并连接服务ws2

```
ws://10.173.211.130:8082/ws?bizCode=d1&group=g2&clientId=c2&token=456
```

4. 注册一个业务域为d1，所属组为g1的客户端c3，并连接服务ws2

```
ws://10.173.211.130:8082/ws?bizCode=d1&group=g1&clientId=c3&token=456
```

5. 注册一个业务域为d1，所属组为g1，g2的客户端c4，并连接服务ws3

```
ws://10.173.211.130:8082/ws?bizCode=d1&group=g1,g2&clientId=c4&token=456
```

6. 注册一个业务域为d2，所属组为g1，g2的客户端c5，并连接服务ws3

```
ws://10.173.211.130:8083/ws?bizCode=d2&group=g1,g2&clientId=c5&token=456
```

7. 通过c1客户端发送广播消息
```json
{
    "msgId":" 10003",
    "mode":300,
    "content":"d1频道的朋友们，你们好！"
}
```

8. 预期：c2，c3，c4能接收到广播消息，c5不能接收到消息


## 场景四：集群环境下客户端连接nginx实现负载均衡

1. 提前准备nginx环境，redis环境，websocket集群服务（ws1-ws3三个实例）
2. 注册一个客户端到nginx的ws代理地址

```
ws://10.173.211.130:8080/ws?bizCode=d1&group=g1&clientId=c1&token=456
```

3. 配置客户端定时发送心跳消息
```json
{
    "msgId":"10004",
    "mode":1
}
```

4. 预期：客户端能接受到心跳响应数据
