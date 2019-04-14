package com.org.java.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.org.java.dto.Employee;
import com.org.java.service.EmployeeBean;

/**
 * Servlet implementation class AddNewServlet
 */
public class AddNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Employee emp = new Employee();
        emp.setEmpId(Integer.parseInt(request.getParameter("empId")));
        emp.setEmpName(request.getParameter("empName"));
        emp.setPhone(request.getParameter("phone"));
        emp.setEmail(request.getParameter("email"));
        emp.setSalary(Float.parseFloat(request.getParameter("salary")));
        emp.setDesignation(request.getParameter("designation"));
        EmployeeBean eb = new EmployeeBean();
        if(emp.getEmpId() > 0)
        {
        eb.addNew(emp);
        System.out.println("Data Updated SuccessFully");
        }
        else
        {
        	eb.addNew(emp);
            System.out.println("Data Added SuccessFully");
            	
        }
        
        response.sendRedirect("empView.jsp");
	}

}
