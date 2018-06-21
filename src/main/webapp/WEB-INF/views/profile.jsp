<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ユーザープロフィール</title>
</head>
<body>
<p>${fn:escapeXml(user.nickName)}さんのユーザー情報です。</p>
<p>ユーザー名:${fn:escapeXml(user.user_name)}</p>
<p>ニックネーム:${fn:escapeXml(user.nickName)}</p>
<p>E-mail:${fn:escapeXml(user.email)}</p>
<p>メモ:${fn:escapeXml(user.memo)}</p>
<a href="menu">メニューに戻る</a>
<br>
<form action="logout" method="post">
<button type="submit">ログアウト</button>
</form>
</body>
</html>