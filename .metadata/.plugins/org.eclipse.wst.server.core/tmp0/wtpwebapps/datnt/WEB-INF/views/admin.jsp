<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Admin</title>
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Catamaran:100,200,300,400,500,600,700,800,900|Cormorant+Garamond:300,300i,400,400i,500,500i,600,600i,700,700i">
	<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<link rel="stylesheet" href="<c:url value="/assets/css/style.css"/>">
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
    <script src="<c:url value="/assets/js/scripts.js"/>"></script>
    
</head>
<body  style="background-image: url('<c:url value="/assets/img/backgrounds/1.jpg"/>');">
  
  <!--------------------------------------------------------------------- 
          			        PHẦN HEADER 
  ---------------------------------------------------------------------->
  <header> 
    <a href="${pageContext.request.contextPath}/admin" class="header-brand">runsystem</a>
	<nav>
	  <ul>
	    <li><a href="#"></a></li>
	  </ul>
	  <a href="${pageContext.request.contextPath}/logout" class="header-logout">Logout</a> 
	</nav> 
  </header>

  <!--------------------------------------------------------------------- 
          			        PHẦN DATATABLES
  ---------------------------------------------------------------------->
  <div class="container" style="height: 700px; background-color: #fff; border-radius: 10px;box-shadow: 0 0 10px #fff;">
    <div class="row">
      <div class="col-md-12">
        <h3 style="color: #111;">Datatable of Student</h3>
        <!--------------------------------------------------------------------- 
                			        PHẦN SEARCH
        ---------------------------------------------------------------------->
        <form:form id="form-search" class="form-horizontal" role="form" action="${pageContext.request.contextPath}/admin/search" method="GET" modelAttribute="student">
	 	  <div class="form-group">
	        <label for="contain">Student Code</label>
            <form:input class="form-control" type="text" path="studentCode"/>
          </div>
          <div class="form-group">
            <label for="contain">Student Name</label>
            <form:input class="form-control" type="text" path="studentName"/>
          </div>
          <input type="hidden" name="page" value="1">
          <button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
	    </form:form>  
        <div class="table-responsive">
           <!--------------------------------------------------------------------- 
          						       PHẦN DATATABLES 
           ---------------------------------------------------------------------->
          <table id="mytable" class="table table-bordred table-striped">
            
            <!-- HEAD -->
            <thead style="background-color: #659bf6; color: #111;">
			  <th><input type="checkbox" id="checkall" /></th>
			  <th>Code</th>
			  <th>Name</th>
			  <th>Date of Birth</th>
			  <th>Avg Scores</th>
              <th>Address</th>
			  <th>Edit</th>
			  <th>Delete</th>
            </thead>
   			<!--  BODY  -->
   			<tbody id="table-result" style="text-align: left;">
				<!-- Thông tin danh sách student sẽ được insert tại đây  -->
				<c:forEach items="${pageResult}" var="std">
					<tr id="stdRow-${std.studentId}">
						<td><input type="checkbox" class="checkthis" name="id" value="${std.studentId}"/></td>
						<td>${std.studentCode}</td>
						<td>${std.studentName}</td>
						<td>${std.dateOfBirth}</td>
						<td>${std.avgScore}</td>
						<td>${std.address}</td>
						<td><p><button class="btn btn-primary btn-xs edit-btn" data-title="Edit" data-toggle="modal" data-target="#edit" data-placement="top" rel="tooltip" onclick="getInfoUpdate('${std.studentId}');"><span class="glyphicon glyphicon-pencil"></span></button></p></td>
						<td><p><button class="btn btn-danger btn-xs remove-btn" data-title="Delete" data-toggle="modal" data-target="#delete" data-placement="top" rel="tooltip" onclick="deleteStudent('${std.studentId}');"><span class="glyphicon glyphicon-trash"></span></button></p></td>
					</tr>
				</c:forEach>
 			</tbody>
          </table>
          <!--------------------------------------------------------------------- 
          						       PHẦN PAGENATION 
           ---------------------------------------------------------------------->
		  <div class="clearfix"></div>
		  <div class="create-remove pull-left">
		  	<button id="remove-list" class="btn-danger" data-title="Delete" data-toggle="modal" data-target="#delete-list" data-placement="top" rel="tooltip">Remove</button>
		  	<button class="btn-primary" data-title="Create new student" data-toggle="modal" data-target="#create" data-placement="top" rel="tooltip">Create new</button>
		  </div>
		  <ul class="pagination pull-right">
		    <!-- 
		    <li id="prev" class="disabled"><a href="#" data-toggle="tooltip" title="Previous"><span class="glyphicon glyphicon-chevron-left"></span></a></li>
		    <li class="active"><a href="#">1</a></li>
		    <li id="next"><a href="#" data-toggle="tooltip" title="Next"><span class="glyphicon glyphicon-chevron-right"></span></a></li>
		     -->
		     <c:if test="${pagenation.maxPage > 0}">
		     	<c:if test="${pagenation.curPage == 1}">
		     		<li id="prev" class="disabled"><a href="#" data-toggle="tooltip" title="Previous"><span class="glyphicon glyphicon-chevron-left"></span></a></li>
		     	</c:if>
		     	<c:if test="${pagenation.curPage > 1}">
		     		<li id="prev"><a href="${pageContext.request.contextPath}/admin/search?studentCode=${student.studentCode}&studentName=${student.studentName}&page=${pagenation.curPage - 1}" data-toggle="tooltip" title="Previous"><span class="glyphicon glyphicon-chevron-left"></span></a></li>
		     	</c:if>
		     	<c:forEach var="num" begin="${pagenation.startPage}" end="${pagenation.endPage}">
		     		<c:if test="${pagenation.curPage == num}">
		     			<li class="active"><a href="${pageContext.request.contextPath}/admin/search?studentCode=${student.studentCode}&studentName=${student.studentName}&page=${num}">${num}</a></li>
		     		</c:if>
		     		<c:if test="${pagenation.curPage != num}">
		     			<li><a href="${pageContext.request.contextPath}/admin/search?studentCode=${student.studentCode}&studentName=${student.studentName}&page=${num}">${num}</a></li>
		     		</c:if>
		     	</c:forEach>
		     	<c:if test="${pagenation.curPage == pagenation.maxPage}">
		     		<li id="next" class="disabled"><a href="#" data-toggle="tooltip" title="Next"><span class="glyphicon glyphicon-chevron-right"></span></a></li>
		     	</c:if>
		     	<c:if test="${pagenation.curPage < pagenation.maxPage}">
		     		<li id="next"><a href="${pageContext.request.contextPath}/admin/search?studentCode=${student.studentCode}&studentName=${student.studentName}&page=${pagenation.curPage + 1}" data-toggle="tooltip" title="Next"><span class="glyphicon glyphicon-chevron-right"></span></a></li>
		     	</c:if>
		     </c:if>
		  </ul>
        </div> <!-- kết thúc .table-responsive -->
      </div> <!-- kết thúc .col-md-12 -->
	</div> <!-- kết thúc .row -->
  </div> <!-- kết thúc .container -->

  <div style="width: 100%; height: 100px;"></div>

  <!--------------------------------------------------------------------- 
          			 PHẦN POPUP MODEL CREATE NEW STUDENT
  ---------------------------------------------------------------------->
  <div class="modal fade" id="create" tabindex="-1" role="dialog" aria-labelledby="edit" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
          <h4 class="modal-title custom_align" id="Heading">Create New Student</h4>
        </div>
        <form action="${pageContext.request.contextPath}/admin/create" id="create-form" method="post">
	        <div class="modal-body">
	          <!-- Student's code -->
	          
	          <div class="form-group">
	            <input class="form-control " type="text" placeholder="Student's code" name="studentCode">
	          </div>
	          
	          <!-- Student's name -->
	          <div class="form-group">
	            <input class="form-control " type="text" placeholder="Student's name" name="studentName">
	          </div>
	          
	          <!-- Student's date of birth -->
	          <div class="form-group">
	            <input class="form-control " type="date" name="dateOfBirth">
	          </div>
	          
	          <!-- Student's Address -->
	          <div class="form-group">
	            <textarea rows="2" class="form-control" placeholder="Student's address" name="address"></textarea>
	          </div>
	        </div>
	        <div class="modal-footer ">
	          <input type="submit" class="btn btn-warning btn-lg" style="width: 100%;" value="Create">
	        </div>
        </form>
      </div> <!-- kết thúc .modal-content --> 
    </div> <!-- kết thúc .modal-dialog --> 
  </div>

  <!--------------------------------------------------------------------- 
          			 PHẦN POPUP MODEL DELETE LIST 
  ---------------------------------------------------------------------->
  <div class="modal fade" id="delete-list" tabindex="-1" role="dialog" aria-labelledby="edit" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
          <h4 class="modal-title custom_align" id="Heading">Delete this entry</h4>
        </div>
        
        <div class="modal-body">
          <div class="alert alert-warning"><span class="glyphicon glyphicon-warning-sign"></span> Are you sure you want to delete this Student?</div>
        </div>
        <div class="modal-footer ">
          <button id="accept-deletes" type="button" class="btn btn-warning" >Yes</button>
        </div>
      </div> <!-- kết thúc .modal-content --> 
    </div> <!-- kết thúc .modal-dialog --> 
  </div>

  <!--------------------------------------------------------------------- 
          			 PHẦN POPUP MODEL DELETE STUDENT 
  ---------------------------------------------------------------------->
  <div class="modal fade" id="delete" tabindex="-1" role="dialog" aria-labelledby="edit" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
          <h4 class="modal-title custom_align" id="Heading">Delete this entry</h4>
        </div>
        
        <div class="modal-body">
          <div class="alert alert-warning"><span class="glyphicon glyphicon-warning-sign"></span> Are you sure you want to delete this Student?</div>
        </div>
        <div class="modal-footer ">
          <input id="id-delete" type="hidden" >
          <button id="agree-delete" type="button" class="btn btn-warning" >Yes</button>
        </div>
      </div> <!-- kết thúc .modal-content --> 
    </div> <!-- kết thúc .modal-dialog --> 
  </div>

  <!--------------------------------------------------------------------- 
          			 PHẦN POPUP MODEL UPDATE STUDENT INFO
  ---------------------------------------------------------------------->
  <div class="modal fade" id="edit" tabindex="-1" role="dialog" aria-labelledby="edit" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
          <h4 class="modal-title custom_align" id="Heading">Edit Student</h4>
        </div>
        <form id="form-update" action=""  method="post">
	        <div class="modal-body">
	          <!-- Student code -->
	          <div class="form-group">
	            <input id="code-update" class="form-control " type="text" name="studentCode">
	          </div>
	          
	          <!-- Student name -->
	          <div class="form-group">
	            <input id="name-update" class="form-control " type="text" name="studentName">
	          </div>
	          
	          <!-- Student date -->
	          <div class="form-group">
	            <input id="date-update" class="form-control " type="date" name="dateOfBirth">
	          </div>
	          
	          <!-- Average Scores -->
	          <div class="form-group">
	            <input id="scores-update" class="form-control " type="text" name="avgScore">
	          </div>
	          
	          <!-- Address -->
	          <div class="form-group">
	            <textarea id="address-update" rows="2" class="form-control" name="address"></textarea>
	          </div>
	        </div>
	        <input id="id-update" type="hidden" name="studentId">
	        <div class="modal-footer ">
	          <button type="submit" class="btn btn-warning btn-lg" style="width: 100%;">Update</button>
	        </div>
        </form>
      </div> <!-- kết thúc .modal-content --> 
    </div> <!-- kết thúc .modal-dialog --> 
  </div>

</body>
</html>