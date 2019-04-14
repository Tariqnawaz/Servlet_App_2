<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New User</title>
</head>
<body>
<%
 String user = (String) session.getAttribute("user");
	%>
 Hello <%= user %>!
		<div class="centered">
    <form method="POST" action='CrudController' name="frmAddUser">
            <table align="center">
	    	<tr>
				<!--<td>User ID :</td> -->
				<td><input type="hidden"readonly="readonly" name="userId" /></td>    	
	    	</tr>
	    	<tr>
				<td>First Name :</td>
				<td><input type="text" name="firstname"  /></td>    	
	    	</tr>
	    	<tr>
				<td>Last Name :</td>
				<td><input type="text" name="lastname"  /></td>    	
	    	</tr>
	    	<tr>
				<td>Email :</td>
				<td><input type="text" name="email"  /></td>    	
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