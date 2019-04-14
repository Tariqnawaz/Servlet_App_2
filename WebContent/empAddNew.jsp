<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@page import="com.org.java.dto.Employee"%>
    <%@page import="com.org.java.service.EmployeeBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="style.css" rel="stylesheet" type="text/css"/>
        <title>New Employee</title>
</head>
<body>
	<%@include file="header.jsp"%>
		<%
 String user = (String) session.getAttribute("user");
	%>
 Hello <%= user %>!
        <form method="post" action="AddNewServlet">
            <div id="mystyle" class="myform">
              <!-- <form id="form" name="form" action="AddNewEmployee" method="post"> -->  
                    <h1>Employee</h1>
                    <p>To add new Employee enter following information</p>
                    <label>Employee ID<span class="small">Enter Employee ID</span></label>
                    <input type="text" name="empId" id="empId" />
                    <label>Name<span class="small">Enter name</span></label>
                    <input type="text" name="empName" id="empName" />
                    <label>Phone<span class="small">Enter phone number</span></label>
                    <input type="text" name="phone" id="phone"  />
                    <label>Email<span class="small">Enter email address</span></label>
                    <input type="text" name="email" id="email"/>
                    <label>Salary<span class="small">Enter salary</span></label>
                    <input type="text" name="salary" id="salary" />
                    <label>Designation<span class="small">Enter designation</span></label>
                    <input type="text" name="designation" id="designation"/>                            
                    <button type="submit">Add New Employee</button>
                    <div class="spacer"></div>
                <!-- </form>-->
            </div>
        </form>    
</body>
</html>