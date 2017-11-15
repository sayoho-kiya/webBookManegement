<%@ page import="java.util.ArrayList"%>
<%@ page import="book.HistoryBean" %>
<%@ page import="book.ItemBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>


<!DOCTYPE html>
<html>
	<head>
	
		<title>書籍貸出履歴</title>
	</head>
	<body>
		<jsp:include page="./header.jsp"/>
		<link href="./login.css" rel="stylesheet" type="text/css" />
		<h1>貸出履歴一覧</h1>
<%	ArrayList<HistoryBean> historyList=(ArrayList<HistoryBean>)request.getAttribute("historyList"); %>
			<table class="table_list" border="1" width="100%" >
				<tbody>
					<tr>
					
						<th>書籍名</th>
						<th>出版社</th>
						<th>著者</th>
						<th>ジャンル</th>
						<th>あなたの評価</th>
						<th>貸出日</th>
						<th>返却日</th>		
						<th>感想</th>
					</tr>
					<%-- Beanの要素数分（商品の種類分）テーブルを作成 --%>
			
		<%	 for(HistoryBean historybean : historyList) { %>
					<tr>
					<td width="15%"><%= historybean.getTitle() %></td>
					<td width="10%"><%= historybean.getPublisher() %></td>
					<td width="10%"><%= historybean.getAuthor() %></td>
					<td  width="10%"><%= historybean.getGenre() %></td>
					<td width="10%"><%= historybean.getEvaluation() %></td>
					<td width="10%"><%= historybean.getOutdate() %></td>
					<td width="10%"><%= historybean.getIndate() %></td>
					<td width="30%"><%= historybean.getImpressions() %></td>
					
					<% } %>
						
				</tbody>
			</table>
			<input class="common_button" type="button" onclick="location.href='./login.jsp'" value="戻る">
	</body>
</html>