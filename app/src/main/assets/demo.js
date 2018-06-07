 var s = '我来自Js方法';
function javatojscallback(param){
     document.getElementById("textshow").innerHTML = (param);
     window.android.JsToJavaInterface(s)
}
function javatojswith(param){
     document.getElementById("textshow").innerHTML = (param);
     return s;
}
function jstojavaprompt(param){
     result = prompt(param);
     document.getElementById("textshow").innerHTML = (result);
}