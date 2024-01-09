<%@page import="com.pojo.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>

<% Student student = (Student)session.getAttribute("student"); %>

</head>
<body>

	<div id="leftnav">
		<h1>One Day <br>Project</h1>
		
		<a href="index.jsp">Home</a>
		
			<%if(student!=null) {%>
				<a href="StudentServlet">UserList</a>
				<a href="StudentServlet?action=logout">Log Out</a>
			<%} %>
			
			<%if(student==null) {%>
				<a href="register.jsp">Register</a>
				<a href="login.jsp">Log In</a>
			<%} %>
			
		
	</div>

</body>
</html>