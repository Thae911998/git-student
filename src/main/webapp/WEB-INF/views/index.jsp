<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="<c:url value="/resources/css/test.css"/> ">
        <link rel="stylesheet" href="<c:url value="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"/>" 
         integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

        <link rel="stylesheet" href="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>" >
    
    	<script src="<c:url value="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"/>"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
    
        <title>Index Registration</title>
</head>
<body>

		<div id="testheader">
	        <div class="container">
	            <div class=row>        
	                <div class="col-md-5 ">
			            <a href="/student_registration/stureg">
			            Student Registration</a>
	        		</div>  
	        		<div class="col-md-6">
			            <p>User:<a href="${user.id} ${user_name}"></a></p>
			            <p>Current Date : YY.MM.DD </p>
			        </div>  
			        <div class="col-md-1" >
			            <button class="btn-basic" id="lgnout-button" value="Log Out"></button>
			        </div>        
	       		</div>
			</div>
		</div>

		<div class="container">
		    <div class="sidenav">
		        
		        <button class="dropdown-btn" > Class Management <i class="fa fa-caret-down"></i></button>
		        
		        <div class="dropdown-container">
		          <a href=" /student_registration/course">Course Registration </a>
		          <a href="/student_registration/addstudent">Student Registration </a>
		          <a href="/student_registration/students">Student Search </a>
		        </div>
		        <a href="/student_registration/user">Users Management</a>
		    </div>
       </div>
       <div id="testfooter">
            <span>Copyright &#169; ACE Inspiration 2022</span>
       </div>
       <script src="<c:url value="/resources/js/indexdrop.js" />"></script>
</body>
</html>