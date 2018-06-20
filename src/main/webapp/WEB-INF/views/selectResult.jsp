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
      <th>タグ</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${imagelist}" var="image">
      <tr>
        <td>${fn:escapeXml(image.imageName)}</td>
        <td>${fn:escapeXml(image.image)}</td>
        <td>${fn:escapeXml(image.tag)}</td>
      </tr>
    </c:forEach>
  </tbody>
</table>
<div>
<a href="menu">メニューに戻る</a>
</div>
</body>
</html>