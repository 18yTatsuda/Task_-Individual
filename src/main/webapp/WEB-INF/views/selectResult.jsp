<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>検索結果</title>
</head>
<body>
	<table>
		<caption>検索結果を表示します</caption>
		<thead>
			<tr>
				<th>タイトル</th>
				<th>画像</th>
				<th>投稿者ID</th>
				<th>詳細を見る</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${imagelist}" var="image">
			<tr>
				<td>${fn:escapeXml(image.imageName)}</td>
				<td><img src ="../../images/${fn:escapeXml(image.file_name)}" alt="${fn:escapeXml(image.imageName)}" width="193" height="130"></td>
				<td>${fn:escapeXml(image.user_id)}</td>
				<td><form:form action="more" method="post" modelAttribute="selectForm">
					<form:hidden path="imageId" value="${fn:escapeXml(image.imageId)}"/>
					<input type="submit" value="詳細">
				</form:form></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div>
		<a href="menu">メニューに戻る</a>
	</div>
</body>
</html>