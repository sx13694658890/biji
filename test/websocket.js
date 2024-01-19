
var ws=new WebSocket("wss://example.com",['appProtocol'])
ws.binaryType='arraybuffer'
ws.onerror = function (error) { ... } 
ws.onclose = function () { ... }
ws.onopen=function(){
    ws.send('Connection estab')
}
ws.onmessage=function(msg){
    if(msg.data instanceof Blob){
        processBlob(msg.data )
    }else{
        processText(msg.data)
    }
}