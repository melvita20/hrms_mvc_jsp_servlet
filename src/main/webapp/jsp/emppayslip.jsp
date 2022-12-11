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
	<%@ include file="./employee_navbar.jsp"%>

	<%
	UserLogin userLogin = (UserLogin) session.getAttribute("userinfo");
	Employee employee = (Employee) request.getAttribute("employeeObj");
	List<Salary> sal = employee.getSalary();
	%>
	<div class="container mt-5">
		<div class="row">
			<div class="col-12">
				<div class="alert alert-info mt-4" role="alert">
					Welcome
					<%=employee.getFname()%></div>

				<h2>Salary Details</h2>
				<table class="table">
					<tbody>
						<%for(Salary sal_item:sal){ %>
						<tr>
							<td>Basic Salary:</td>
							<td><span><%=sal_item.getBASIC()%></span></td>
						</tr>

						<tr>
							<td>DA</td>
							<td><span><%= sal_item.getDA() %></span></td>
						</tr>
						<tr>
							<td>HRA</td>
							<td><%= sal_item.getHRA() %></td>
						</tr>
						<tr>
							<td>Gross Salary</td>
							<td><span><%= sal_item.getGross_salary()%></span></td>
						</tr>
						<tr>
							<td>Income Tax</td>
							<td><span><%= sal_item.getIncometax() %></span></td>
						</tr>
						<tr>
							<td>Net Salary</td>
							<td><span><%= sal_item.getNetsalary() %></span></td>
						</tr>
						<%} %>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<h1></h1>

</body>
</html>