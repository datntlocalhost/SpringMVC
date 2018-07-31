<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib  uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Create</title>
	
	<style>
    	.error {
        	color: red;
        	font-size: 12px;
    	}
</style>
</head>
<body>
	<%@ include file="header.jsp"%>
	
	<div class="add-container">
		<div class="add-header">
			<p>Create Student</p>
		</div>
		<p class="success">${success}</p>
		<div class="add-content">
			<form:form action="add" method="POST" modelAttribute="fullstudentinfo">
				<table>
					<tr>
						<td class="colum-name">Student Code</td>
						<td class="colum-input">
							<form:input path="studentCode" />
						</td>
						<td class="colum-error"><form:errors path="studentCode" cssClass="error"/></td>
					</tr>
					<tr>
						<td class="colum-name">Student Name</td>
						<td class="colum-input">
							<form:input path="studentName" />
						</td>
						<td class="colum-error"><form:errors path="studentName" cssClass="error"/></td>
					</tr>
					<tr>
						<td class="colum-name">Date of birth</td>
						<td class="colum-input">
							<form:input type="date" path="dateOfBirth" />
						</td>
						<td class="colum-error"><form:errors path="dateOfBirth" cssClass="error"/></td>
					</tr>
					<tr>
						<td class="colum-name">Address</td>
						<td class="colum-input">
							<form:input path="address" />
						</td>
						<td class="colum-error"><form:errors path="address" cssClass="error"/></td>
					</tr>
					
				</table>
				<input class="add-btn" type="submit" value="CREATE">
				<input class="reset-btn "type="button" value="RESET">
			</form:form>
		</div>
		<div class="add-footer"></div>
	</div>
	
</body>
</html>