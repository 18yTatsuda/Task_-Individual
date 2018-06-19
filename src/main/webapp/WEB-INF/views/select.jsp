<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>検索画面</title>
</head>
<body>
<h1>どのタグで検索しますか？</h1>

<form action="select" method="get">
<p>
<input type="checkbox" name="tag" value="1" checked="checked">写真
<input type="checkbox" name="tag" value="2">イラスト
<input type="checkbox" name="tag" value="3">スクリーンショット
<input type="checkbox" name="tag" value="4">人物
<input type="checkbox" name="tag" value="5">風景
<input type="checkbox" name="tag" value="6">動物
</p>
<p>
<input type="submit" value="検索">
</p>
</form>

</body>
</html>