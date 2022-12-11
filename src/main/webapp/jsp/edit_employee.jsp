<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.stream.Collectors"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
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
	String str = request.getParameter("employee");

	
	Map<String, String> hmap = Arrays.stream(str.split(",")).map(s -> s.split("="))
			.collect(Collectors.toMap(s -> s[0].trim(), s -> s[1].trim()));
	%>
	<div class="container mt-5">
		<div class="row">
			<div class="col-12">
				<div class="alert alert-info mt-4" role="alert">
					Welcome
					<%=userLogin.getUser_name()%></div>
				<c:if test="${not empty exception}">
					<div class="alert alert-danger mt-4" role="alert">${exception}</div>
				</c:if>
				<form name="addEmp" method="POST"
					action="<%=request.getContextPath()%>/EmployeeController?action=edit">
					<div class="form-group row">
						<label for="inputEid" class="col-sm-2 col-form-label">Employee
							id</label>
						<div class="col-sm-5">
							<input type="text" class="form-control" id="inputEid"
								name="empid" placeholder="Employee Id" required value="<%= hmap.get("empId") %>" disabled />
								<input type="hidden" name="empid" value="<%= hmap.get("empId") %>" />
						</div>
					</div>
					<div class="form-group row">
						<label for="inputname" class="col-sm-2 col-form-label">Employee
							Name</label>
						<div class="form-check-inline col-sm-9">
							<input type="text" class="form-control ml-3" id="inputname"
								placeholder="First Name" name="fname" required value="<%= hmap.get("fname") %>"> <input
								type="text" class="form-control ml-2" id="inputname"
								placeholder="Middle Name" name="mname" value="<%= hmap.get("mname") %>"> <input
								type="text" class="form-control ml-2" id="inputname"
								placeholder="Last Name" name="lname" required value="<%= hmap.get("lname") %>">
						</div>
					</div>
					<div class="form-group row">
						<label for="inputEmail" class="col-sm-2 col-form-label">Email</label>
						<div class="col-sm-5">
							<input type="email" class="form-control" id="inputemail"
								name="email" placeholder="Email" required value="<%= hmap.get("email") %>">
						</div>
					</div>
					<div class="form-group-row">
						<label for="genderradio" class="col-sm-2 col-form-label">Gender</label>
						<div class="form-check form-check-inline" id="genderradio">
							<input class="form-check-input" type="radio" name="gender"
								id="inlineRadio1" value="male" required> <label
								class="form-check-label" for="inlineRadio1">male</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="gender"
								id="inlineRadio2" value="female"> <label
								class="form-check-label" for="inlineRadio2">female</label>
						</div>
					</div>
					<div class="form-group row">
						<label for="inputdob" class="col-sm-2 col-form-label">Date
							of Birth</label>
						<div class="col-sm-5">
							<input type="date" class="form-control" id="inputdob" name="dob"
								required value="<%= hmap.get("DOB") %>">
						</div>
					</div>
					<div class="form-group row">
						<label for="inputAddress1" class="col-sm-2 col-form-label">Address
							Line1</label>
						<div class="col-sm-5">
							<input type="text" class="form-control" id="inputAddress1"
								placeholder="Address line 1" name="address1" required value="<%= hmap.get("homeaddress_line1") %>">
						</div>
					</div>
					<div class="form-group row">
						<label for="inputAddress2" class="col-sm-2 col-form-label">Address
							Line2</label>
						<div class="col-sm-5">
							<input type="text" class="form-control" id="inputAddress2"
								placeholder="Address line 2" name="address2" required  value="<%= hmap.get("homeaddress_line2") %>">
						</div>
					</div>
					<div class="form-group row">
						<label for="inputStreet" class="col-sm-2 col-form-label">Street</label>
						<div class="col-sm-5">
							<input type="text" class="form-control" id="inputStreet"
								placeholder="Street" name="street" required  value="<%= hmap.get("homeaddress_street") %>">
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-md-5">
							<label for="inputCity">City</label> <input type="text"
								class="form-control" id="inputCity" name="city" required  value="<%= hmap.get("homeaddress_city") %>">
						</div>
						<div class="form-group col-md-4">
							<label for="inputState">State</label> <input type="text"
								class="form-control" id="inputCity" name="state" required  value="<%= hmap.get("homeaddress_state") %>">
						</div>
						<div class="form-group col-md-2">
							<label for="inputZip">Zip</label> <input type="text"
								class="form-control" id="inputZip" name="zip" required  value="<%= hmap.get("zip") %>">
						</div>
					</div>
					<div class="form-group row">
						<label for="designation" class="col-sm-2 col-form-label">Designation</label>
						<div class="col-sm-5">
							<input type="text" class="form-control" id="designation"
								name="designation" placeholder="Designation" required  value="<%= hmap.get("designation") %>">
						</div>
					</div>

					<div class="form-group-row">
						<label for="roleradio" class="col-sm-2 col-form-label">Role</label>
						<div class="form-check form-check-inline" id="roleradio">
							<input class="form-check-input" type="radio" name="role"
								id="inlineRadio1" value="1" required> <label
								class="form-check-label" for="inlineRadio1" >Admin</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="role"
								id="inlineRadio2" value="2"> <label
								class="form-check-label" for="inlineRadio2">Employee</label>
						</div>
					</div>
					<div class="form-group row">
						<label for="deptid" class="col-sm-2 col-form-label">Department
							Number</label>
						<div class="col-sm-5">
							<input type="text" class="form-control" id="deptid" name="deptid"
								placeholder="Department Number" required  value="<%= hmap.get("department_id") %>">
						</div>
					</div>
					<div class="form-group row">
						<label for="contno" class="col-sm-2 col-form-label">Contact
							Number</label>
						<div class="col-sm-5">
							<input type="text" class="form-control" id="contno" name="contno"
								placeholder="Contact Number" required value="<%= hmap.get("phonenumber") %>">
						</div>
					</div>
					<div class="form-group row">
						<label for="inputhd" class="col-sm-2 col-form-label">Hire
							Date</label>
						<div class="col-sm-5">
							<input type="date" class="form-control" id="inputhd"
								name="hiredate" required value="<%= hmap.get("hire_date") %>">
						</div>
					</div>
					<div class="form-group row">
						<label for="workloc" class="col-sm-2 col-form-label">Work
							Location</label>
						<div class="col-sm-5">
							<select class="form-control" id="workloc" name="workloc">
								<option value="mng01">Mangalore 01</option>
								<option value="mng03">Mangalore 03</option>
								<option value="bng02">Bangalore</option>
							</select>
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
	</div>
</body>
</html>