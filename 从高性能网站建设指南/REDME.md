
Expires头 使用特定的时间  要求 服务器和客户端的始终严格同步



HTTP1.1  引用 Cache-Control

Cache-Control 使用 max-age 指令指定组件被缓存多久 以秒为单位定义一个更新窗

ExpiresDefault:

```
headers:{
    Cache-Control:max-age=12345353
}
```