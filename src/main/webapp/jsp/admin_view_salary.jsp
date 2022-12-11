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
				<form class="form-inline" name="searchform" method="post"
					action="<%=request.getContextPath()%>/SalaryController?action=search">
					<label class="sr-only" for="searchid">Employee ID</label> <input
						type="text" class="form-control mb-2 mr-sm-2" id="searchid"
						placeholder="Employee ID" name="searchid" required>
					<button type="submit" class="btn btn-primary mb-2">Search</button>
				</form>
				<c:if test="${not empty employeeDetail}">
					<%
					Employee employeeDetail = (Employee) request.getAttribute("employeeDetail");
					%>
					<table class="table mt-4">
						<tbody>
							<tr>
								<td scope="col">ID</td>
								<td><span><%=employeeDetail.getEmpId()%></span></td>
							</tr>
							<tr>
								<td scope="col">Name</td>
								<td><span><%=employeeDetail.getFname() + "\t" + employeeDetail.getMname() + "\t" + employeeDetail.getLname()%></span></td>
							</tr>
							<tr>
								<td scope="col">Gender</td>
								<td><span><%=employeeDetail.getGender()%></span></td>
							</tr>
							<tr>
								<td scope="col">Contact Number</td>
								<td><span><%=employeeDetail.getPhonenumber()%></span></td>
							</tr>
							<tr>
								<td scope="col">Email</td>
								<td><span><%=employeeDetail.getEmail()%></span></td>
							</tr>
							<tr>
								<td scope="col">Designation</td>
								<td><span><%=employeeDetail.getDesignation()%></span></td>
							</tr>
							<tr>
								<td scope="col">DOB</td>
								<td><span><%=employeeDetail.getDOB()%></span></td>
							</tr>
							<tr>
								<td scope="col">Hire Date</td>
								<td><span><%=employeeDetail.getHire_date()%></span></td>
							</tr>
						</tbody>
					</table>
					<div class="d-inline-block">
							<form method="post" action="<%=request.getContextPath()%>/SalaryController?action=generate">
								<input type="hidden" name="empid"
									value="<%=employeeDetail.getEmpId()%>" />
								<button class="btn btn-primary">Generate Salary Slip</button>
							</form>
					</div>
					<div class="d-inline-block">
							<form method="post" action="<%=request.getContextPath()%>/jsp/add_salary.jsp?empid=<%=employeeDetail.getEmpId()%>">
								<button class="btn btn-primary">Add Salary</button>
							</form>
					</div>
				</c:if>

				<c:if test="${not empty exception}">
					<div class="alert alert-danger mt-4" role="alert">${exception}</div>
				</c:if>


			</div>
		</div>
	</div>
	<h1></h1>

</body>
</html>