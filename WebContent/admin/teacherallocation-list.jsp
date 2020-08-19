<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teachers Allocation</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
 
 <div class= "container">
 <br/><br/>

  <a href="<%=request.getContextPath()%>/TeacherAllocation?action=new" class="btn btn-outline-success">Add New Subject Allocation</a>
		 <table class="table table-striped">
		  <thead class="thead-dark">
		    <tr> 
		      <th>Subject Class Id</th>
		      <th>Teacher Name</th>
		      <th>Class Name</th>
		      <th>Subject Name</th>
		      
		      <th> Action</th>
		    </tr>
		  </thead>
		    <c:forEach var="teacherSubjectClass" items="${teacherSubjectClassList}">
		            <tr>
			            <td>
			               <c:out value="${teacherSubjectClass.id}"></c:out>
			            </td>
			            <td>
			               <c:out value="${teacherSubjectClass.getTeacher().getFirstName()}"></c:out>
			               <c:out value="${teacherSubjectClass.getTeacher().getLastName()}"></c:out>
			            </td>
			            <td>
			               <c:out value="${teacherSubjectClass.getSubjectClass().getSclass().getName()}"></c:out>
			            </td>
			            <td>
			               <c:out value="${teacherSubjectClass.getSubjectClass().getSubject().getName()}"></c:out>
			            </td>
			            			           
			            <td>
			            <a href="<%=request.getContextPath()%>/TeacherAllocation?action=edit&id=<c:out value="${teacherSubjectClass.id}"></c:out>" class="btn btn-outline-primary">Edit</a>
			            <a href="<%=request.getContextPath()%>/TeacherAllocation?action=delete&id=<c:out value="${teacherSubjectClass.id}"></c:out>" class="btn btn-outline-danger">Delete</a>
			            </td>
		            
		            </tr>    
		    </c:forEach>
		
		  <tbody></tbody>
		 </table>
 </div>
 

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" ></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>