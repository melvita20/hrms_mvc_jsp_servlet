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
				<c:if test="${not empty status}">
					<div class="alert alert-success mt-4" role="alert">${status}</div>
				</c:if>

				<form name="addDepartment" method="POST"
					action="<%=request.getContextPath()%>/SalaryController?action=add">
					<div class="row">
						<div class="col-sm-5 form-group">
							<label for="empid">Employee ID</label> <input type="text"
								class="form-control" id="empidText" name="empid"
								placeholder="Employee Id" required disabled
								value="<%=request.getParameter("empid")%>"> <input
								type=hidden name="empid"
								value="<%=request.getParameter("empid")%>">

						</div>
					</div>
					<div class="row">
						<div class="col-sm-5 form-group">
							<label for="basic">Basic Salary</label> <input type="text"
								class="form-control" id="basicText" name="basic"
								placeholder="Basic Salary" required>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-5 form-group">
							<label for="hrapercent">HRA Percentage</label> <input type="text"
								class="form-control" id="hrapercentText" name="hrapercent"
								placeholder="HRA Percentage" required>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-5 form-group">
							<label for="dapercent">DA Percentage</label> <input type="text"
								class="form-control" id="dapercentText" name="dapercent"
								placeholder="DA Percentage" required>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-5 form-group">
							<label for="itpercent">IT Percentage</label> <input type="text"
								class="form-control" id="itpercentText" name="itpercent"
								placeholder="IT Percentage" required>
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