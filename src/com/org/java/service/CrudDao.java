package com.org.java.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.org.java.database.DatabaseConnection;
import com.org.java.dto.Users;

public class CrudDao {
		
	Connection conn = null;
	Statement statement;
	ResultSet rs;
	DatabaseConnection db;
	PreparedStatement preparedStatement = null;
	
	public void addUser(Users user) {
		
		  try 
		  {
		  db = new DatabaseConnection();
	 	   conn = db.setConnection();
		   PreparedStatement preparedStatement = conn.prepareStatement("insert into users(userid ,firstname,lastname,email) values (?, ?, ?,? )");
		   preparedStatement.setInt(1, user.getUserid());
		   preparedStatement.setString(2, user.getFirstName());
		   preparedStatement.setString(3, user.getLastName());
		   preparedStatement.setString(4, user.getEmail());
		   preparedStatement.executeUpdate();
		  } 
		  catch (SQLException e) 
		  {
		   e.printStackTrace();
		  }
		  finally {
	            try {
	                if (preparedStatement != null) {
	                	preparedStatement.close();
	                }
	                if (conn != null) {
	                    conn.close();
	                }
	            } catch (SQLException ex) {
	                
	            }
	        }
		 }

	 public void deleteUser(int userId) {
		 
		   try
		   {
			   db = new DatabaseConnection();
		 	   conn = db.setConnection();
		 	  statement = conn.createStatement();
		 	 statement.execute("DELETE FROM users WHERE userid=" + String.valueOf(userId));
		    //PreparedStatement preparedStatement = conn.prepareStatement("delete from users where userid=?");
		   // preparedStatement.setString(1, userId);
		    //preparedStatement.executeUpdate();
		   } catch (SQLException e)
		   {
		    e.printStackTrace();
		   }
		   finally {
	            try {
	                if (statement != null) {
	                	statement.close();
	                }
	                if (conn != null) {
	                    conn.close();
	                }
	            } catch (SQLException ex) {
	                
	            }
	        }
		  }

	 public void updateUser(Users user) {
		 
		   try {
			   db = new DatabaseConnection();
		 	   conn = db.setConnection();
		    PreparedStatement preparedStatement = conn.prepareStatement("update users set firstname=?, lastname=?, email=?  where userid=?");
		    preparedStatement.setString(1, user.getFirstName());
		    preparedStatement.setString(2, user.getLastName());
		    preparedStatement.setString(3, user.getEmail());
		    preparedStatement.setInt(4, user.getUserid());
		    preparedStatement.executeUpdate();
		   } catch (SQLException e) {
		    e.printStackTrace();
		   }
		   finally {
	            try {
	                if (preparedStatement != null) {
	                	preparedStatement.close();
	                }
	                if (conn != null) {
	                    conn.close();
	                }
	            } catch (SQLException ex) {
	                
	            }
	        }
		  }

	 public List<Users> getAllUsers() {
		 
		   List<Users> users = new ArrayList<Users>();
		   try {
			   db = new DatabaseConnection();
		 	   conn = db.setConnection();
		    Statement statement = conn.createStatement();
		    ResultSet rs = statement.executeQuery("select * from users ORDER BY userid");
		    while (rs.next()) {
		     Users user = new Users();
		     user.setUserid(rs.getInt("userid"));
		     user.setFirstName(rs.getString("firstname"));
		     user.setLastName(rs.getString("lastname"));
		     user.setEmail(rs.getString("email"));
		     users.add(user);
		    }
		   } catch (SQLException e) {
		    e.printStackTrace();
		   }
		   finally {
	            try {
	                if (statement != null) {
	                	statement.close();
	                }
	                if (conn != null) {
	                    conn.close();
	                }
	            } catch (SQLException ex) {
	                
	            }
	        }
		   return users;
		  }

	 public Users getUserById(int userId) {
		 
		   Users user = new Users();
		 
		   try {
			   db = new DatabaseConnection();
		 	   conn = db.setConnection();
		   // PreparedStatement preparedStatement = conn.prepareStatement("select * from users where userid=?");
		    //preparedStatement.setString(1, userId);
		 	  statement = conn.createStatement();
	            ResultSet rs = statement.executeQuery("SELECT * FROM users WHERE userid=" + userId);
		    //ResultSet rs = preparedStatement.executeQuery();
		    if (rs.next()) {
		     user.setUserid(rs.getInt("userid"));
		     user.setFirstName(rs.getString("firstname"));
		     user.setLastName(rs.getString("lastname"));
		     user.setEmail(rs.getString("email"));
		 
		    }
		   } catch (SQLException e) {
		    e.printStackTrace();
		   }
		   finally {
	            try {
	                if (statement != null) {
	                	statement.close();
	                }
	                if (conn != null) {
	                    conn.close();
	                }
	            } catch (SQLException ex) {
	               
	            }
	        }
		   return user;
		  }
}
