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
<%Account account = (Account)session.getAttribute("account"); 
Account transferTo = (Account)request.getAttribute("transferTo");
session.setAttribute("account", account);%>
<h2>Transfer Funds</h2>
<p>You currently have $<%=account.getAmount()%> in your account</p>
<form method="post" action="TransferServlet">
	From <input type="text" id="userID" name="userId" value=<%=account.getUserId()%> readonly>
	to <input type="text" id="userID" name="transferTo" value=<%=transferTo.getUserId()%> readonly>
	<div>
		<label for="amount">Amount to transfer to <%=transferTo.getUserId() %></label>
		<input type="number" id="amount" name="amount">
	</div>
	<div>
		<button type="submit">Transfer</button>
	</div>
</form>
<a href= "./account.jsp"><button type="button">Go Back</button></a>
<%@ include file = "footer.jsp"%></html>