<%@ page import="java.util.ArrayList"%>
<%@ page import="book.ItemBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>


<!DOCTYPE html>
<html>
	<head>
	
		<title>書籍貸出管理</title>
	</head>
	<body>
	<form action="./UpdateBookServlet" method="post">
		<link href="./root.css" rel="stylesheet" type="text/css" />
		<h1>登録書籍一覧</h1>
		<input class="common_button" type="button" onclick="location.href='./login.jsp'" value="戻る">
			<input class="common_button" type="button" onclick="location.href='./bookRegister.jsp'"value="新規登録" name="a">
		
		<%	ArrayList<ItemBean> bookList=(ArrayList<ItemBean>)request.getAttribute("bookList"); %>
			<table class="table_list" border="1"  width="80%">
				<tbody>
					<tr>
						
						<th>書籍名</th>
						<th>出版社</th>
						<th>著者</th>
						<th>ジャンル</th>
						<th>評価</th>
						<th>エリア</th>
						<th>定価</th>
						<th></th>
						
					</tr>
					<%-- Beanの要素数分（商品の種類分）テーブルを作成 --%>
					<% for(ItemBean bean : bookList) {
					String bookinfo[]=new String[8];
					bookinfo[0]=bean.getTitle();
					bookinfo[1]=bean.getPublisher();
					bookinfo[2]=bean.getAuthor();
					bookinfo[3]=bean.getGenre();
					bookinfo[4]=bean.getEval();
					bookinfo[5]=bean.getArea();
					bookinfo[6]=bean.getPrice();
					bookinfo[7]=bean.getPid();
					%><tr><%
					for(int i=0;i<6;i++){
					%>
					
					<td><%= bookinfo[i] %></td>
				<%} %>
				<td>\<%= bookinfo[6] %></td>
						<td class="button">
							<input class="common_button" type="submit" value="編集" name="<%= bookinfo[0]%>">
								<% for(int i=0;i<8;i++){ %>
						<input type="hidden" value="<%= bookinfo[i] %>" name="<%= bookinfo[0]%>">
						</td></tr>
					<% } %>
					<% } %>
				</tbody>
			</table>
			</form>
	</body>
</html>