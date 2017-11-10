<%@ page import="java.util.ArrayList"%>
<%@ page import="book.ItemBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>


<!DOCTYPE html>
<html>
	<head>
	
		<title>書籍貸出管理</title>
	</head>
	<body>
		<link href="./login.css" rel="stylesheet" type="text/css" />
		<h1>貸出履歴一覧</h1>
	<%--	<%	ArrayList<ItemBean> bookList=(ArrayList<ItemBean>)request.getAttribute("bookList"); %>--%>
			<table class="table_list" border="1" >
				<tbody>
					<tr>
						<th>書籍ID</th>
						<th>書籍名</th>
						<th>出版社</th>
						<th>著者</th>
						<th>ジャンル</th>
						
						<th>定価</th>
							<th>貸出日</th>
								<th>返却日</th>
								<th>あなたの評価</th>
								<th>感想</th>
					</tr>
					<%-- Beanの要素数分（商品の種類分）テーブルを作成 
				<%--	<% for(ItemBean bean : bookList) { %>
					<tr>
					<td><%= bean.getPid() %></td>
					<td><%= bean.getTitle() %></td>
					<td><%= bean.getPublisher() %></td>
					<td ><%= bean.getAuthor() %></td>
					<td  ><%= bean.getGenre() %></td>
					<td ><%= bean.getEval() %></td>
					<td ><%= bean.getArea() %></td>
					<td ><%= bean.getPrice() %></td>
						<td>
						</td>
					<% } %>--%>
				</tbody>
			</table>
			<input class="common_button" type="button" onclick="location.href='./login.jsp'" value="戻る">
	</body>
</html>