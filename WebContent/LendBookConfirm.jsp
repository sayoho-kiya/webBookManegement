<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="book.ItemBean" %>
<%@ page import="login.LoginUserBean" %>
 <jsp:useBean id="info"  scope="session" class="book.ItemBean"/>
 <jsp:useBean id="user"  scope="session" class="login.LoginUserBean"/>
<%@ page session="true" %>

<!DOCTYPE html>
<html>
	<head>
		<title>図書管理プログラム</title>
		<link href="./login.css" rel="stylesheet" type="text/css" />
	</head>
	<jsp:include page="./header.jsp" />
	<body>
		<div class="login_pane">
			
			<h1>貸出確認画面</h1>
			
			<p>返却予定日を選択してください。</p>
			<form action="./LendRegisterServlet" method="post">
				<table class="table_form">
					<tbody>
						<tr>
							<th>タイトル</th>
						<td><jsp:getProperty property="title" name="info" /></td>
						</tr>
						<tr>
							<th>出版社</th>
							<td><jsp:getProperty property="publisher" name="info" /></td>
						</tr><tr>
							<th>著者</th>
							<td><jsp:getProperty property="author" name="info" /></td>
						</tr><tr>
							<th>返却予定日</th>
							<td><input type="date" name="date"/></td>
							
					</tbody>
				</table>
				<input class="common_button" type="button" onclick="location.href='./login.jsp'" value="戻る">
				<input class="common_button" type="submit" name="submit"  value="登録"/>
				
			</form>
			
		</div>
		
			
		
	
		
	</body>
</html>