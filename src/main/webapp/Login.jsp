<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Please log in</h2>
<form method="post" action="AccountServlet">
	<div>
		<label for="userId">User Id</label>
		<input type="text" id="userId" name="userId">
	</div>
	<div>
		<label for="passcode">Passcode</label>
		<input type="password" id="passcode" name="passcode">
	</div>
	<div>
		<button type="submit" name="action" value="login">Login</button>
	</div>
</form>
<%@ include file = "footer.jsp"%>