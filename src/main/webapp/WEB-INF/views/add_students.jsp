<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="index.jsp"></jsp:include>
	<div id="sub_content">
		<form:form action="/student_registration/addstudent" method="post"
			modelAttribute="student">

			<h2 class="col-md-6 offset-md-2 mb-5 mt-4">Student Registration</h2>
			<div class="row mb-4">
				<div class="col-md-2"></div>
				<form:label path='student_id' class="col-md-2 col-form-label">Student
				ID</form:label>
				<div class="col-md-4">
					<form:input type="text" class="form-control" value="STU001"
						path='student_id' disabled=""></form:input>
				</div>
			</div>
			<div class="row mb-4">
				<div class="col-md-2"></div>
				<form:label path='student_name' class="col-md-2 col-form-label">Name</form:label>
				<div class="col-md-4">
					<form:input type="text" class="form-control" path='student_name'
						value="Harry"></form:input>
				</div>
			</div>
			<div class="row mb-4">
				<div class="col-md-2"></div>
				<form:label path='dob' class="col-md-2 col-form-label">DOB</form:label>
				<div class="col-md-4">
					<form:input type="date" class="form-control" path='dob'></form:input>
				</div>
			</div>
			<fieldset class="row mb-4">
				<div class="col-md-2"></div>
				<legend class="col-form-label col-md-2 pt-0">Gender</legend>
				<div class="col-md-4">
					<div class="form-check-inline">
						<form:radiobutton path="gender" id="genderMale" value="Male"
							checked="true" />
						<label for="genderMale">Male</label>
					</div>
					<div class="form-check-inline">
						<form:radiobutton path="gender" id="genderFemale" value="Female" />
						<label for="genderFemale">Female</label>
					</div>
				</div>
			</fieldset>

			<div class="row mb-4">
				<div class="col-md-2"></div>
				<label for="education" class="col-md-2 col-form-label">Education</label>
				<div class="col-md-4">
					<form:select path="education" class="form-select" id="education"
						required="true">
						<form:options items="${selected_education}" itemValue="eid"
							itemLabel="ename" />
					</form:select>
				</div>
			</div>

			<div class="row mb-4">
				<div class="col-md-2"></div>
				<form:label path='phone' class="col-md-2 col-form-label">Phone</form:label>
				<div class="col-md-4">
					<form:input type="text" class="form-control" path='phone'
						value="+95 "></form:input>
				</div>
			</div>

			<fieldset class="row mb-4">
						<div class="col-md-2"></div>
						<form:label path="course" class="col-form-label col-md-2 pt-0">Course</form:label>
						<div class="col-md-4">
							<div class="col-md-10">
								<form:checkboxes items="${selected_course}"  path="course" itemValue="course_id" itemLabel="course_name"></form:checkboxes>
								<span> </span>
							</div>
						</div>
			</fieldset>
			<div class="row mb-4">
				<div class="col-md-2"></div>
				<label for="photo" class="col-md-2 col-form-label">Photo</label>
				<div class="col-md-4">
					<input type="file" class="form-control" id="photo1" name="photo1"
						accept="image/**" multiple />
				</div>
			</div>
			<div class="row mb-4">
				<div class="col-md-4"></div>

				<div class="col-md-4">
					<button type="button" class="btn btn-danger ">Reset</button>
					<button type="button" class="btn btn-secondary col-md-2"
						data-bs-toggle="modal" data-bs-target="#exampleModal">
						Add</button>
					<div class="modal fade" id="exampleModal" tabindex="-1"
						aria-labelledby="exampleModalLabel" aria-hidden="true">
						<div class="modal-dialog modal-dialog-centered">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel">Student
										Registration</h5>
									<button type="button" class="btn-close" data-bs-dismiss="modal"
										aria-label="Close"></button>
								</div>
								<div class="modal-body">
									<h5 style="color: rgb(127, 209, 131);">Registered
										Successfully !</h5>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-success col-md-2"
										data-bs-dismiss="modal">OK</button>

								</div>
							</div>
						</div>
					</div>
				</div>


			</div>
		</form:form>
	</div>
</body>
</html>