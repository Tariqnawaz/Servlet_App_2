<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<%
 String user = (String) session.getAttribute("user");
	%>
 Hello <%= user %>!
	<h6>in this we have develop a create update delete using different controller and view</h6>
	
	<h4>:::::::Employees:::::::</h4>
	<ul>
		<li><a href="empView.jsp">Create New Employee</a></li>
	</ul>
	
	<h6>in this we have develop a create update delete using 1 controller and different view</h6>
	
	<h4>:::::::User:::::::</h4>
	<ul>
		<li><a href="listUser.jsp">Create New Employee</a></li>
	</ul>
</body>
</html>