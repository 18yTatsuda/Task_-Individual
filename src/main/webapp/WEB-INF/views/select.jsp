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
<title>検索画面</title>
</head>
<body>
<c:if test="${not empty errmsg}">
  <p class="error">${fn:escapeXml(errmsg)}</p>
</c:if>
<h2>どのタグで検索しますか？</h2>

<form:form action="list" method="get" modelAttribute="selectForm">
 <fieldset>
<div>
<form:checkbox path="tagId" value="1" checked="checked" /><label>写真</label>
<form:checkbox path="tagId" value="2" /><label>イラスト</label>
<form:checkbox path="tagId" value="3" /><label>スクリーンショット</label>
</div>
<div>
<form:checkbox path="tagId" value="4" /><label>人物</label>
<form:checkbox path="tagId" value="5" /><label>風景</label>
<form:checkbox path="tagId" value="6" /><label>動物</label>
</div>
</fieldset>
<p>
<input type="submit" value="検索">
</p>
</form:form>
<div>
  <a href="menu">メニューに戻る</a>
</div>
</body>
</html>