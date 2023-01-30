# docker 配置指导

## 更换镜像源

1. 您可以修改 /etc/docker/daemon.json 文件并添加上 registry-mirrors 键值。

```bash
vi /etc/docker/daemon.json
```
添加如下配置

```json
{
  "registry-mirrors": [
    "http://hub-mirror.c.163.com",
    "https://docker.mirrors.ustc.edu.cn",
    "https://registry.docker-cn.com"
  ]
}
```

3. 查看是否成功

```bash
docker info
```


4. 更新配置：

```bash
sudo systemctl daemon-reload
sudo systemctl restart docker
```


## Docker 设置 http,https socks5 代理

1. 为 docker 服务创建一个内嵌的 systemd 目录

```bash
mkdir -p /etc/systemd/system/docker.service.d
```
2. 创建 /etc/systemd/system/docker.service.d/https-proxy.conf 文件，并添加 HTTP_PROXY, 或 HTTPS_PROXY 环境变量。

```bash
cd /etc/systemd/system/docker.service.d
sudo vi https-proxy.conf
```
> 其中 ip 和 port,NO_PROXY 分别改成实际情况的代理地址和端口：

**https-proxy.conf**

```properties
[Service]
Environment="HTTP_PROXY=socks5://10.173.11.152:1082/" "HTTPS_PROXY=socks5://10.173.11.152:1082/"
```

3. 更新配置：

```bash
sudo systemctl daemon-reload
sudo systemctl restart docker
```
