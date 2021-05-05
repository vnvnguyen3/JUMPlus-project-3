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
session.setAttribute("account", account);%>
<h2>User Information</h2>
<p><%=account.getFirst()%> <%=account.getLast()%></p>
<p><%=account.getEmail()%></p>
<p><%=account.getUserId()%></p>
<p>$<%=account.getAmount()%></p>
<a href= "./account.jsp"><button type="button">Go Back</button></a>
<%@ include file = "footer.jsp"%>