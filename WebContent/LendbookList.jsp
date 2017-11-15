<%@ page import="java.util.ArrayList"%>
<%@ page import="book.ItemBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
	<head>
	
		<title>書籍貸出管理</title>
	</head>
	<body>
	<form action="./LendBookServlet" method="post">
		<jsp:include page="./header.jsp"/>
	<link href="./login.css" rel="stylesheet" type="text/css" />
		<h1>書籍一覧</h1>
		<%	ArrayList<ItemBean> bookList=(ArrayList<ItemBean>)request.getAttribute("bookList"); 
		String lendingTitle=(String)request.getAttribute("lendingTitle");%>
		
			<table class="table_list" border="1" width="100%" >
				<tbody>
					<tr>
						
						<th>書籍名</th>
						<th>出版社</th>
						<th>著者</th>
						<th>ジャンル</th>
						<th>評価</th>
						
						<th>定価</th>
						<th>コメント</th>
					</tr>
					<%-- Beanの要素数分（商品の種類分）テーブルを作成 --%>
					<% for(ItemBean bean : bookList){
						String bookinfo[]=new String[8];
						bookinfo[0]=bean.getTitle();
						bookinfo[1]=bean.getPublisher();
						bookinfo[2]=bean.getAuthor();
						bookinfo[3]=bean.getGenre();
						bookinfo[4]=bean.getEval();
						bookinfo[5]=bean.getArea();
						bookinfo[6]=bean.getPrice();
						bookinfo[7]=bean.getPid();
					%>
					<tr>
					
					<td width="25%"><%= bean.getTitle() %></td>
					<td width="10%"><%= bean.getPublisher() %></td>
					<td width="10%"><%= bean.getAuthor() %></td>
					<td width="15%"><%= bean.getGenre() %></td>
					<td width="12%"><%= bean.getEval() %></td>
					
					<td width="8%">\<%= bean.getPrice() %></td>
					<td width="10%" align="center"><input class="common_button" type="submit" value="表示" name=""></td>
						<td width="10%" align="center">
							<% if(bean.getState()==0) { %>
						<input class="common_button" type="submit" value="貸出"  name="<%= bookinfo[0]%>">
					<input type="hidden" value="<%= bookinfo[0]%>" name="<%= bookinfo[0]%>">
						<input type="hidden" value="<%= bookinfo[1] %>" name="<%= bookinfo[0]%>">
						<input type="hidden" value="<%= bookinfo[2] %>" name="<%= bookinfo[0]%>">
						<input type="hidden" value="<%= bookinfo[7] %>" name="<%= bookinfo[0]%>">
	
						<% }else if(bean.getState()==1&&lendingTitle.equals(bean.getTitle())) {%>
							<input class="common_button" style="background-color:#008000"type="submit" value="返却" name="<%= bookinfo[0]%>">
							<input type="hidden" value="<%= bookinfo[0]%>" name="<%= bookinfo[0]%>">
						<input type="hidden" value="<%= bookinfo[1] %>" name="<%= bookinfo[0]%>">
						<input type="hidden" value="<%= bookinfo[2] %>" name="<%= bookinfo[0]%>">
						<input type="hidden" value="<%= bookinfo[7] %>" name="<%= bookinfo[0]%>">
						
						<% }else{ %>
						<input class="common_button" style="background-color:#696969 "type="button" value="貸出中" 
						>
						</td>
					<% } %>
					
					<% } %>
				</tbody>
			</table>
			</form>
			<input class="common_button" type="button" onclick="location.href='./login.jsp'" value="戻る">
	</body>
</html>