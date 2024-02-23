



let pageWidth = window.innerWidth,
    pageHeight = window.innerHeight;
console.log(document.body.clientWidth);


// 检查页面是否处于标准模式
if(document.compatMode=='CSS1Compat'){
    pageWidth = document.documentElement.clientWidth;
    pageHeight =document.documentElement.clientHeight;
}else{
    pageWidth = document.body.documentElement.clientWidth;
    pageHeight =document.body.clientHeight;
}
// window.resizeTo(100, 100);
// window.resizeBy(100, 50);
// 相对于当前视口向下滚动 100 像素 
// window.scrollBy(0, 100);
let wroxWin=window.open("http://www.wrox.com/", "wroxWindow",
"height=400,width=400,top=10,left=10,resizable=yes");
// 缩放 
wroxWin.resizeTo(50, 50);
// 移动 
wroxWin.moveTo(400, 200);