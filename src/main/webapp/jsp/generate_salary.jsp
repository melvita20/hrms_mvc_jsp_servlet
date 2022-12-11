<%@page import="java.time.LocalDate"%>
<%@page import="java.sql.Date"%>
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

	<div class="container mt-5">
		<div class="row">
			<div class="col-12">
				<c:if test="${not empty exception}">
					<div class="alert alert-danger mt-4" role="alert">${exception}</div>
				</c:if>
				<%
					UserLogin userLogin = (UserLogin) session.getAttribute("userinfo");
					Employee emp = (Employee) request.getAttribute("SalaryDetails");
					%>
				<c:if test="${empty exception}">

					<%
					LocalDate dt = LocalDate.now();
					List<Salary> sal = emp.getSalary();
					%>
					<table class="table mt-4">
						<thead>
							<tr>
								<th colspan="4" class="text-center"><b>Salary Slip</b></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="font-weight-bold"><%=emp.getEmpId()%></td>
								<td class="font-weight-bold"><%=emp.getFname() + " " + emp.getMname() + " " + emp.getLname()%></td>
								<td></td>
								<td class="font-weight-bold"><%=dt%></td>
							</tr>
							<%
							for (Salary sal_item : sal) {
							%>

							<tr>
								<td class="font-weight-bold">Basic Salary</td>
								<td><%=sal_item.getBASIC()%></td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td class="font-weight-bold">DA</td>
								<td><%=sal_item.getDA()%></td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td class="font-weight-bold">HRA</td>
								<td><%=sal_item.getHRA()%></td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td class="font-weight-bold">Gross Salary</td>
								<td><%=sal_item.getGross_salary()%></td>
								<td></td>
								<td></td>
							</tr>

							<tr>
								<td class="font-weight-bold">Income Tax</td>
								<td><%=sal_item.getIncometax()%></td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td class="font-weight-bold">Net Salary</td>
								<td><%=sal_item.getNetsalary()%></td>
								<td></td>
								<td></td>
							</tr>
							<%
							}
							%>
						</tbody>
					</table>
				</c:if>

			</div>

		</div>
	</div>


</body>
</html>