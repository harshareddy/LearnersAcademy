<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<title>Subject Class Allocation</title>
	</head>
<body>
 <jsp:include page="header.jsp"></jsp:include>
  <div class= "container">
     <br/><br/>
     <form action="<%=request.getContextPath() %>/TeacherAllocation">          
          <c:if test="${teacherSubjectClass==null}">
                 <h2>Add Teacher Allocation</h2>
                 <input type="hidden" name="action" value="insert">
          </c:if>
          <c:if test="${teacherSubjectClass!=null}">
                <h2>Update Teacher Allocation</h2>
                 <input type="hidden" name="action" value="update">
                 <input type="hidden" name="id" value='<c:out value="${teacherSubjectClass.id}"></c:out>'>
          </c:if>          

           <div class="form-group">
    		  <select name="teacherid" class="form-control">
			     <c:forEach items="${teacherList}" var="teacher">
			        <option value="${teacher.id}" ${teacher.id == teacherSubjectClass.teacher.id ? 'selected="selected"' : ''} >${teacher.firstName} ${teacher.lastName}</option>
			    </c:forEach>
            </select>
            </div>
            <div class="form-group">
    		  <select name="subjectclassid" class="form-control">
			    <c:forEach items="${subjectClassList}" var="subjectClass">
			        <option value="${subjectClass.id}" ${subjectClass.id == teacherSubjectClass.subjectClass.id ? 'selected="selected"' : ''}>${subjectClass.sclass.name} ${subjectClass.subject.name}</option>
			    </c:forEach>
            </select>
            </div>
            
		  <button type="submit" class="btn btn-primary">Submit</button>
      </form>
  </div>

</body>
</html>