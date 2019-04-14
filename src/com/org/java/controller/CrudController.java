package com.org.java.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.org.java.dto.Users;
import com.org.java.service.CrudDao;


public class CrudController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static  String ADD_USER = "/addUser.jsp";
	private static  String INSERT_OR_EDIT = "/user.jsp";
	private static  String LIST_USER = "/listUser.jsp";
	CrudDao dao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 dao = new CrudDao();
		 String forward="";
		   if(request.getParameter("action")!=null){
		         String action = request.getParameter("action");
		         if (action.equalsIgnoreCase("delete")){
		             int userId =Integer.parseInt(request.getParameter("userId"));
		             dao.deleteUser(userId);
		             forward = LIST_USER;
		             
		             request.setAttribute("users", dao.getAllUsers());   
		         } else if (action.equalsIgnoreCase("edit")){
		             forward = INSERT_OR_EDIT;
		             int userId =Integer.parseInt(request.getParameter("userId"));
		             Users user = dao.getUserById(userId);
		             request.setAttribute("user", user);
		         } else if (action.equalsIgnoreCase("listUser")){
		             forward = LIST_USER;
		             request.setAttribute("users", dao.getAllUsers());
		         }
		         else {
		             forward = ADD_USER;
		         }
		   }
		   else{
		    forward = LIST_USER;
		             request.setAttribute("users", dao.getAllUsers());
		   }
		         RequestDispatcher view = request.getRequestDispatcher(forward);
		         view.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 dao = new CrudDao();
		Users user = new Users();
		         user.setFirstName(request.getParameter("firstname"));
		         user.setLastName(request.getParameter("lastname"));       
		         user.setEmail(request.getParameter("email"));
		         String userId = request.getParameter("userId");
		         if(userId == null || userId.isEmpty())
		         {
		             dao.addUser(user);
		         }
		         else
		         {
		             user.setUserid(Integer.parseInt(userId));
		             try {
		     dao.updateUser(user);
		    } catch (Exception e) {   
		    	
		     e.printStackTrace();
		    }
		         }
		         RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
		         request.setAttribute("users", dao.getAllUsers());
		         view.forward(request, response);
	}

}
