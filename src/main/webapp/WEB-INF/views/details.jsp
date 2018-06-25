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
<title>画像詳細</title>
</head>
<body>

<br>タイトル:${fn:escapeXml(image.imageName)}
<br><img src="../../images/${fn:escapeXml(image.file_name)}" alt="${fn:escapeXml(image.imageName)}" width="75%" height="75%">
<br>タグ:${fn:escapeXml(image.tag_id)}
<br>投稿者:${fn:escapeXml(image.user_id)}
<br>コメント:${fn:escapeXml(image.image_memo)}

<a href="update">編集する</a>
<a href="delete">削除する</a>
<a href="menu">メニューに戻る</a>
</body>
</html>