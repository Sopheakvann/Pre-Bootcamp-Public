<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"> 
<title>PhilSci</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>

	<h1 class="head-title"><a href="/">PhilSci</a></h1>
	
	<h2 class="info-title"><c:out value="${user.fullName}"/></h2>
	<h2 class="info-title">Account Information</h2>
	
	<h3 class="user-info">Username: <c:out value="${user.userName}"/></h3>
	<h3 class="user-info">Email: <c:out value="${user.email}"/></h3>	
	
	<h4 class="link"><a href="/dashboard">Back</a></h4>
	<h4 class="link"><a href="/logout">Log Out</a></h4>
	<h4 class="link"><a href="/activity">View Past Activities</a></h4>
</body>
</html>