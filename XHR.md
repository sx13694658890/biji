ArrayBuffer Blob Document JSON Text

可以依靠 HTTP 的 content-type 首部来推断适当的数据类型



Event Stream协议
SSE 事件流是以流式 HTTP 响应形式交付的
客户端发起常规 HTTP 请求，服务器 以自定义的“text/event-stream”内容类型响应，然后交付 UTF-8 编码的事件数据

GET/stream
Accept text/event-stream

如果你想传输二进制数据，WebSocket 才是更 合适的选择。