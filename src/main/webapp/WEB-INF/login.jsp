<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<h4 class="head-title"><a href="/">PhilSci</a></h4>
	
	<div>
		<h1 id="welcome-back-thinker">Welcome Back Thinker!</h1>
	</div>
	
	<div class="login">
		<form:form action="/login" method="post" modelAttribute="newLogin">
			
			<form:errors path="email" class="text-danger"/><br>
			<form:label path="email">Email:</form:label>
			<form:input type= "text" path="email"/> <br>
			
			<form:errors path="password" class="text-danger"/><br>
			<form:label  path="password">Password:</form:label>
			<form:input  type= "password" path="password"/> <br>
			
			<input type="submit" value="Sign In"/>
		</form:form>
	</div>
</body>
</html>