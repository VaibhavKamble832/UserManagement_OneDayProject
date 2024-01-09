<%@page import="com.pojo.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<% Student student = (Student)session.getAttribute("student"); %>

<link rel="stylesheet" href="Resources/css/style.css">
</head>
<body>

<div id="leftnav">
	<jsp:include page="leftside.jsp"></jsp:include>
	
</div>

<div id="main">
	
	<%if(student!=null) {%>
		<h1>Welcome<br><span style="font-size: 55px;"><%=student.getName() %></span></h1>
	<%} else{%>
		<h1>WELCOME TO ONE DAY PROJECT <br> By VAIBHAV KAMBLE </h1>
	<%} %>
</div>


</body>
</html>