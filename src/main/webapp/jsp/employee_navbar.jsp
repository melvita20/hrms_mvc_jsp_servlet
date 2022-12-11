<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HRMS</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand">HRMS</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
			<div class="navbar-nav">
				<a class="nav-item nav-link active"
					href="<%= request.getContextPath()%>/EmployeeController?action=viewprofile">View
					Details <span class="sr-only">(current)</span>
				</a> <a class="nav-item nav-link" href="<%= request.getContextPath()%>/EmployeeController?action=viewsalary">View
					PaySlip</a>
			</div>
		</div>
		<div class="nav justify-content-end">
			<a class="nav-item nav-link" href="./LoginController?action=logout">Logout</a>			
		</div>
	</nav>
</body>
</html>