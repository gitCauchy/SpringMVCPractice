<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Json 交互测试</title>
</head>
<script type = "text/javascript" src = "${pageContext.request.contextPath}/js/jQuery.js"></script>
<script type="text/javascript">
// 请求的是Json，输出的是Json
function requestJson(){
	$.ajax({
		type:'post',
		url:'${pageContext.request.contextPath}/item/requestJson.action',
		contentType:'application/json;charset=utf-8',
		// 数据格式是Json串
		data:'{"name":"milk"}',
		success:function(data){
			alert(data.price);
		}
	});
}
//请求的是键值对，输出的是Json
function responseJson(){
	$.ajax({
		type:'post',
		url:'${pageContext.request.contextPath}/item/responseJson.action',
		// 数据格式是Json串
		data:'name=milk&price=3.0',
		success:function(data){
			alert(data);
		}
	});
}
</script>
<body>
<input type = "button" onclick = "requestJson()" value = "请求Json">
<br/>
<input type = "button" onclick = "responseJson()" value = "请求K/V">
</body>
</html>