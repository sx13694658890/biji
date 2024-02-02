
Expires头 使用特定的时间  要求 服务器和客户端的始终严格同步



HTTP1.1  引用 Cache-Control

Cache-Control 使用 max-age 指令指定组件被缓存多久 以秒为单位定义一个更新窗

ExpiresDefault:

```
headers:{
    Cache-Control:max-age=12345353,
    
}
```

### gzip 
客户端可以通过HTTP请求中的Accept-Encoding头来标识对压缩的支持
服务端看到请求中有这个头   就会列出来 Content-Encoding:gzip

mod_gzip_minimum_file_size 指令控制希望压缩的文件最小值

配置gzip 取决于apache版本 apache1.3使用 mod_gzip
apache2.0  通过mod_deflate


Web服务器的响应添加Vary头  Web服务器可以告诉代理根据一个 压缩的决定基于Accept-Encoding
```
Vary:Accept-Encoding,User-Agent

```


### 可视化回馈
1  让用户知道系统没有崩溃
2  指出用户还需等待多久
3  提供可以看的内容
4  图形进度条


### css 放在顶部