<%@ page language="java" contentType="text/html; charset=UTF-8" %>
 <jsp:useBean id="rtninfo"  scope="session" class="book.ItemBean"/>

<%-- 図書管理プログラム ログイン画面 --%>
<!DOCTYPE html>
<html>
	<head>
		<title>図書管理プログラム</title>
		<link href="./login.css" rel="stylesheet" type="text/css" />
	</head>
		<jsp:include page="./header.jsp" />
	<body>
		<div class="login_pane">
			
			<h1>返却確認画面</h1>
			
			<p>評価を選択してください。</p>
			<form action="./BookRegisterServlet" method="post">
				<table class="table_form">
					<tbody>
						<tr>
							<th>タイトル</th>
							<td><jsp:getProperty property="title" name="rtninfo" /></td>
						</tr>
						<tr>
							<th>出版社</th>
							<td><jsp:getProperty property="publisher" name="rtninfo" /></td>
						</tr><tr>
							<th>著者</th>
							<td><jsp:getProperty property="author" name="rtninfo" /></td>
							</tr><tr>
							<th>返却予定日</th>
							<td></td>
							</tr><tr>
							<th>返却日</th>
							<td></td>
						</tr><tr>
							<th>評価</th>
							<td><input type="radio" name="evaluation" value="1"/>★1つ
							<input type="radio" name="evaluation" value="2"/>★2つ 
							<input type="radio" name="evaluation" value="3"/>★3つ 
							<input type="radio" name="evaluation" value="4"/>★4つ 
							<input type="radio" name="evaluation" value="5"/>★5つ </td>
							</tr><tr>
							<th>感想</th>
							<td><textarea name="kansou" rows="4" cols="30"></textarea></td></tr>
					</tbody>
				</table>
				<input class="common_button" type="button" onclick="location.href='./login.jsp'" value="戻る">
				<input class="common_button" type="submit" name="submit"  value="登録"/>
				
			</form>
			
		</div>
		
			
		
	
		
	</body>
</html>