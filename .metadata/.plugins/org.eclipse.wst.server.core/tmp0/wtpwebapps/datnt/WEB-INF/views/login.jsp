<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Login</title>
	<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
	<link rel="stylesheet" href="<c:url value="/assets/bootstrap/css/bootstrap.min.css" />" >
	<link rel="stylesheet" href="<c:url value="/assets/font-awesome/css/font-awesome.min.css" />" >
	<link rel="stylesheet" href="<c:url value="/assets/css/form-elements.css" />" >
	<link rel="stylesheet" href="<c:url value="/assets/css/style.css" />" >
</head>
<body style="background-image: url('<c:url value="/assets/img/backgrounds/1.jpg"/>');">

	<!-- Top content -->
	<div class="top-content">
		<div id="result"></div>
		<div class="inner-bg">
			<div class="container">
				<div class="row">
					<div class="col-sm-8 col-sm-offset-2 text">
						<h1>
							<strong>Runsystem</strong> Login Form
						</h1>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-6 col-sm-offset-3 form-box">
						<div class="form-top">
							<div class="form-top-left">
								<h3>Login to our site</h3>
								<p>Enter your username and password to log on:</p>
							</div>
							<div class="form-top-right">
								<i class="fa fa-lock"></i>
							</div>
						</div>
						<div class="form-bottom">
						 	<div style="width: 100%; text-align: center; color: red">
						 		${message}
						 	</div>
							<form:form role="form" action="/datnt/login" method="post" class="login-form" id="form-login" modelAttribute="user">
								<div class="form-group">
									<form:errors path="username" style="color: red;"/>
									<div id="invalid-usr" style="color: red;"> </div>
									<form:input type="text" path="username" placeholder="Username..." class="form-username form-control" id="form-username" />
								</div>
								<div class="form-group">
									<form:errors path="password" style="color: red;"/>
									<div id="invalid-pwd" style="color: red;"></div>
									<form:input type="password" path="password" placeholder="Password..." class="form-password form-control" id="form-password" />
								</div>
								<button type="submit" class="btn">Sign in!</button>
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Javascript -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="<c:url value="/assets/bootstrap/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/assets/js/jquery.backstretch.min.js"/>"></script>
    <script src="<c:url value="/assets/js/scripts.js" />"></script>
    <script src="<c:url value="/assets/js/validator.js" />"></script>

</body>
</html>