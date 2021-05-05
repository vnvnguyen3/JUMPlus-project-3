<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.cognixia.jump.model.Account" %>
    <%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%Account account = (Account)session.getAttribute("account"); 
session.setAttribute("account", account);%>
<h2>Select user to transfer funds to</h2>
<form method="get" action="TransferServlet">
	<select name="transferTo">	
		<%
		  ArrayList<Account> accounts=(ArrayList<Account>) request.getAttribute("accounts"); 
		  for (Account a: accounts) {   
			  if(!a.getUserId().equals(account.getUserId())){%>
				<option value=<%=a.getUserId() %>><%=a.getUserId() %></option>
		<%}}%>
		<input type="submit" value="Submit">
	</select>
</form>
<a href= "./account.jsp"><button type="button">Go Back</button></a>
<%@ include file = "footer.jsp"%></html>