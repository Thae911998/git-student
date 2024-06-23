<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="index.jsp"></jsp:include>
	
	
	<h4>New Student Information</h4>
	<form:form action="/student_registration/editstudent" method="post" modelAttribute="student">
	<div class="alert-danger col-sm-5">${error_msg}</div>
	
		<div class="mb-8">
			
			<div class="col-sm-5">
				<form:input type="hidden" class="form-control" path='id'></form:input>
				<form:errors path='id' class="text-danger"></form:errors>
			</div>
		</div>
		
		<div class="mb-8">
			<form:label path='student_id' class="form-label">Student id</form:label>
			<div class="col-sm-5">
				<form:input type="text" class="form-control" path='student_id'></form:input>
				<form:errors path='student_id' class="text-danger"></form:errors>
			</div>
		</div>
		
		<div class="mb-8">
			<form:label path='student_name' class="form-label">Student Name</form:label>
			<div class="col-sm-5">
				<form:input type="text" class="form-control" path='student_name'></form:input>
				<form:errors path='student_name' class="text-danger"></form:errors>
			</div>
		</div>
	<div  class="col-sm-5">
			<input type="submit" value="EditStudent" class="btn btn-primary" />
		</div>
		</form:form>
	
</body>
</html>