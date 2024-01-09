<%@page import="com.pojo.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Student</title>

<% Student s = (Student)session.getAttribute("student"); %>

<link rel="stylesheet" href="Resources/css/style.css">
</head>
<body>

<div id="leftnav">
	<jsp:include page="leftside.jsp"></jsp:include>
</div>

<div id="main">
	<h1>Update Student</h1>
	
	<form action="StudentServlet" method="post">
		<input type="hidden" name="action" value="updateStudent">
		
		<input type="text"  name="id" value="<%=s.getId() %>" required="required">
		<input type="text" name="name" value="<%=s.getName() %>" required="required">
		<input type="text" name="contact" value="<%=s.getContact() %>" required="required">
		<input type="email" name="email" value="<%=s.getEmail() %>" required="required">
		<input type="password"  name="password" value="<%=s.getPassword() %>" required="required">
		<input style="background-color: #363062; color: white; cursor: pointer;" type="submit" value="Update">
	</form>	
</div>

</body>
</html>