<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>SEARCH</title>
</head>
<body>
	<%@ include file = "header.jsp" %>
	
	<div class="search-container" >
	
		<div class="search">
			<form action="" method="POST">
				<table>
					<tr>
						<td><label>Student ID: </label></td>
						<td><input type="text" /></td>
						<td><label>Date of Birth: </label></td>
						<td><input type="date" /></td>
					</tr>
					<tr>
						<td><label>Student Name: </label></td>
						<td><input type="text" /></td>
						<td><label>Averages Score: </label></td>
						<td><input type="text" style="width: 125px;"/></td>
					</tr>
				</table>
				<input type="submit" value="Search">
			</form>
		</div>
		
		<table>
			<tr>
				<th>Student ID</th>
				<th>Name</th>
				<th>Date of Birth</th>
				<th>Averages Score</th>
				<th>Address</th>
			</tr>
			<input type="checkbox" >
			<tr>
				<td>asd</td>
				<td>asd</td>
				<td>123</td>
				<td>123</td>
				<td>13</td>
			</tr>
			</input>
			
		</table>
	</div>
	
</body>
</html>