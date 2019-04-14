<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
    <%@page import="com.org.java.dto.Users"%>
    <%@page import="com.org.java.service.CrudDao"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show All User</title>
</head>
<body>
<%
 String user = (String) session.getAttribute("user");
	%>
 Hello <%= user %>!
	<%-- to develop this page we have develope a page like : 
1st start with controller : CrudController
2nd service : CrudDao
3rd dto : Users
4 view :  addUser, user,listView
 --%>
		<div>
    <table border="1" align="center" style="width:50%">
        <thead>
            <tr>
                <th>User Id</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
        	
			        <c:forEach items ="${users}" var ="user">
            
                <tr>
                    <td>${user.userid}</td>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.email}</td>
                    <td><a href="CrudController?action=edit&userId=${user.userid}">Update</a></td>
                    <td><a href="CrudController?action=delete&userId=${user.userid}">Delete</a></td>
                </tr>
           </c:forEach>
        </tbody>
    </table>
    <p><a href="CrudController?action=insert">Add User</a></p>
    </div>
</body>
</html>