<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%--<jsp:useBean id="user"  scope="session" class="book.ItemBean"/>--%>

<%-- Java入門 商品一覧画面 --%>
<!DOCTYPE html>
<html>
	<head>
	
		<title>Java入門</title>
	</head>
	<body>
		<jsp:include page="./header.jsp"/>
		<h1>書籍一覧</h1>
			<table class="table_list">
				<tbody>
					<tr>
						<th>商品ID</th>
						<th>商品名</th>
						<th>価格</th>
						<th>在庫数</th>
						<th>数量</th>
					</tr>
				</tbody>
			</table>
			<input class="common_button" type="button" onclick="location.href='./login.jsp'" value="戻る">
	</body>
</html>