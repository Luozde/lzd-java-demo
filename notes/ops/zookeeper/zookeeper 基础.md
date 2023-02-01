# zookeeper 基础

## zookeeper 基本原理与介绍

> https://www.open-open.com/lib/view/open1415453633887.html#articleHeader12

## 集群部署

1. [下载docker-compose脚本](./zookeeper%20基础.md)

2. 启动服务

```bash
docker-compose up
```

更多指令请参考 [docker-compose 基础](../docker/docker-compose/docker-compose%20基础.md)

3. 查看zookeeper集群节点主从关系

```bash
docker exec -it zk1 /bin/bash 

./bin/zkServer.sh status
```


