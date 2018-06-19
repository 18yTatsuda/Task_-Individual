<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>削除画面</title>
</head>
<body>
タイトルと画像を表示
<br>
この画像を削除しますか？
  <div>
    <input type="submit" name="button" value="決定">
    <input type="submit" name="button" value="削除をやめる" onclick="location.href='details'; return false;">
  </div>
</body>
</html>