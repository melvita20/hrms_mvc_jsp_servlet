<%@page import="com.capstone.mvc.hrms.domain.Department"%>
<%@page import="com.capstone.mvc.hrms.domain.Salary"%>
<%@page import="java.util.List"%>
<%@page import="com.capstone.mvc.hrms.domain.Employee"%>
<%@page import="com.capstone.mvc.hrms.domain.UserLogin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HRMS</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" />
</head>
<body>
	<%@ include file="./admin_navbar.jsp"%>

	<%
	UserLogin userLogin = (UserLogin) session.getAttribute("userinfo");
	%>
	<div class="container mt-5">
		<div class="row">
			<div class="col-12">
				<div class="alert alert-info mt-4" role="alert">
					Welcome
					<%=userLogin.getUser_name()%></div>

				<form name="addDepartment" method="POST"
					action="<%=request.getContextPath()%>/DepartmentController?action=add">
					<div class="row">
						<div class="col-sm-5 form-group">
							<label for="departmentid">Department ID</label> <input
								type="text" class="form-control" id="deptidText" name="deptid"
								placeholder="Department Id" required>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-5 form-group">
							<label for="departmentname">Department Name</label> <input
								type="text" class="form-control" id="deptnameText"
								name="deptname" placeholder="Department Name" required>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-5 form-group">
							<label for="departmentloc">Department Location</label> <input
								type="text" class="form-control" id="deptlocText" name="deptloc"
								placeholder="Department Location" required>
						</div>
					</div>
					<div class="row">
						<div class="col-12">
							<button type="submit" class="btn btn-primary">Submit</button>
							<button type="reset" class="btn btn-reset">Clear</button>
						</div>
					</div>
					
				</form>

				<c:if test="${not empty exception}">
					<div class="alert alert-danger mt-4" role="alert">${exception}</div>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>