<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update User</title>
</head>
<body>
	<%
 String user = (String) session.getAttribute("user");
	%>
 Hello <%= user %>!
		<div>
	    <form method="POST" action='CrudController' name="frmAddUser">   
	    <table align="center">
	    	<tr>
				<td>User ID :</td>
				<td><input type="text"readonly="readonly" name="userId" value="${user.userid}" /></td>    	
	    	</tr>
	    	<tr>
				<td>First Name :</td>
				<td><input type="text" name="firstname" value="${user.firstName}" /></td>    	
	    	</tr>
	    	<tr>
				<td>Last Name :</td>
				<td><input type="text" name="lastname" value="${user.lastName}" /></td>    	
	    	</tr>
	    	<tr>
				<td>Email :</td>
				<td><input type="text" name="email" value="${user.email}" /></td>    	
	    	</tr>
	    	<tr>
				<td></td>
				<td><input type="submit" value="Submit" /></td>    	
	    	</tr>
	    </table>
    </form>
</div>
</body>
</html>