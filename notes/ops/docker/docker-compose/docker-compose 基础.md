# docker-compose 基础

## 下载安装

```bash
# 查看版本
docker-compose version

# 下载docker-compose至/usr/local/bin/
[版本清单](https://github.com/docker/compose/tags)

curl -L "https://github.com/docker/compose/releases/download/v2.13.0/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose

# 添加执行权限
chmod +x /usr/local/bin/docker-compose

```



## 常用命令

```bash
# 创建编排docker-compose服务
docker-compose up

# 创建编排docker-compose服务, 后台启动
docker-compose up -d

# 停止docker-compose服务 不删除容器
docker-compose stop

# 停止docker-compose服务 删除容器
docker-compose down

# 启动docker-compose服务
docker-compose start

# 重启docker-compose服务
docker-compose restart

```

