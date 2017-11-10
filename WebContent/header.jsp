<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<jsp:useBean id="user"  scope="session" class="login.LoginUserBean"/>
<%-- Java入門 ヘッダー画面 --%>
<div align="right">
	<%-- ログイン済みの場合はIDを表示 --%>
	<body>
ようこそ<jsp:getProperty property="id" name="user" /> <jsp:getProperty property="name" name="user" />さん！
 <a href="./history.jsp">  貸出履歴      </a>
<a href="./login.jsp">   ログアウト </a>
</body></div>