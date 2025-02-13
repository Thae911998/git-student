<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
        
    
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

	<div class="container">
		<div class="main_contents">
    		<div id="sub_content">
				<form:form>
		            <h2 class="col-md-6 offset-md-2 mb-5 mt-4">Student Registration</h2>
		            <div class="row mb-4">
		                <div class="col-md-2"></div>
		                <label for="studentID" class="col-md-2 col-form-label">Student ID</label>
		                <div class="col-md-4">
		                    <form:input type="text" class="form-control" id="studentID" path="studentId" disabled/>
		                </div>
		            </div>
		            <div class="row mb-4">
		                <div class="col-md-2"></div>
		                <label for="name" class="col-md-2 col-form-label">Name</label>
		                <div class="col-md-4">
		                    <form:input type="text" class="form-control" id="name" path="name"/>
		                </div>
		            </div>
		            <div class="row mb-4">
		                <div class="col-md-2"></div>
		                <label for="dob" class="col-md-2 col-form-label">DOB</label>
		                <div class="col-md-4">
		                    <form:input type="date" class="form-control" id="dob" path="dob"/>
		                </div>
		            </div>
		            <fieldset class="row mb-4">
		                <div class="col-md-2"></div>
		                <legend class="col-form-label col-md-2 pt-0">Gender</legend>
		                <div class="col-md-4">
		                    <div class="form-check-inline">
		                        <form:input class="form-check-input" type="radio" path="gridRadios" id="gridRadios1" value="option1"
		                            checked/>
		                        <label class="form-check-label" for="gridRadios1">
		                            Male
		                        </label>
		                    </div>
		                    <div class="form-check-inline">
		                        <form:input class="form-check-input" type="radio" path="gridRadios" id="gridRadios2" value="option2"/>
		                        <label class="form-check-label" for="gridRadios2">
		                            Female
		                        </label>
		                    </div>
		    
		                </div>
		            </fieldset>
		    
		            <div class="row mb-4">
		                <div class="col-md-2"></div>
		                <label for="phone" class="col-md-2 col-form-label">Phone</label>
		                <div class="col-md-4">
		                    <form:input type="text" class="form-control" id="phone" value="+95 " path="phone"/>
		                </div>
		            </div>
		            <div class="row mb-4">
		                <div class="col-md-2"></div>
		                <label for="education" class="col-md-2 col-form-label">Education</label>
		                <div class="col-md-4">
		                    <form:select class="form-select" aria-label="Education" id="education" path="education">
		                        <form:option value="NONE">Bachelor of Information Technology</form:option>
		                        <form:option value="1">Diploma in IT</form:option>
		                        <form:option value="2">Bachelor of Computer Science</form:option>
		                    </form:select>
		                </div>
		            </div>
		            <fieldset class="row mb-4">
		                <div class="col-md-2"></div>
		                <legend class="col-form-label col-md-2 pt-0">Attend</legend>
		    
		                <div class="col-md-4">
		                    <div>
		                        <c:forEach items="${lstCourse}" var="course">
		                        ${course.name}
								<form:checkbox class="form-check-input" id="gridRadios1" path="attend" value="${course.cId}"/>
								</c:forEach>
		                    </div>
		                </div>
		            </fieldset>
		            <div class="row mb-4">
		                <div class="col-md-2"></div>
		                <label for="name" class="col-md-2 col-form-label">Photo</label>
		                <div class="col-md-4">
		                    <form:input type="file" class="form-control" id="name" path="file"/>
		                </div>
		            </div>
			    
			            <div class="row mb-4">
			                <div class="col-md-4"></div>
			    
			                <div class="col-md-4">
			                    <a href="STU002-01.html">
			                        <input type="submit" class="btn btn-secondary" value="Update">

			                        
			                    </a>
			    
			                    <!-- Button trigger modal -->
			                    <input type="submit" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal" value="Delete">                    
			                    <!-- Modal -->
			                    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
			                        aria-hidden="true">
			                        <div class="modal-dialog modal-dialog modal-dialog-centered">
			                            <div class="modal-content">
			                                <div class="modal-header">
			                                    <h5 class="modal-title" id="exampleModalLabel">Student Deletion</h5>
			                                    <input type="submit" class="btn-close" data-bs-dismiss="modal"
			                                        aria-label="Close">
			                                </div>
			                                <div class="modal-body">
			                                    Are you sure you want to delete?
			                                </div>
			                                <div class="modal-footer">
			                                    <input type="submit"class="btn btn-secondary" data-bs-dismiss="modal" value="Ok">
			                                    <input type="submit" class="btn btn-danger" value="Cancel">
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