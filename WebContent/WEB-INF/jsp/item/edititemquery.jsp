<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix = "fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询商品订单</title>
<script type="text/javascript">
function editItemAllSubmit(){
	document.itemForm.action="${pageContext.request.contextPath}/item/editItemAllSubmit.action";
	document.itemForm.submit();
}
function queryItem(){
	document.itemForm.action="${pageContext.request.contextPath}/item/queryItem.action";
	document.itemForm.submit();
}
</script>
</head>
<body>
<form name = "itemForm" action="${pageContext.request.contextPath}/item/queryItem.action" method = "post">
	查询条件：
	<table width = "100%" border = 1>
		<tr>
			<td>商品名称：<input name = "itemCustom.name"></td>
			<td>
				<input type = "button" value = "查询" onclick = "queryItem()"/>
				<input type = "button" value = "批量修改提交" onclick = "editItemAllSubmit()"/>
			</td>
	</table>
	商品列表：
	<table width = "100%" border = 1>
		<tr>
			<td>商品名称</td>
			<td>商品价格</td>
			<td>商品概述</td>
		</tr>
		<c:forEach items = "${itemList}" var = "item" varStatus="status">
		<tr>
			<td><input name = "itemList[${status.index}].name" value = "${item.name}"/></td>
			<td><input name = "itemList[${status.index}].price" value = "${item.price}"/></td>
			<td><input name = "itemList[${status.index}].detail" value = "${item.detail}"/></td>
		</tr>
		</c:forEach>
	</table>
</form>
</body>
</html>