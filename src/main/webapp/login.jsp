<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>

<% String LoginMsg = (String)request.getAttribute("loginMsg"); %>

<link rel="stylesheet" href="Resources/css/style.css">
</head>
<body>

<div id="leftnav">
	<jsp:include page="leftside.jsp"></jsp:include>
	
</div>


<div id="main">

	<h1>Login Student</h1>
	
	<%if(LoginMsg!=null) {%>
		<h2 style="color: red; margin-bottom: 20px"><%=LoginMsg %></h2>
	<%} %>
	
	<form action="StudentServlet" method="post">
		<input type="hidden" name="action" value="loginStudent">
	
		<input type="email" placeholder="Email:" name="email" required="required">
		<input type="password" placeholder="Password:" name="password" required="required">
		<input style="background-color: #363062; color: white; cursor: pointer;" type="submit" value="Log In">
	</form>	

</div>

</body>
</html>