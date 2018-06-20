<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>メニューページ</title>
</head>
<body>
<p>ようこそ、${fn:escapeXml(user.nickName)}さん!</p>
<p><a href="insert">投稿する</a></p>
<p><a href="select">検索する</a></p>
<p><a href="profile">ユーザープロフィール</a></p>
<br>
<form action="logout" method="post">
<button type="submit">ログアウト</button>
</form>
</body>
</html>