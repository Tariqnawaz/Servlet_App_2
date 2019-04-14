package com.org.java.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.java.dto.User;

import com.org.java.database.DatabaseConnection;
import com.org.java.service.LoginService;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username ,password , id;
		String usernameDB , passwordDB ;
		Connection conn;
		Statement stmt;
		ResultSet res;
		PreparedStatement ps;
		DatabaseConnection db;
		String strErrMsg = null;
		
		username = request.getParameter("username");
		password = request.getParameter("password");
		HttpSession session = request.getSession();
		LoginService loginService = new LoginService();
		boolean result;
		try {
			result = loginService.authenticate(username, password);
			if (result)
			 {
				 //User user = loginService.getUserDetails(userId);
				 session.setAttribute("user", username);
				 RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
				 //RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
				 dispatcher.forward(request, response);
				//request.getSession().setAttribute("user",user);
				 //response.sendRedirect("success.jsp");
				 return;
			 }
			else
			 {	
				strErrMsg = "User name or Password is invalid. Please try again.";
				
				 session.setAttribute("error", strErrMsg);
				 response.sendRedirect("Login.jsp");
				 
			 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 
		}
		
		
		 
	}

}
