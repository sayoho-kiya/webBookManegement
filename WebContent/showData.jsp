<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Java入門</title>
		<link href="./login.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<h1>登録照会</h1>
		<% String ID=(String)request.getAttribute("ID");%> 
		<% String pass=(String)request.getAttribute("password");%> 
		<p>あなたのIDは<%=ID%>パスワードは<%=pass%>です。</p>
		<form>
			<input class="common_button" type="button" onclick="location.href='./LendingServlet'" value="貸出画面"/>
		</form>
	</body>
</html>