<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.org.java.dto.Employee"%>
    <%@page import="com.org.java.service.EmployeeBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="style.css" rel="stylesheet" type="text/css"/>
        <title>Employee Update Page</title>
</head>
<body>
<%
 String user = (String) session.getAttribute("user");
	%>
 Hello <%= user %>!
	<%@include file="header.jsp"%>
        <%
            int id = Integer.parseInt(request.getParameter("updateId"));
            EmployeeBean eb = new EmployeeBean();
            Employee e = eb.getEmployee(id);
        %>
        <div id="mystyle" class="myform">
            <form id="form" name="form" action="UpdateServlet" method="get">
                <h1>Update Employee ID:<%=e.getEmpId()%></h1>
                <p>Modify the following information to update employee ID:<%=e.getEmpId()%></p>
                <label><input type="hidden" name="empId" id="empId" value="<%=e.getEmpId()%>"/><span class="small"></span></label>                    
                <label>Name<span class="small">Enter name</span></label>
                <input type="text" name="empName" id="empName" value="<%=e.getEmpName()%>"/>
                <label>Phone<span class="small">Enter phone number</span></label>
                <input type="text" name="phone" id="phone" value="<%=e.getPhone()%>"/>
                <label>Email<span class="small">Enter email address</span></label>
                <input type="text" name="email" id="email" value="<%=e.getEmail()%>"/>
                <label>Salary<span class="small">Enter salary</span></label>
                <input type="text" name="salary" id="salary" value="<%=e.getSalary()%>"/>
                <label>Designation<span class="small">Enter designation</span></label>
                <input type="text" name="designation" id="designation" value="<%=e.getDesignation()%>"/>                           
                <button type="submit">Update Employee</button>
                <div class="spacer"></div>
            </form>
        </div>   
</body>
</html>