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
	<div class="container mt-5">
		<div class="row">
			<div class="col-12">
				<c:if test="${loggedOut}">
					<div class="alert alert-info mt-4" role="alert">Logged out
						successfully</div>
				</c:if>
			</div>
		</div>
	</div>

</body>
</html>