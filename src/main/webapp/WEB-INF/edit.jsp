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
	<h1>Edit Your Thought</h1>
	
	<form:form action="/editpost/${post.id}" method="post" modelAttribute= "editPost">
	
		<form:errors path="post" class="text-dangerr"/> <br>
		<form:input type="hidden" value="${userId}" path="user"/> 
		<form:input type="hidden" value="${post.id}" path="id"/>
		<form:input id="post-input" type="text" path="post" value="${post.post}"/> <br>
		
		<input id="update-button" type="submit" value="Update"/>
	
	</form:form>
	
	<div>
		<h3><a href="/dashboard">Back</a></h3>
	</div>
	
</body>
</html>