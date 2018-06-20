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
<title>新規登録</title>
</head>
<body>
<form:form action="regist" method="post" modelAttribute="userInsertForm">
<fieldset>
	<div>
		<label>ユーザー名</label><form:input path="user_name" />
	</div>
	<div>
		<label>パスワード</label><form:password path="user_pass" showPassword="true"/>
	</div>
	<div>
		<label>ニックネーム</label><form:input path="nickname" />
	</div>
	<div>
		<label>E-mail</label><form:input path="email" />
	</div>
	<div>
		<label>メモ</label><form:input path="memo" />
	</div>
</fieldset>
<input type="submit" value="登録">
</form:form>
</body>
</html>