<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新規登録</title>
</head>
<body>
<form action="regist" method= "post">
※ユーザー名<input type="text" name="user_name">
※パスワード<input type="password" name="user_pass">
※パスワード(再入力)<input type="password" name="rePass">
※ニックネーム<input type="text" name="nickname">
E-mail<input type="text" name="email">
メモ<input type="text" name="memo">
<button type="submit">登録</button>
</form>
</body>
</html>