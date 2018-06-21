<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>画像登録画面</title>
</head>
<body>
	<h1>画像を登録します</h1>
	<p>
		情報を入力してください<br>
	<p>※は必須です</p>
	<form:form action="insert" method="post" enctype="multipart/form-data">
		<table border="0">
			<tr>
				<td align="right"><b> タイトル：</b></td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td align="right"><b> ※登録したい画像：</b></td>
				<td><input type="file" name="image"></td>
			</tr>
			<tr>
				<td align="right"><b>※タグ：</b></td>
				<td>
					<fieldset>
						<div>
							<form:checkbox path="tagId" value="1" checked="checked" />
							<label>写真</label>
							<form:checkbox path="tagId" value="2" />
							<label>イラスト</label>
							<form:checkbox path="tagId" value="3" />
							<label>スクリーンショット</label>
						</div>
						<div>
							<form:checkbox path="tagId" value="4" />
							<label>人物</label>
							<form:checkbox path="tagId" value="5" />
							<label>風景</label>
							<form:checkbox path="tagId" value="6" />
							<label>動物</label>
						</div>
					</fieldset>
				</td>
			</tr>
			<tr>
				<td align="right"><b>メモ：</b></td>
				<td><form:input path="memo" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="登録"> <input
					type="reset" value="リセット"></td>
			</tr>
		</table>
	</form:form>
	<div>
		<a href="menu">メニューに戻る</a>
	</div>
</body>
</html>