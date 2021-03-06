<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改商品信息</title>
</head>
<body>
<!-- 显示错误信息 -->
<c:forEach items="${allErrors}" var="error">
	${error.defaultMessage}
</c:forEach>
<form id = "itemForm" action="${pageContext.request.contextPath}/item/editItemSubmit.action" method = "post">
	<input type = "hidden" name = "id" value = "${itemCustom.id}">
	修改商品信息
	<table width = "100%" border = 1>
		<tr>
			<td>商品名称</td>
			<td><input type = "text" name = "name" value = "${itemCustom.name}"></td>
		</tr>
		<tr>
			<td>商品价格</td>
			<td><input type = "text" name = "price" value = "${itemCustom.price}"></td>
		</tr>
		<tr>
			<td>生产日期</td>
			<td><input type = "text" name = "creattime" value = "${itemCustom.creattime}"></td>
		</tr>
		<tr>
			<td>商品简介</td>
			<td>
				<textarea rows="3" cols="30" name = "detail">${itemCustom.detail}</textarea>
			</td>
		</tr>
		<tr>
			<td colspan = "2" align = "center"><input type = "submit" value = "提交">
		</td>
	</table>
</form>
</body>
</html>