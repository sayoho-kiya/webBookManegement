<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<%-- 図書管理プログラム ログイン画面 --%>
<!DOCTYPE html>
<html>
	<head>
		<title>図書管理プログラム</title>
		<link href="./login.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<div class="login_pane">
			
			<h1>ようこそ書籍管理サイトへ！</h1>
			
			<p>ログインIDとパスワードを入力して下さい。</p>
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
				<h1>※新規登録の方はこちら</h1>
			<p>お名前・メールアドレス・パスワードを入力して下さい。</p>
			<form action="./NewRegisterServlet" method="post">
				<table class="table_form">
					<tbody>
						<tr>
							<th>お名前</th>
							<td><input type="text" name="name"/></td>
						</tr>
						<tr>
							<th>メールアドレス</th>
							<td><input type="text" name="mail"/></td>
						</tr><tr>
							<th>パスワード</th>
							<td><input type="password" name="pass"/></td>
						</tr>
					</tbody>
				</table>
				<input class="common_button" type="submit" name="submit"  value="新規登録"/>
				
			</form>
			<h1>※ID・パスワードを忘れた方はこちら</h1>
			<p>お名前とメールアドレスを入力してください。</p>
			<form action="./ForgotPWServlet" method="post">
				<table class="table_form">
					<tbody>
						<tr>
							<th>お名前</th>
							<td><input type="text" name="name"/></td>
						</tr>
						<tr>
							<th>メールアドレス</th>
							<td><input type="text" name="mail"/></td>
						</tr><tr>
					</tbody>
				</table>
				<input class="common_button" type="submit" name="submit"  value="送信"/>
				
			</form>
			
		</div>
		
			
		
	
		
	</body>
</html>