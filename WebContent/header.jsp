<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<jsp:useBean id="now" class="java.util.Date" />
<jsp:useBean id="user"  scope="session" class="login.LoginUserBean"/>

<%-- Java入門 ヘッダー画面 --%>
<div align="right">
	<%-- ログイン済みの場合はIDを表示 --%>
	<body>今の時刻は<%=now %>です</body>
ようこそ<jsp:getProperty property="name" name="user"/>さん!
<%--	<a href="/schoo/LoginServletShopping_ans?submit=history">購入履歴</a>--%>
<%--	<a href="/schoo/LoginServletShopping_ans?submit=logout">ログアウト</a>--%>
</div>