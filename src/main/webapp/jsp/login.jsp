<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
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
	<%@ include file="./header.jsp"%>
	<div class="container mt-5">
		<div class="row">
			<div class="col-12">	
			
				<form name="loginForm" method="POST" action="<%= request.getContextPath()%>/LoginController?action=login">
					<div class="row">
						<div class="col-sm-5 form-group">
							<label for="usernameText">User Login</label> <input type="text"
								class="form-control" id="usernameText" name="username"
								placeholder="Enter username" required>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-5 form-group">
							<label for="passwordText">Password</label> <input type="password"
								class="form-control" id="passwordText" name="password"
								placeholder="Password" required>
						</div>
					</div>
					<div class="row">
						<div class="col-12">
							<button type="submit" class="btn btn-primary">Submit</button>
							<button type="reset" class="btn btn-reset">Clear</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<c:if test="${not empty exception}">
			<div class="alert alert-danger mt-4" role="alert">${exception}</div>
		</c:if>
	</div>
</body>
</html>