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
    
        <title>Course Registration</title>
</head>
<body>
	<%@ include file="index.jsp" %>
	<div class="container">
		<div class="main_contents">
    		<div id="sub_content">
    			<form:form action="createcourse" method="post"  modelAttribute="course">
			        <h2 class="col-md-6 offset-md-2 mb-5 mt-4">Course Registration</h2>
			        <div class="row mb-4">
			            <div class="col-md-2"></div>
			            <label for="id" class="col-md-2 col-form-label"> ID</label>
			            <div class="col-md-4">
			                <form:input type="text" class="form-control" id="id" path="course_id"/>
			            </div>
			        </div>
			
			        <div class="row mb-4">
			            <div class="col-md-2"></div>
			            <label for="name" class="col-md-2 col-form-label">Name</label>
			            <div class="col-md-4">
			                <form:input type="text" class="form-control" id="name" path="course_name"/>
			            </div>
			        </div>
			        <div class="row mb-4">
			            <div class="col-md-4"></div>
			            <div class="col-md-6">
			                <input type="submit" class="btn btn-secondary col-md-2" data-bs-toggle="modal" data-bs-target="#exampleModal" value="Add"/>
			                <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
			                    aria-hidden="true">
			                    <div class="modal-dialog modal-dialog-centered">
			                        <div class="modal-content">
			                            <div class="modal-header">
			                                <h5 class="modal-title" id="exampleModalLabel">Course Registration</h5>
			                                <input type="button" class="btn-close" data-bs-dismiss="modal"
			                                    aria-label="Close"/>
			                            </div>
			                            <div class="modal-body">
			                                <h5 style="color: rgb(127, 209, 131);">Registered Succesfully !</h5>
			                            </div>
			                            <div class="modal-footer">
			                                <input type="button" class="btn btn-success col-md-2" data-bs-dismiss="modal" value="Ok"/>
			                            </div>
			                        </div>
			                    </div>
			           		 </div>
			       		 </div>
			        </div>
        		</form:form>
    		</div>
		</div>
	</div>
</body>
</html>