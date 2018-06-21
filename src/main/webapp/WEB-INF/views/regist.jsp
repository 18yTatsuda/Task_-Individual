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
<p>登録情報を入力してください<br>
※は必須です</p>

<c:if test="${not empty errmsg}">
  <p class="error">${fn:escapeXml(errmsg)}</p>
</c:if>
<c:if test="${not empty msg}">
  <p class="ok">${fn:escapeXml(msg)}</p>
</c:if>

<form:form action="regist" method="post" modelAttribute="userInsertForm">
<fieldset>
	<div>
		<label>※ユーザー名</label><form:input path="user_name" />
	</div>
	<div>
		<label>※パスワード</label><form:password path="user_pass" showPassword="true"/>
	</div>
	<div>
      <label>※パスワード（再入力）</label><form:password path="confirmPassword" />
    </div>
	<div>
		<label>※ニックネーム</label><form:input path="nickname" />
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
<div>
  <a href="index">トップ画面に戻る</a>
</div>
</body>
</html>