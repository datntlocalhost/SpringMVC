<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Login</title>
	
	<link rel="stylesheet" href="<c:url value="/resource/css/main.css" />" >

<style>
    .error {
        color: red; font-weight: bold;
    }
</style>

</head>
<body class="login-body">
	
	
	<div class="login-container">
		<h1>Login</h1>
		<form:form action="login" method="POST" modelAttribute="user">
			<div class="invalid-username">
				<form:errors path="username" />
			</div>
			<div class="login-input login-input-1">
				<form:input path="username" placeholder="Enter Username" />
			</div>
			
			<div class="invalid-password">
				<form:errors path="password" />
			</div>
			<div class="login-input login-input-2">
				<form:input type="password" path="password" placeholder="Enter Password" />
			</div>
			<h4 style="color: red;">${loginfailed}</h4>
			<input class="login-btn" type="submit" name="submit" value="Login">
		</form:form>
	</div>
	
	
</body>
</html>