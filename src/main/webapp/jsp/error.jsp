<%@page import="com.capstone.mvc.hrms.exception.HrmsException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
HrmsException ex=(HrmsException)request.getAttribute("exception");
%>
<h3>Sorry an exception occured!</h3> Exception is: <%= ex.getErrorCode() %>
</body>
</html>