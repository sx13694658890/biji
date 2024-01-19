function getImageUrl() {

    var xhr = new XMLHttpRequest()
    xhr.open('GET', '/images/11.jpeg')
    xhr.responseType = 'blob'
    xhr.onload = function () {
        if (this.status == 200) {
            var image = document.createElement('img')
            image.src = window.URL.createObjectURL(this.response)
            image.onload = function () {
                window.URL.revokeObjectURL(this.src)
            }
            document.appendChild(image)
        }
    }
    xhr.send()
}

function sendFile(){
    var xhr = new XMLHttpRequest(); 
    xhr.open('POST','/upload');
    xhr.onload = function() { ... };
     xhr.send("text string"); 

     var formData = new FormData();
     formData.append('id', 123456);
     formData.append('topic', 'performance');
     xhr.send(formData);
    // multipart/form-data

     var uInt8Array = new Uint8Array([1, 2, 3]);
     xhr.send(uInt8Array.buffer); 
}

const BYTES_PER_CHUNK = 1024 * 1024
const SIZE = blob.size
var start = 0;
var end = BYTES_PER_CHUNK;
while(start<SIZE){
    var xhr = new XMLHttpRequest(); 
    xhr.open('POST','/upload');
    xhr.onload = function() { ... };
    xhr.setRequestHeader("Content-Range",start+'-'+end+'/'+SIZE)
    xhr.send(blob.slice(start,end))
    xhr.timeout=5000;
    xhr.addEventListener('load',()=>{})
    xhr.addEventListener('error',()=>{})
    xhr.upload.addEventListener("progress",(event)=>{
        if(event.lengthComputable){
            var progress=(event.loaded/event.total)*100
        }
    })
    start = end
    end = start + BYTES_PER_CHUNK
}
// XHR的进度相关事件
// loadstart   progress error abort load loadend

// 专有API和对XHR流的扩展
// Firefox 支持 moz-chunked-text 和 moz-chunked-arraybuffer
// Internet Explorer 支持 ms-stream。

var source=new EventSource("/path/to/stream-url");
source.onopen=function(){...}
source.onerror=function(){...}

source.addEventListener('foo',function(event){
    processFoo(event.data)
})
source.onmessage=function(event){
    log_message(event.id,event.data)
    if(event.id==="CLOSE"){
        source.close()
    }
}