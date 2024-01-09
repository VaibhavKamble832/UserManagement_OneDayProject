<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link rel="stylesheet" href="Resources/css/style.css">
</head>
<body>

<div id="leftnav">
	<jsp:include page="leftside.jsp"></jsp:include>
	
</div>
<div id="main">

	<h1>Register Student</h1>
	
	<form action="StudentServlet" method="post">
		<input type="hidden" name="action" value="registerStudent">
		
		<input type="text" placeholder="Name:" name="name" required="required">
		<input type="text" placeholder="Contact:" name="contact" required="required">
		<input type="email" placeholder="Email:" name="email" required="required">
		<input type="password" placeholder="Password:" name="password" required="required">
		<input style="background-color: #363062; color: white; cursor: pointer;" type="submit" value="Register">
	</form>	

</div>

</body>
</html>