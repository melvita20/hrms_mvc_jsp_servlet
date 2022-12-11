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
	List<Employee> employees = (List<Employee>) request.getAttribute("employeeList");
	%>
	<div class="container mt-5">
		<div class="row">
			<div class="col-12">
				<div class="alert alert-info mt-4" role="alert">
					Welcome
					<%=userLogin.getUser_name()%></div>
				<a href="<%=request.getContextPath()%>/jsp/add_employee.jsp"><button
						class="btn btn-primary">Add New Employee</button></a>

				<c:if test="${not empty status}">
					<div class="alert alert-success mt-4" role="alert">${status}</div>
				</c:if>

				<table class="table mt-4">
					<thead>
						<tr>
							<th scope="col">ID</th>
							<th scope="col">Name</th>
							<th scope="col">Address</th>
							<th scope="col">Gender</th>
							<th scope="col">Contact Number</th>
							<th scope="col">Email</th>
							<th scope="col">Designation</th>
							<th scope="col">Birthday</th>
							<th scope="col">Hire Date</th>
							<th scope="col"></th>
							<th scope="col"></th>
						</tr>
					</thead>
					<tbody>
						<%
						for (Employee emp_item : employees) {
						%>
						<tr>
							<td><span><%=emp_item.getEmpId()%></span></td>
							<td><span><%=emp_item.getFname() + "\t" + emp_item.getMname() + "\t" + emp_item.getLname()%></span></td>
							<td><span><%=emp_item.getHomeaddress_line1() + "," + emp_item.getHomeaddress_line2() + ","
		+ emp_item.getHomeaddress_street() + "," + emp_item.getHomeaddress_city() + ","
		+ emp_item.getHomeaddress_state() + "," + emp_item.getZip()%></span></td>
							<td><span><%=emp_item.getGender()%></span></td>
							<td><span><%=emp_item.getPhonenumber()%></span></td>
							<td><span><%=emp_item.getEmail()%></span></td>
							<td><span><%=emp_item.getDesignation()%></span></td>
							<td><span><%=emp_item.getDOB()%></span></td>
							<td><span><%=emp_item.getHire_date()%></span></td>
							<td>
							<form name="editform" method="post" action="<%=request.getContextPath()%>/jsp/edit_employee.jsp?employee=<%=emp_item%>">
								<button class="btn btn-primary btn-sm">Edit</button>
							</form>
							</td>
							<td>
								<form name="deleteform" method="POST"
									action="<%=request.getContextPath()%>/EmployeeController?action=delete">
									<input type="hidden" name="employeeid"
										value="<%=emp_item.getEmpId()%>" />
									<button type=submit class="btn btn-danger btn-sm">Delete</button>
								</form>
							</td>
						</tr>
						<%
						}
						%>
					</tbody>
				</table>
				<c:if test="${not empty empstatus}">
					<div class="alert alert-danger mt-4" role="alert">${empstatus}</div>
				</c:if>
			</div>
		</div>
	</div>
	<h1></h1>

</body>
</html>