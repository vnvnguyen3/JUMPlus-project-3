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
<%Account account = (Account)request.getAttribute("account"); 
session.setAttribute("account", account);%>
<h2>Transaction complete! You now have $<%=account.getAmount()%> in your account</h2>
<a href= "./account.jsp"><button type="button">Go Back</button></a>
<%@ include file = "footer.jsp"%></html>