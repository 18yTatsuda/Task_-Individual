<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>画像情報更新画面</title>
</head>
<body>
<form:form action="updateInput" method="post" modelAttribute="updateForm">
  <fieldset>
    <div>
      <label>タイトル：</label><input type="text" name="image_NewName" value="${fn:escapeXml(image.image_name)}">
    </div>
    <div>
      <label>画像は差し替え不可</label>
    </div>
    <div>
      <label>タグ</label>
      <input type="checkbox" name="tags" value="1">写真
      <input type="checkbox" name="tags" value="2">イラスト
      <input type="checkbox" name="tags" value="3">スクリーンショット
      <input type="checkbox" name="tags" value="4">人物
      <input type="checkbox" name="tags" value="5">風景
      <input type="checkbox" name="tags" value="6">動物
    </div>
    <div>
      <label>メモ：</label><input type="text" name="newMemo" value="${fn:escapeXml(image.image_memo)}">
    </div>
  </fieldset>
  <div>
    <input type="submit" name="button" value="決定">
    <input type="submit" name="button" value="編集をやめる" onclick="location.href='details'; return false;">
  </div>
</form:form>
</body>
</html>