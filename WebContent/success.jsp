<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.org.java.dto.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success</title>
</head>
<body>
<h3>Login SuccessFull...!!!!</h3>

<%
 String user = (String) session.getAttribute("user");

%>

 Hello <%= user %>!
 
 <%--
 Hello JSTL : <jsp:getProperty property="userName" name="user"/>
  --%>
</body>
</html>