<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Create a new account</h2>
<form method="post" action="RegisterServlet">
	<div>
		<label for="first_name">First name</label>
		<input type="text" id="first_name" name="first_name">
	</div>
	<div>
		<label for="last_name">Last name</label>
		<input type="text" id="last_name" name="last_name">
	</div>
	<div>
		<label for="email">Email</label>
		<input type="email" id="email" name="email">
	</div>
	<div>
		<label for="userId">User Id</label>
		<input type="text" id="userId" name="userId">
	</div>
	<div>
		<label for="passcode">Passcode</label>
		<input type="password" id="passcode" name="passcode">
	</div>
	<div>
		<label for="amount">Initial Deposit Amount</label>
		<input type="number" id="amount" name="amount">
	</div>
	<div>
		<button type="submit">Create Account</button>
	</div>
</form>
<a href= "./index.jsp"><button type="button">Go Back</button></a>
<%@ include file = "footer.jsp"%>