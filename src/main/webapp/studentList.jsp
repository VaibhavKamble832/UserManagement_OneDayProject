<%@page import="com.pojo.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Details</title>

<% List<Student> slist = (List<Student>)session.getAttribute("slist"); %>

<link rel="stylesheet" href="Resources/css/style.css">
</head>
<body>

<div id="leftnav">
	<jsp:include page="leftside.jsp"></jsp:include>
	
</div>


<div id="main">

	<h1>STUDENT DETAILS</h1>
	
	<form action="StudentServlet" method="post" style="display: flex; flex-direction: row; justify-content: center; align-items: flex-start;">
		<input type="hidden" name="action" value="searchStudent">
		
		<input type="text" name="searchName" placeholder="Search student by name...." style="margin-right: 10px">
		<input type="submit" value="search" style="background-color: #363062; color: white; cursor: pointer;">
	
	</form>
	
	<table border="2" cellpadding="15" cellspacing="15" style="border-collapse: collapse; margin-left: 27%;">
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>CONTACT</th>
			<th>EMAIL</th>
			<th>PASSWORD</th>
			<th colspan="2">ACTION</th>
		</tr>
		
		<%for(Student s:slist) {%>
			<tr>
				<td><%=s.getId() %></td>
				<td><%=s.getName() %></td>
				<td><%=s.getContact() %></td>
				<td><%=s.getEmail() %></td>
				<td><%=s.getPassword() %></td>
				<td><a href="StudentServlet?action=delete&&id=<%=s.getId()%>">Delete</a></td>
				<td><a href="StudentServlet?action=edit&&id=<%=s.getId()%>">Edit</a></td>
			</tr>
		<%} %>
	</table>

</div>


</body>
</html>