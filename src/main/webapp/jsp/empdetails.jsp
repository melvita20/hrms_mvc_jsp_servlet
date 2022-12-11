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
	<%@ include file="./employee_navbar.jsp"%>

	<%
	UserLogin userLogin = (UserLogin) session.getAttribute("userinfo");
	Employee employee = (Employee) request.getAttribute("employeeObj");
	%>
	<div class="container mt-5">
		<div class="row">
			<div class="col-12">
				<div class="alert alert-info mt-4" role="alert">
					Welcome
					<%=employee.getFname()%></div>
				<h2>Profile</h2>
				<table class="table">
					<tbody>
						<tr>
							<td>Name:</td>
							<td><span><%=employee.getFname()%></span>&nbsp;<span><%=employee.getLname() %></span></td>
						</tr>
						
						<tr>
							<td>House Address</td>
							<td><span><%=employee.getHomeaddress_line1()%>,<%=employee.getHomeaddress_line2() %>,<%=employee.getHomeaddress_street() %>,<%=employee.getHomeaddress_city() %></span></td>
						</tr>
						<tr>
							<td>Contact Number:</td>
							<td><%=employee.getPhonenumber()%></td>
						</tr>
						<tr>
							<td>Date of Birth:</td>
							<td><%=employee.getDOB()%></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<h1></h1>

</body>
</html>