

```shell
  telnet website.org 80
```


HTTP 权威指南  可以参考

JavaScript 及后来 DHTML 和 Ajax 的加入，再一次革命了 Web，把简单的网页 转换成了交互式 Web 应用
Outlook Web Access(IE5 中的 XMLHTTP 就诞生于这个应用)


提升应用性能。大多数浏览器都利用了如下四种技术

1. 资源预取和排定优先次序
2. DNS预解析
3. TCP预连接
4. 页面预渲染


CSS 和 JavaScript 等重要资源应该尽早在文档中出现;
• 应该尽早交付 CSS，从而解除渲染阻塞并让 JavaScript 执行;
• 非关键性 JavaScript 应该推迟，以避免阻塞 DOM 和 CSSOM 构建;
• HTML 文档由解析器递增解析，从而保证文档可以间隙性发送，以求得最佳性能

```javascript

```

具体可以参考 https://www.igvita.com/posa/high-performance-networking-in-google-chrome/#history


HTTP 1.1

 持久化连接以支持连接重用;
• 分块传输编码以支持流式响应;
• 请求管道以支持并行请求处理;
• 字节服务以支持基于范围的资源请求;  • 改进的更好的缓存机制。

HTTP 权威指南》(David Gourley 和 Brian Totty 合著
Steve Souder 的《高性能网站建设指南》

1. 减少DNS查询
    每次域名解析都需要一次网络往返，增加请求的延迟，在查询期间会阻塞请求
2. 减少HTTP请求
    任何请求都不如没有请求更快，因此要去掉页面上没有必要的资源。
3. 使用CDN
    从地理上把数据放到接近客户端的地方，可以显著减少每次 TCP 连接的网络延 迟，增加吞吐量
 4. 添加Expires首部并配置ETag标签
    相关资源应该缓存，以避免重复请求每个页面中相同的资源。Expires 首部可用 于指定缓存时间，在这个时间内可以直接从缓存取得资源，完全避免 HTTP 请 求。ETag 及 Last-Modified 首部提供了一个与缓存相关的机制，相当于最后一次 更新的指纹或时间戳。
5. Gzip资源
    所有文本资源都应该使用 Gzip 压缩，然后再在客户端与服务器间传输。一般来 说，Gzip 可以减少 60%~80% 的文件大小，也是一个相对简单(只要在服务器上 配置一个选项)，但优化效果较好的举措
6. 避免HTTP重定向
    HTTP 重定向极其耗时，特别是把客户端定向到一个完全不同的域名的情况下， 还会导致额外的 DNS 查询、TCP 连接延迟，等等


如果只能使用 HTTP 1.0，则可以明确使用 Connection: Keep-Alive 首部声明使用持久连接。
HTTP/1.1 200 OK
Accept-Ranges: bytes
Cache-Control: max-age=315360000
Connection: keep-alive
Content-Length: 0
Content-Type: image/gif
Date: Fri, 29 Dec 2023 08:34:53 GMT
Etag: "657fd308-0"
Expires: Mon, 26 Dec 2033 08:34:53 GMT
Last-Modified: Mon, 18 Dec 2023 05:05:12 GMT
Server: Apache 2.0
Set-Cookie: BDORZ=B490B5EBF6F3CD402E515D22BCDA1598; max-age=86400; domain=.baidu.com; path=/

只要必须支持 HTTP 1.x 客户端，就不得不想办法应对多 TCP 流的问题
限制每个主机最多 6 个连接，可以让浏览器检测出无意(或有意)的 DoS(Denial of Service)攻击。
客户端有可能消耗掉服务器的所有资源


```shell
curl --trace-ascii - -d'{"msg":"hello"}' http://www.igvita.com/api

```

计算图片对内存的需求
1. 所有编码的图片经浏览器解析后都会以 RGBA 位图的形式保存于内存当中
RGBA 图片的像素需要占用 4 字节:红、绿、蓝通道各占 1 字节，Alpha(透明) 通道占 1 字节。
一张图片占用的内存量就是图片像素宽度 × 像素高 度 ×4 字节。
谷歌 PageSpeed 团队的测试表明，30~50 KB(压缩后)是每个 JavaScript 文件大小的合适范围: 既大到了能够减少小文件带来的网络延迟，还能确保递增及分层式的执行。具体 的结果可能会由于应用类型和脚本数量而有所不同。



提升首次加载性能，Gmail 团队尝试了各种技术，
1. 把首次绘制所需的 CSS 单独拿出来，优先于其他 CSS 文件发送;
2. 递增地交付较小的 JavaScript 块，以实现递增式执行;

嵌入资源是另一种非常流行的优化方法，

图片甚至音频或 PDF 文件，都可以通过数据 URI(data:[mediatype] [;base64],data)的方式嵌入到页面中

但非文本性资源则必须通过 base64 编码，而这会导致开销明显增大: 编码后的资源大小比原大小增大 33% !
实践中，常见的一个经验规则是只考虑嵌入 1~2 KB 以下的资源，因为小于这个标 准的资源经常会导致比它自身更高的 HTTP 开销。