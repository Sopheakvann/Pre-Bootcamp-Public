<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PhilSci</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<h3 class="head-title"><a href="/">PhilSci</a></h3>
	
	<div class="reg">
		<form:form action="/register" method="post" modelAttribute="newUser">
		
			<form:errors path="fullName" class="text-danger"/><br>
			<form:label path="fullName">Full Name:</form:label><br>
			<form:input type="text" path="fullName"/><br>
			
			<form:errors path="email" class="text-danger"/><br>
			<form:label path="email">Email:</form:label><br>
			<form:input type="text" path="email"/><br>
			
			<form:errors path="userName" class="text-danger"/><br>
			<form:label path="userName">Username:</form:label><br>
			<form:input type="text" path="userName"/><br>
			
			<form:errors path="password" class="text-danger"/><br>
			<form:label path="password">Password:</form:label><br>
			<form:input type="password" path="password"/><br>
			
			<form:errors path="confirm" class="text-danger"/><br>
			<form:label path="confirm">Confirm Password:</form:label><br>
			<form:input type="password" path="confirm"/><br>
			
			<input type="submit" value="Sign up"/>
		
			
		</form:form>
	</div>
	
	<div id="encouraging-message">
		<h1>Your Journey to Unravel the Truth</h1>
	</div>
	
	<h4><a href="/">Back</a></h4>
</body>
</html>