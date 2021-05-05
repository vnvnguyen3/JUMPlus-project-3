<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.cognixia.jump.model.Account" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%Account account;
if((Account)request.getAttribute("account") == null){
	account = (Account)session.getAttribute("account");
}else{
	account = (Account)request.getAttribute("account");
}
session.setAttribute("account", account);%>
<h2>Welcome <%=account.getFirst()%> <%=account.getLast()%></h2>
<a href= "./deposit.jsp"><button type="button">Deposit</button></a>
<a href= "./withdraw.jsp"><button type="button">Withdraw</button></a>
<form method="post" action="UserServlet"><button type="submit">Transfer</button></form>
<a href= "./transactions.jsp"><button type="button">Transactions</button></a>
<a href= "./userInfo.jsp"><button type="button">View User Info</button></a>
<a href= "./index.jsp"><button type="button">Sign Out</button></a>
<%@ include file = "footer.jsp"%>