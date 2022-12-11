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
	List<Department> departments = (List<Department>) request.getAttribute("departmentsList");
	%>
	<div class="container mt-5">
		<div class="row">
			<div class="col-12">
				<div class="alert alert-info mt-4" role="alert">
					Welcome
					<%=userLogin.getUser_name()%></div>
				<a href="<%=request.getContextPath()%>/jsp/add_department.jsp"><button
						class="btn btn-primary">Add New Department</button></a>

				<c:if test="${not empty status}">
					<div class="alert alert-success mt-4" role="alert">${status}</div>
				</c:if>

				<table class="table mt-4">
					<thead>
						<tr>
							<th scope="col">ID</th>
							<th scope="col">Name</th>
							<th scope="col">Location</th>
							<th scope="col"></th>
							<th scope="col"></th>
						</tr>
					</thead>
					<tbody>
						<%
						for (Department dep_item : departments) {
						%>
						<tr>
							<td><span><%=dep_item.getDepartment_id()%></span>
							<input type="hidden" name="deptid"
										value="<%=dep_item.getDepartment_id()%>" />
							</td>
							<td><span><%=dep_item.getDep_name()%></span></td>
							<td><span><%=dep_item.getDep_location()%></span></td>
							<td>
								<a href="<%=request.getContextPath()%>/jsp/edit_department.jsp?did=<%=dep_item.getDepartment_id() %>&dname=<%=dep_item.getDep_name()%>&dloc=<%=dep_item.getDep_location()%>">
								<button class="btn btn-primary btn-sm">Edit</button>
								</a>
							</td>
							<td>
								<form name="deleteform" method="POST"
									action="<%=request.getContextPath()%>/DepartmentController?action=delete">
									<input type="hidden" name="departmentid"
										value="<%=dep_item.getDepartment_id()%>" />
									<button type=submit class="btn btn-danger btn-sm">Delete</button>
								</form>
							</td>
						</tr>
						<%
						}
						%>
					</tbody>
				</table>
				<c:if test="${not empty deptstatus}">
					<div class="alert alert-danger mt-4" role="alert">${deptstatus}</div>
				</c:if>


			</div>
		</div>
	</div>
	<h1></h1>

</body>
</html>