

# nginx配置文件include导入说明


### 配置实例

include可以用在任何地方，前提是include的文件自身语法正确。

include文件路径可以是绝对路径，也可以是相对路径，相对路径以nginx.conf为基准，同时可以使用通配符。

```shell
# 绝对路径
include /etc/conf/xxxx.conf
# 相对路径
include port/xxxx.conf
# 通配符
include *.conf
```

### 测试配置文件

```shell
./nginx -t
```


### 主模式配置

> 主配置文件： nginx.conf

```
user  root;
worker_processes  auto;

error_log  /var/log/nginx/error.log notice;
pid        /var/run/nginx.pid;

events {
    worker_connections  1024;
}

http {
    include       /etc/nginx/mime.types;
    default_type  application/octet-stream;
    log_format  main  '$remote_addr - $remote_user [$time_local] "$request" '
                      '$status $body_bytes_sent "$http_referer" '
                      '"$http_user_agent" "$http_x_forwarded_for"';

    access_log  /var/log/nginx/access.log  main;
    # access_log off;
    sendfile        on;
    #tcp_nopush     on;

    keepalive_timeout  65;
    #gzip  on;
    
    # 要点1： 为了让这个配置文件简单一些，将http配置conf放入到nginx/conf.d/下,并以.conf做后缀名。
    include /etc/nginx/conf.d/*.conf;
    
    map $http_upgrade $connection_upgrade {
        default upgrade;
        '' close;
    }
}

stream {
    log_format basic '$remote_addr [$time_local] '
                 '$protocol $status $bytes_sent $bytes_received '
                 '$session_time';
    access_log /var/log/nginx/stream-access.log basic buffer=32k;
    
    # 要点2： 为了让这个配置文件简单一些，将配置stream放入到nginx/conf.d/下，并以.stream做后缀名。
    # 需要为每个端口创建一个.stream做后缀名的配置文件
    include /etc/nginx/conf.d/*.stream;
}

```

### 分文件(http类)

> 文件位置: nginx/conf.d/nacos.conf
```shell
# nacos集群配置（http配型）
upstream  nacos-cluster {
    server xxx.xxx.xxx.2:8848;
    server xxx.xxx.xxx.3:8848;
    server xxx.xxx.xxx.4:8848;
}
server {
    listen       8902;
    listen  [::]:8902;
    server_name  localhost;
    access_log off;
    #access_log  /var/log/nginx/host.access.log  main;
    location / {
        proxy_pass http://nacos-cluster/;
    }
}
```

### 分文件(stream类)

> 文件位置: nginx/conf.d/nacos.stream
```shell
# nacos 9902，9903端口负载均衡（TCP类型）
upstream  nacos-cluster-9902 {
    server xxx.xxx.xxx.2:9848;
    server xxx.xxx.xxx.3:9848;
    server xxx.xxx.xxx.4:9848;
}

upstream  nacos-cluster-9903 {
    server xxx.xxx.xxx.2:9849;
    server xxx.xxx.xxx.3:9849;
    server xxx.xxx.xxx.4:9849;
}
server {
    listen       9902;
    proxy_connect_timeout 10s;
    proxy_timeout 300s;
    proxy_pass nacos-cluster-9902;
}

server {
    listen       9903;
    proxy_connect_timeout 10s;
    proxy_timeout 300s;
    proxy_pass nacos-cluster-9903;
}
```

