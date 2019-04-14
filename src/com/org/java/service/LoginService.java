package com.org.java.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;

import org.apache.catalina.startup.SetAllPropertiesRule;

import com.org.java.database.DatabaseConnection;
import com.org.java.dto.User;

public class LoginService {
	
	String username ,password;
	Connection conn;
	Statement stmt;
	ResultSet rs;
	DatabaseConnection db;
	User user = new User();
	public LoginService()
	{}
	/*
	public boolean authenticate(String username , String password)
	{
		if(( ! (username.equals(null) || username.equals("")) && !(password.equals(null) || password.equals(""))))
		{
			if(username.equals(user.getUsername()) && password.equals(user.getPassword()))
			{
				try {
				String query = "select * from login where username ='"+username+"' and password ='"+password+"'";
				db = new DatabaseConnection();
				conn = db.setConnection();
				
					stmt = conn.createStatement();
					 res = db.getResult(query, conn);
					 if(res.next())
					 {
						 	System.out.println("inside");
							//session.setAttribute("sessionUserName",username);
						 	 user.setUsername(res.getString(username));
							 user.setPassword(res.getString(password));
					 }
					 
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			return true;
		}
		
	}*/
	
	  public boolean authenticate(String username, String password) throws Exception {
	       boolean isvalid = false;
	       db = new DatabaseConnection();
			conn = db.setConnection();
			String query ="select * from login where username=? and password=?";
	       try {
	        
	         PreparedStatement prepStmt = conn.prepareStatement(query);
	         prepStmt.setString(1, username);
	         prepStmt.setString(2, password);
	         ResultSet rs = prepStmt.executeQuery();
	         if(rs.next()) {
	           System.out.println("User login is valid in DB");
	           isvalid = true; 
	         }else
	         {
	        	 System.out.println("User login is In Valid in DB");
		           isvalid = false;
	         }
	      } catch(Exception e) {
	        System.out.println("validateLogon: Error while validating password: "+e.getMessage());
	        throw e;
	      } finally {
	         conn.close();
	      }
		return isvalid;
	    }
	/*public  User getUser(String userId)
	{
		//String query = "select * from login where id =" +userId;
		user = new User();
		String query = "select * from login where id = '" + userId + "' ";
		if(( ! (username.equals(null) || username.equals("")) && !(password.equals(null) || password.equals(""))))
		
		try {
			db = new DatabaseConnection();
			conn = db.setConnection();
			stmt = conn.createStatement();
			
			 res = db.getResult(query, conn);
			 if(res.next())
			 {
				 user.setId(userId);
				 user.setUsername(res.getString(userId));
				 user.setPassword(res.getString("password"));
			 }
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
		 	}
*/
}
