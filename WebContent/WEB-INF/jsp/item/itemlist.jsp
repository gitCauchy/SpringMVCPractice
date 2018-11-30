<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品信息查询</title>
<script type="text/javascript">
function deleteItem(){
	// 提交form
	document.itemForm.action="${pageContext.request.contextPath}/item/deleteItem.action";
	document.itemForm.submit();
}
function queryItem(){
	// 提交from
	document.itemFrom.action="${pageContext.request.contextPath}/item/queryItem.action";
	document.itemForm.submit();
}
</script>
</head>
<body>
<form name = "itemForm" action="${pageContext.request.contextPath}/item/queryItem.action" method = "post">
查询条件：
<table width="100%" border=1>
	<tr>
		<td>商品名称：<input name = "itemCustom.name"></td>
		<td>
			<input type = "button" value = "查询" onclick = "queryItem()"/>
			<input type = "button" value = "批量删除" onclick = "deleteItem()"/>
		</td>
	</tr>
</table>
商品列表：
<table width = "100%" border = 1>
	<tr>
		<td>选择</td>
		<td>商品名称</td>
		<td>商品价格</td>
		<td>生产日期</td>
		<td>商品描述</td>
		<td>操作</td>
	</tr>
	<c:forEach items="${itemList}" var ="item">
		<tr>
			<td><input type = "checkbox" name = "item_id" value = "${item.id}"></td>
			<td>${item.name}</td>
			<td>${item.price}</td>
			<td><fmt:formatDate value = "${item.creattime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			<td>${item.detail}</td>
			<td><a href="${pageContext.request.contextPath}/item/editItem.action?id=${item.id}">修改</a></td>
		</tr>
	</c:forEach>
</table>
</form>
</body>
</html>