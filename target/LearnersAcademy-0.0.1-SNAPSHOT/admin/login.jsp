<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v4.0.1">
    <title>Login</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/sign-in/">

    <!-- Bootstrap core CSS -->
<link href="<%=request.getContextPath()%>/assets/dist/css/bootstrap.css" rel="stylesheet">

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
    <!-- Custom styles for this template -->
    <link href="<%=request.getContextPath()%>/signin.css" rel="stylesheet">
  </head>
  <body class="text-center">
    <form class="form-signin" action="<%=request.getContextPath()%>/admin/Login" method="post">
	  <h1 class="h3 mb-3 font-weight-normal">Please Log in</h1>
	  <label for="inputEmail" class="sr-only">Email address</label>
	  <input type="email" id="inputEmail" name="inputemail" class="form-control" placeholder="Email address" required autofocus>
	  <label for="inputPassword" class="sr-only">Password</label>
	  <input type="password" id="inputPassword" name= "password" class="form-control" placeholder="Password" required>	  
		  <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>  	  
		  <c:if test="${loginmessage!=null}">
	     <span style="color: red;"><c:out value="${loginmessage}"></c:out></span>
    </c:if>
  </form>
    
</body>
</html>
