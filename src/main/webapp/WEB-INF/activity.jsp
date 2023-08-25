<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PhilSci</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<h4 class="head-title"><a href="/">PhilSci</a></h4>
	<h2 class="head-title">Your Activities</h2>
	
	<c:forEach var="userPost" items="${user.posts}">
		<div>
			<h3 class="username">You Posted:</h3>
			<h3 class="userpost" id="user-activity"><c:out value="${userPost.post}"/></h3>
			<h4 class="link"><a href="/edit/${userPost.id}">Edit</a> <a href="/deletepost/${userPost.id}">Delete</a></h4>
		</div>
	</c:forEach>
	
	<h4 class="link"><a href="/dashboard">Back</a></h4>
</body>
</html>