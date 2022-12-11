
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@page import="com.capstone.mvc.hrms.domain.UserLogin"%>
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
	<%
	UserLogin userLogin = (UserLogin) session.getAttribute("userinfo");
	if (userLogin.getRole_id() == 1) {
	%>

	<%@ include file="./admin_navbar.jsp"%>
	<%
	} else {
	%>
	<%@ include file="./employee_navbar.jsp"%>

	<%
	}
	%>
	<div class="container mt-5">
		<div class="row">
			<div class="col-12">
				<div class="alert alert-success" role="alert">
					Welcome User <span><%=userLogin.getUser_name()%></span>
				</div>
			</div>
		</div>
	</div>
</body>

</html>