<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	 <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

     <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

     <!-- Latest compiled and minified JavaScript -->
     <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/awesome-bootstrap-checkbox/0.3.7/awesome-bootstrap-checkbox.css">
     
     <meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 
	<link rel="icon" href="<c:url value="/resource/images/icons/favicon.ico"/>">
	<link rel="stylesheet" href="<c:url value="/resource/vendor/bootstrap/css/bootstrap.min.css"/>">
	<link rel="stylesheet" href="<c:url value="/resource/fonts/font-awesome-4.7.0/css/font-awesome.min.css"/>">
	<link rel="stylesheet" href="<c:url value="/resource/vendor/animate/animate.css"/>">
	<link rel="stylesheet" href="<c:url value="/resource/vendor/select2/select2.min.css"/>">
	<link rel="stylesheet" href="<c:url value="/resource/vendor/perfect-scrollbar/perfect-scrollbar.css"/>">
	<link rel="stylesheet" href="<c:url value="/resource/css/util.css"/>">
	<link rel="stylesheet" href="<c:url value="/resource/css/main.css"/>">
	 -->
</head>
<body>
	
	<!-- <%@ include file="header.jsp" %> -->
	
	
	<div class="limiter">
		<div class="container-table100">
			<div class="wrap-table100">
				<div class="table100 ver1 m-b-110">
					<div class="table100-head">
					<table>
							<thead>
								<tr class="row100 head">
									<th class="cell100 column5">Select</th>
									<th class="cell100 column4">Student Code</th>
									<th class="cell100 column1">Student Name</th>
									<th class="cell100 column2">Date of birth</th>
									<th class="cell100 column3">Avg Score</th>
									<th class="cell100 column1">Address</th>
								</tr>
							</thead>
						</table>
					</div>
					
					<div class="table100-body js-pscroll">
						<table>
							<tbody>
								<tr class="row100 body">
									<td class="cell100 column5">
										<div class="checkbox checkbox-success"><input type="checkbox" id="checkbox1" class="styled"><label></label></div>
									</td>
									<td class="cell100 column1"></td>
									<td class="cell100 column2"></td>
									<td class="cell100 column3"></td>
									<td class="cell100 column4"></td>
									
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>