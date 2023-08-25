<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<html>
<head>
<meta charset="UTF-8">
<title>PhilSci</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div>
		<h4 class="head-title" id="dash-head"><a href="/">PhilSci</a></h4>
	</div>
	
	<div class="user-head">
		<h3 class="username"><a href="/profile"><c:out value="${user.fullName}"/></a></h3>
		<h3><a href="/">Logout</a></h3>
	</div>
	
	<div class="post-section">
		<form:form action="/createpost" method="post" modelAttribute ="newPost">
			<form:errors path="post" class="text-dangerr"/> <br>
			<form:textarea path="post" rows="3" cols="35" placeholder="Share your invigorating thoughts..."/>
			
			<form:input type = "hidden" value="${userId}" path="user"/> <br>
			
			<input type="submit" id="post-button" value="Post"/>
		</form:form>
	</div>
	
	<c:forEach var="post" items="${posts}">
		<div class="user-post">
			<h3 class="username"><c:out value="${post.user.userName}"/></h3>
			<h4 class="userpost"><c:out value= "${post.post}"/></h4>
		</div>
	</c:forEach>
</body>
</html>