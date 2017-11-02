<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<%-- 図書管理プログラム ログイン画面 --%>
<!DOCTYPE html>
<html>
	<head>
		<title>図書管理プログラム</title>
	</head>
	<body>
		<div class="login_pane">
			<h1>ようこそ書籍管理サイトへ！</h1>
			<p>ログインIDとパスワードを入力して下さい</p>
			<form action="./LoginServlet" method="post">
				<table class="table_form">
					<tbody>
						<tr>
							<th>ログインID</th>
							<td><input type="text" name="id"/></td>
						</tr>
						<tr>
							<th>パスワード</th>
							<td><input type="password" name="pass"/></td>
						</tr>
					</tbody>
				</table>
				<input class="common_button" type="submit" name="submit"  value="ログイン"/>
				
			</form>
		</div>
	</body>
</html>