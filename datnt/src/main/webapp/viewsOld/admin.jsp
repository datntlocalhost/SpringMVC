<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib  uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Admin</title>
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Catamaran:100,200,300,400,500,600,700,800,900|Cormorant+Garamond:300,300i,400,400i,500,500i,600,600i,700,700i">
	<link rel="stylesheet" href="<c:url value="/resource/css/bootstrap.min.css" />" >
	<link rel="stylesheet" href="<c:url value="/resource/css/style.css" />" >
	<link rel="stylesheet" href="<c:url value="/resource/css/main.css" />" >
	<script src="<c:url value="/resource/js/main.js" />"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	
</head>
<body>
	<div id="header">
		<a href="" class="header-brand"> RUNSYSTEM </a>
		<div>
			<ul>
				<li><button id="create-btn" type="button" class="btn btn-info btn-lg custom-btn">CREATE</button></li>
			</ul>
			
			<a href="" class="logout"> Logout </a>
		</div>
	</div>
	
	
	
	<div class="container">
		<div class="search">
			<form action="" id="search-form" method="post">
				<table>
					<tr>
						<td>
							<input id="studentcode" name="studentCode" placeholder="Student Code" />
						</td>
						<td>
							<input id="studentname" name="studentName" placeholder="Student Name" />
						</td>
						<td><input type="button" id="search-submit" class="btn btn-info btn-lg search-btn" value="search"/></td>
					</tr>
				</table>
			</form>
		</div>	
	
		<div class="table-title">
			<h2>Student list</h2>
		</div>
		<div class="table-result">
			<table>
				<thead class="table-head">
					<tr style="height: 50px; border-radius: 10px; background-color: #649bf6;">
						<th class="column1">Select</th>
						<th class="column2">Student Code</th>
						<th class="column3">Student Name</th>
						<th class="column4">Date of birth</th>
						<th class="column5">Avg Scores</th>
						<th class="column6">Address</th>
						<th class="column7"></th>
					</tr>
				</thead>
				<tbody>
							<tr>
								<td class="column1 column-box"><input type="checkbox" name="studentid" value=""/></td>
								<td class="column2"></td>
								<td class="column3"></td>
								<td class="column4"></td>
								<td class="column5"></td>
								<td class="column6"></td>
								<td class="column7"><a href="" >Update</a></td>
							</tr>
				</tbody>
			</table>
		</div>
	</div>
	

	
	
	
	<!-- Model for Create student -->
	<div id="create" class="create-bg">
		<div class="create-content">
			<div class="create-header">
				<span>CREATE STUDENT</span>
			</div>
			<form id="create-form" action="" method="get" >
				<table>
					<tr>
						<td class="column-name">Student Code</td>
						<td><input id="code-create" type="text" name="studentCode" /></td>
						<td class="code-error"></td>
					</tr>
					<tr>
						<td class="column-name">Student Name</td>
						<td><input id="name-create" type="text" name="studentName"/></td>
						<td class="name-error"></td>
					</tr>
					<tr>
						<td class="column-name">Date of birth</td>
						<td><input id="date-create" type="date" name="dateOfBirth"/></td>
						<td id="date-error"></td>
					</tr>
					<tr>
						<td class="column-name">Address</td>
						<td><input id="address-create" type="text" name="address" /></td>
						<td id="address-error"></td>
					</tr>
				</table>
			 	<input id="create-submit" type="submit" name="submit" value="Create" class="btn btn-info btn-lg close-btn">
			</form>
		</div>
	</div>
</body>
</html>