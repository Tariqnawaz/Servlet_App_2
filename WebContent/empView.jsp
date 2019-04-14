<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
    <%@page import="com.org.java.dto.Employee"%>
    <%@page import="com.org.java.service.EmployeeBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="style.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
</head>
<body>
<%-- to develop this page we have develope a page like : 
1st start with controller : AddNewServlet , DeleteServlet , UpdateServlet
2nd service : EmployeeBean
3rd dto : Employee
4 view :  empAddNew , empUpdate ,empView
 --%>
	<%
 String user = (String) session.getAttribute("user");
	%>
 Hello <%= user %>!
		  <%@include file="header.jsp"%>
        <div align="center">
            <table>
                <thead>
                    <tr>
                        <th>Emp ID</th>
                        <th>Name</th>
                        <th>Phone</th>
                        <th>Email</th>
                        <th>Salary</th>
                        <th>Designation</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        EmployeeBean eb = new EmployeeBean();
                        List<Employee> list = eb.getEmployees();
                        for (Employee e : list) {
                    %>
 
                    <tr>
                        <td><%=String.valueOf(e.getEmpId())%></td>
                        <td><%=e.getEmpName()%></td>
                        <td><%=e.getPhone()%></td>
                        <td><a href="mailto:<%=e.getEmail()%>"><%=e.getEmail()%></a></td>
                        <td><%=String.valueOf(e.getSalary())%></td>
                        <td><%=e.getDesignation()%></td>
                        <td style="border: none;">
                            <div>
                                <form method="post" action="empUpdate.jsp">
                                    <input type="hidden" id="updateId" name="updateId" value="<%=String.valueOf(e.getEmpId())%>"/> 
                                    <input type="submit" value="Modify..."/> 
                                </form>
                            </div>
                        </td>
                        <td style="border: none;">
                            <div>
                                <form method="post" action="DeleteServlet">
                                    <input type="hidden" id="delId" name="delId" value="<%=String.valueOf(e.getEmpId())%>"/> 
                                    <input type="submit" value="Delete"/> 
                                </form>
                            </div>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
</body>
</html>