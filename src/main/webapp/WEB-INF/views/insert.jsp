<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>画像登録画面</title>
</head>
<body>
<h1>画像を登録します</h1>
<p>情報を入力してください<br>
<p>※は必須です</p>
<form:form action="insert" method="post" enctype="multipart/form-data" >
<table border="0">
  <tr>
    <td align="right"><b> タイトル：</b></td>
    <td><input type="text" name="name"></td>
  </tr>
  <tr>
    <td align="right"><b> ※登録したい画像：</b></td>
    <td><input type="file" name="image"></td>
  </tr>
  <tr>
    <td align="right"><b>※タグ：</b></td>
    <td>
      <input type="checkbox" name="tags" value="1">写真
      <input type="checkbox" name="tags" value="2">イラスト
      <input type="checkbox" name="tags" value="3">スクリーンショット
      <input type="checkbox" name="tags" value="4">人物
      <input type="checkbox" name="tags" value="5">風景
      <input type="checkbox" name="tags" value="6">動物
    </td>
  </tr>
  <tr>
    <td align="right"><b>メモ：</b></td>
    <td><input type="text" name="memo"></td>
  </tr>
  <tr>
    <td></td>
    <td>
      <input type="submit" value="登録">
      <input type="reset" value="リセット">
    </td>
  </tr>
</table>
</form:form>
</body>
</html>