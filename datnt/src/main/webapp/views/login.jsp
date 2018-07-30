<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>

<style>
    .error {
        color: red; font-weight: bold;
    }
</style>

</head>
<body>
	
	<form:form action="login" method="POST" modelAttribute="user">
		<form:label path="username">Username</form:label>
		<form:input path="username" />
		<form:errors path="username" cssClass="error" />
		<form:label path="password">Password</form:label>
		<form:input path="password" />
		<form:errors path="password" cssClass="error" />
		<input type="submit" name="submit" value="Login">
	</form:form>
	
</body>
</html>