<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP Page</title>
</head>
<body>
	<center>
        <div id="mystyle" style="border: none;">
            <h1>JDBC, JSP, Servlet Tutorial</h1>
            <p>
                <b>Creating Data centric Application with JSP Servlet</b><br/>
                <%=new Date()%></br>  </br>
                <a href="empAddNew.jsp">Add New Employee</a> &NegativeThickSpace; |
                <a href="empView.jsp">View Employee</a>
            </p>
        </div>
    </center>
</body>
</html>